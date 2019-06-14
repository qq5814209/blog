<!--需要获取用户id-->
var userId;
var blogId;
var loginUserId;
function split() {
    userId=window.location.search.split("=")[1].split("&")[0];
    blogId = window.location.search.split("=")[2];
};
split();

function showBlogUser() {
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/findUserDto?userId="+userId,
        contentType:"application/json",
        success:function (data) {
            var b= "<div class=\"profile-intro d-flex\"><div class=\"avatar-box d-flex justify-content-center flex-column\"><a href=\"#\"><img src=\"./image/"+data.url+"\" class=\"avatar_pic\"><img hidden=\"hidden\" src=\"./image/vip.png\" class=\"user-years\"></a></div><div class=\"user-info d-flex justify-content-center flex-column\"><p class=\"name csdn-tracking-statistics tracking-click\" data-mod=\"popu_379\"><a class=\"\" id=\"uid\">"+data.name+"</a></p></div><div class=\"opt-box d-flex justify-content-center flex-column\"><span class=\"csdn-tracking-statistics tracking-click\" data-mod=\"popu_379\"><a class=\"btn btn-sm btn-red-hollow attention\" id=\"btnAttent\">关注</a></span></div></div><div class=\"data-info d-flex item-tiling\"><dl class=\"text-center\" title=\"3\"><dt><a href=\"#\">原创</a></dt><dd><a href=\"#\"><span class=\"count\">"+data.blogNum+"</span></a></dd></dl><dl class=\"text-center\" id=\"fanBox\" title=\"0\"><dt>粉丝</dt><dd><span class=\"count\" id=\"fan\">"+data.careNum+"</span></dd></dl><dl class=\"text-center\" title=\"0\"><dt>喜欢</dt><dd><span class=\"count\">"+data.loveNum+"</span></dd></dl><dl class=\"text-center\" title=\"1\"><dt>评论</dt><dd><span class=\"count\">"+data.commentNum+"</span></dd></dl></div><div class=\"grade-box clearfix\"><dl><dt>等级：</dt><dd>"+data.levelNum+"<a href=\"#\" title=\"1级,点击查看等级说明\"><svg class=\"icon icon-level\" aria-hidden=\"true\"><use xlink:href=\"#csdnc-bloglevel-1\"></use></svg></a></dd></dl><dl><dt>访问：</dt><dd title=\"400\">"+data.seeNum+"</dd></dl><dl><dt>积分：</dt><dd title=\"43\">"+data.levelValue+"</dd></dl><dl title=\"1986512\"><dt>排名：</dt><dd>198万+</dd></dl></div>\n"
            $("#asideProfile").append(b);
        },
        error:function (data) {
        }
    });
};
showBlogUser();
function findLoginUserId() {
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/getUser_id",
        contentType:"application/json",
        success:function (data) {
            loginUserId=data;
        },
        error:function (data) {
        }
    });
};
findLoginUserId();
function showArticle() {
    $("#comment-box").css("display","block");
    $("#blog-content").empty();
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/showArticle",
        data:JSON.stringify({
            "id":blogId,
            "userId":userId
        }),
        contentType:"application/json",
        success:function (data) {
            $.each(data,function (index,item) {
                var d = "<h1 class=\"title-blog\"><a>"+item.name+"的专栏</a></h1><p class=\"description \">个人公众号："+item.userName+"</p>";
                $("#title-box").append(d);
                var b= "<div class=\"article-header-box\"><div class=\"article-header\"><div class=\"article-title-box\"><span class=\"article-type type-1 float-left\">原</span><h1 class=\"title-article\">"+item.title+"</h1></div><div class=\"article-info-box\"><div class=\"article-bar-top\" style=\"height: 56px;\"><span class=\"time\">"+item.time+"</span><a class=\"follow-nickName\" href=\"#\" >"+item.name+"</a><span class=\"read-count\">阅读数："+item.seeNum+"</span></div><div class=\"operating\"></div></div></div></div><article class=\"baidu_pl\"><div  class=\"article_content clearfix csdn-tracking-statistics\" data-pid=\"blog\" data-mod=\"popu_307\" data-dsm=\"post\"><div class=\"article-copyright\">版权声明：本博客由【"+item.name+"】独家发布</div><div class=\"htmledit_views\" id=\"content_views\"><p>&nbsp;"+item.content+"</p></div></div></article>\n";
                $("#blog-content").append(b);
            })
        },
        error:function (data) {
        }
    });

    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/showCommentBox?loginUserId="+loginUserId,
        contentType:"application/json",
        success:function (data) {
            var b="<a id=\"commentsedit\"></a><div class=\"user-img\"><a><img class=\"show_loginbox\" src=\"image/"+data.url+"\"></a></div><textarea class=\"comment-content\" name=\"comment_content\" id=\"comment_content\" placeholder=\"想对作者说点什么\"></textarea><div><div><span id=\"tip_comment\" class=\"tip\">还能输入<em>1000</em>个字符</span><a class=\"btn btn-sm btn-red btn-comment\" value=\"发表评论\" onclick=addComment()></a></div></div>\n";
            $("#comment-edit-box").append(b);
        },
        error:function (data) {
        }
    });
    $("#blog-content").css("display","block");
};
function defaultStyle(){
    if (blogId==null){
        showBlog();
    } else {
        showArticle();
    }
}
defaultStyle();
function addComment() {
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/addComment",
        contentType:"application/json",
        data:JSON.stringify({
            "comment_content":$("#comment_content").val(),
            "user_id":loginUserId,
            "blog_Id":blogId
        }),
        success:function (data) {
        },
        error:function (data) {
        }
    });
};
function classNum(){
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/asideContent?userId="+userId,
        contentType:"application/json",
        success:function (data) {
            $.each(data,function (index,item) {
                var b = "<li onclick=showBlogByClassId("+item.classId+","+item.userId+")><a><span class=\"title oneline\">"+item.className+"</span><span class=\"count float-right\">"+item.classNum+"</span></a></li>";
                $("#aside-class").append(b);
            })
        },
        error:function (data) {
        }
    });

};
classNum();
function archiveList() {
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/archiveList?userId="+userId,
        contentType:"application/json",
        success:function (data) {
            $.each(data,function (index,item) {
                var b = "<li onclick=showBlogByTime("+item.years+","+item.months+","+item.userId+")><a>"+item.years+"年"+item.months+"月<span class=\"count float-right\">"+item.blogNum+"篇</span></a></li>";
                $("#archiveList").append(b);
            })
        },
        error:function (data) {
        }
    });
};
archiveList();

function showBlogByTime(year,month,userId) {
    $("#blog-content").empty();
    $("#breadcrumbsBox").empty();
    $("#blog-content").css("display","none");
    $("#comment-box").css("display","none");
    var c= "<div class=\"breadcrumbs-box\" ><a>全部文章</a><span class=\"ml8 mr8\">></span>"+year+"年"+month+"月</div><dl class=\"filter-sort-box d-flex align-items-center\"><dt>排序：</dt><dd onclick=showBlog()><a >默认</a></dd><dd onclick=showBlogByNewTime()><a>按更新时间</a></dd><dd onclick=showBlogByCommentNum()><a >按访问量</a></dd><dd><a><svg class=\"icon\" aria-hidden=\"true\"><use xlink:href=\"#csdnc-rss\"></use></svg>RSS订阅</a></dd></dl>";
    $("#breadcrumbsBox").append(c);
    $("#breadcrumbsBox").css("display","block");
    $("#articleList").css("display","block");
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/showBlogByTime",
        data:JSON.stringify({
            "years":year,
            "months":month,
            "userId":userId
        }),
        contentType:"application/json",
        success:function (data) {
            $("#articleList").empty();
            $.each(data,function (index,item) {
                var contents = spilt(item.content,item.title);
                var b= "<div class=\"article-item-box csdn-tracking-statistics\" data-articleid=\""+item.id+"\"><h4 class=\"\"><a href='bk_list.html?userId="+item.userId+"&blogId="+item.id+"' target=\"_self\"><span class=\"article-type type-1 float-none\">原</span>"+item.title+"</a></h4><p class=\"content\"><a>"+contents+"</a></p><div class=\"info-box d-flex align-content-center\"><p><span class=\"date\">"+item.time+"</span></p><p class=\"point\"></p><p><span class=\"read-num\">阅读数<span class=\"num\">"+item.seeNum+"</span></span></p><p class=\"point\"></p><p><span class=\"read-num\">评论数<span class=\"num\">"+item.commentNum+"</span></span></p></div></div>";
                $("#articleList").append(b);
            })
        },
        error:function (data) {
        }
    });
};
function showBlogByClassId(classId,userId) {
    $("#blog-content").empty();
    $("#breadcrumbsBox").empty();
    $("#blog-content").css("display","none");
    $("#comment-box").css("display","none");
    var c= "<div class=\"breadcrumbs-box\"><a>全部文章</a><span class=\"ml8 mr8\">></span>用户分类</div><dl class=\"filter-sort-box d-flex align-items-center\"><dt>排序：</dt><dd onclick=showBlog()><a >默认</a></dd><dd onclick=showBlogByNewTime()><a>按更新时间</a></dd><dd onclick=showBlogByCommentNum()><a >按访问量</a></dd><dd><a class=\"btn btn-sm rss\"><svg class=\"icon\" aria-hidden=\"true\"><use xlink:href=\"#csdnc-rss\"></use></svg>RSS订阅</a></dd></dl>";
    $("#breadcrumbsBox").append(c);
    $("#breadcrumbsBox").css("display","block");
    $("#articleList").css("display","block");
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/showBlogByClassId",
        data:JSON.stringify({
            "classId":classId,
            "userId":userId
        }),
        contentType:"application/json",
        success:function (data) {
            $("#articleList").empty();
            $.each(data,function (index,item) {
                var contents = spilt(item.content,item.title);
                var b= "<div class=\"article-item-box csdn-tracking-statistics\" data-articleid=\""+item.id+"\"><h4 class=\"\"><a href='bk_list.html?userId="+item.userId+"&blogId="+item.id+"' target=\"_self\"><span class=\"article-type type-1 float-none\">原</span>"+item.title+"</a></h4><p class=\"content\"><a>"+contents+"</a></p><div class=\"info-box d-flex align-content-center\"><p><span class=\"date\">"+item.time+"</span></p><p class=\"point\"></p><p><span class=\"read-num\">阅读数<span class=\"num\">"+item.seeNum+"</span></span></p><p class=\"point\"></p><p><span class=\"read-num\">评论数<span class=\"num\">"+item.commentNum+"</span></span></p></div></div>";
                $("#articleList").append(b);
            })
        },
        error:function (data) {
        }
    });

};
//查询该博客主的最新评论
function findComment(){
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/findComment?userId="+userId,
        contentType:"application/json",
        success:function (data) {
            $.each(data,function (index,item) {
                var b= "<li><a>"+item.title+"</a><p class=\"comment ellipsis\"><a>"+item.name+"：</a>"+item.comment+"</p></li>";
                $("#commentList").append(b);
            })
        },
        error:function (data) {
        }
    });
};
findComment();
//查询用户最近更新的博客
function showBlogByNewTime() {
    $("#comment-box").empty();
    $("#breadcrumbsBox").empty();
    $("#blog-content").css("display","none");
    $("#comment-box").css("display","none");
    var c= "<div class=\"breadcrumbs-box\"><a>全部文章</a><span class=\"ml8 mr8\">></span>用户分类</div><dl class=\"filter-sort-box d-flex align-items-center\"><dt>排序：</dt><dd onclick=showBlog()><a>默认</a></dd><dd onclick=showBlogByNewTime()><a>按更新时间</a></dd><dd onclick=showBlogByCommentNum()><a >按访问量</a></dd><dd><a class=\"btn btn-sm rss\"><svg class=\"icon\" aria-hidden=\"true\"><use xlink:href=\"#csdnc-rss\"></use></svg>RSS订阅</a></dd></dl>";
    $("#breadcrumbsBox").append(c);
    $("#breadcrumbsBox").css("display","block");
    $("#articleList").css("display","block");

    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/showBlogByNewTime?userId="+userId,
        contentType:"application/json",
        success:function (data) {
            $("#articleList").empty();
            $.each(data,function (index,item) {
                var contents = spilt(item.content,item.title);
                var b= "<div class=\"article-item-box csdn-tracking-statistics\" data-articleid=\""+item.id+"\"><h4 class=\"\"><a href='bk_list.html?userId="+item.userId+"&blogId="+item.id+"' target=\"_self\"><span class=\"article-type type-1 float-none\">原</span>"+item.title+"</a></h4><p class=\"content\"><a>"+contents+"</a></p><div class=\"info-box d-flex align-content-center\"><p><span class=\"date\">"+item.time+"</span></p><p class=\"point\"></p><p><span class=\"read-num\">阅读数<span class=\"num\">"+item.seeNum+"</span></span></p><p class=\"point\"></p><p><span class=\"read-num\">评论数<span class=\"num\">"+item.commentNum+"</span></span></p></div></div>";
                $("#articleList").append(b);
            })
        },
        error:function (data) {
        }
    });
};
//统计每个分类的数量
function showBlogByCommentNum() {
    $("#breadcrumbsBox").empty();
    $("#blog-content").css("display","none");
    $("#comment-box").css("display","none");
    var c= "<div class=\"breadcrumbs-box\"><a>全部文章</a><span class=\"ml8 mr8\">></span>用户分类</div><dl class=\"filter-sort-box d-flex align-items-center\"><dt>排序：</dt><dd onclick=showBlog()><a >默认</a></dd><dd onclick=showBlogByNewTime()><a>按更新时间</a></dd><dd onclick=showBlogByCommentNum()><a>按访问量</a></dd><dd><a class=\"btn btn-sm rss\" href=\"#\"><svg class=\"icon\" aria-hidden=\"true\"><use xlink:href=\"#csdnc-rss\"></use></svg>RSS订阅</a></dd></dl>";
    $("#breadcrumbsBox").append(c);
    $("#breadcrumbsBox").css("display","block");
    $("#articleList").css("display","block");

    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/showBlogByCommentNum?userId="+userId,
        contentType:"application/json",
        success:function (data) {
            $("#articleList").empty();
            $.each(data,function (index,item) {
                var contents = spilt(item.content,item.title);
                var b= "<div class=\"article-item-box csdn-tracking-statistics\" data-articleid=\""+item.id+"\"><h4 class=\"\"><a href='bk_list.html?userId="+item.userId+"&blogId="+item.id+"' target=\"_self\"><span class=\"article-type type-1 float-none\">原</span>"+item.title+"</a></h4><p class=\"content\"><a>"+contents+"</a></p><div class=\"info-box d-flex align-content-center\"><p><span class=\"date\">"+item.time+"</span></p><p class=\"point\"></p><p><span class=\"read-num\">阅读数<span class=\"num\">"+item.seeNum+"</span></span></p><p class=\"point\"></p><p><span class=\"read-num\">评论数<span class=\"num\">"+item.commentNum+"</span></span></p></div></div>";
                $("#articleList").append(b);
            })
        },
        error:function (data) {
        }
    });
};
//默认查询用户
function showBlog() {
    $("#blog-content").empty();
    $("#breadcrumbsBox").empty();
    $("#blog-content").css("display","none");
    $("#comment-box").css("display","none");
    var c= "<div class=\"breadcrumbs-box\"><a>全部文章</a><span class=\"ml8 mr8\">></span>用户分类</div><dl class=\"filter-sort-box d-flex align-items-center\"><dt>排序：</dt><dd onclick=showBlog()><a >默认</a></dd><dd onclick=showBlogByNewTime()><a>按更新时间</a></dd><dd onclick=showBlogByCommentNum()><a>按访问量</a></dd><dd><a class=\"btn btn-sm rss\" ><svg class=\"icon\" aria-hidden=\"true\"><use xlink:href=\"#csdnc-rss\"></use></svg>RSS订阅</a></dd></dl>";
    $("#breadcrumbsBox").append(c);
    $("#breadcrumbsBox").css("display","block");
    $("#articleList").css("display","block");
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/showBlog?userId="+userId,
        contentType:"application/json",
        success:function (data) {
            $("#articleList").empty();
            $.each(data,function (index,item) {
                var contents = spilt(item.content,item.title);
                var b= "<div class=\"article-item-box csdn-tracking-statistics\" data-articleid=\""+item.id+"\"><h4 class=\"\"><a href='bk_list.html?userId="+item.userId+"&blogId="+item.id+"' target=\"_self\"><span class=\"article-type type-1 float-none\">原</span>"+item.title+"</a></h4><p class=\"content\"><a>"+contents+"</a></p><div class=\"info-box d-flex align-content-center\"><p><span class=\"date\">"+item.time+"</span></p><p class=\"point\"></p><p><span class=\"read-num\">阅读数<span class=\"num\">"+item.seeNum+"</span></span></p><p class=\"point\"></p><p><span class=\"read-num\">评论数<span class=\"num\">"+item.commentNum+"</span></span></p></div></div>";
                $("#articleList").append(b);
            })
        },
        error:function (data) {
        }
    });
};
//截取博客的文本的第一段
function spilt(content,title) {

    var s= content.split("</p>")[1]
    if (s==null){
        return title;
    } else {
        return s.replace("<p>","");
    }
};