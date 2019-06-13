<!--需要获取用户id-->
var userId=1;
var blogId=1;
function split() {
    // userId=window.location.search.split("=")[1].split("&")[0];
    // blogId = window.location.search.split("=")[2];
};
split();
function showArticle() {
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
                var b= "<div class=\"article-header-box\"><div class=\"article-header\"><div class=\"article-title-box\"><span class=\"article-type type-1 float-left\">原</span><h1 class=\"title-article\">"+item.title+"</h1></div><div class=\"article-info-box\"><div class=\"article-bar-top\" style=\"height: 56px;\"><span class=\"time\">"+item.time+"</span><a class=\"follow-nickName\" href=\"#\" target=\"_blank\">"+item.name+"</a><span class=\"read-count\">阅读数："+item.seeNum+"</span></div><div class=\"operating\"></div></div></div></div><article class=\"baidu_pl\"><div  class=\"article_content clearfix csdn-tracking-statistics\" data-pid=\"blog\" data-mod=\"popu_307\" data-dsm=\"post\"><div class=\"article-copyright\">版权声明：本博客由【"+item.name+"】独家发布</div><div class=\"htmledit_views\" id=\"content_views\"><p>&nbsp;"+item.content+"</p></div></div></article>\n";
                $("#blog-content").append(b);
            })
        },
        error:function (data) {
        }
    });
    $("#blog-content").css("display","block");
};
showArticle();

function classNum(){
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/asideContent?userId="+userId,
        contentType:"application/json",
        success:function (data) {
            $.each(data,function (index,item) {
                var b = "<li onclick=showBlogByClassId("+item.classId+","+item.userId+")><a href='#'><span class=\"title oneline\">"+item.className+"</span><span class=\"count float-right\">"+item.classNum+"</span></a></li>";
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
                var b = "<li onclick=showBlogByTime("+item.years+","+item.months+","+item.userId+")><a href=\"#\">"+item.years+"年"+item.months+"月<span class=\"count float-right\">"+item.blogNum+"篇</span></a></li>";
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
    var c= "<div class=\"breadcrumbs-box\" ><a href=\"#\">全部文章</a><span class=\"ml8 mr8\">></span>"+year+"年"+month+"月</div><dl class=\"filter-sort-box d-flex align-items-center\"><dt>排序：</dt><dd><a >默认</a></dd><dd onclick=showBlogByNewTime()><a>按更新时间</a></dd><dd><a >按访问量</a></dd><dd><a class=\"btn btn-sm rss\" href=\"#\"><svg class=\"icon\" aria-hidden=\"true\"><use xlink:href=\"#csdnc-rss\"></use></svg>RSS订阅</a></dd></dl>";
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
                var b= "<div class=\"article-item-box csdn-tracking-statistics\" data-articleid=\""+item.id+"\"><h4 class=\"\"><a href=\"#\" target=\"_blank\"><span class=\"article-type type-1 float-none\">原</span>"+item.title+"</a></h4><p class=\"content\"><a href=\"#\" target=\"_blank\">"+item.content+"</a></p><div class=\"info-box d-flex align-content-center\"><p><span class=\"date\">"+item.time+"</span></p><p class=\"point\"></p><p><span class=\"read-num\">阅读数<span class=\"num\">"+item.seeNum+"</span></span></p><p class=\"point\"></p><p><span class=\"read-num\">评论数<span class=\"num\">"+item.commentNum+"</span></span></p></div></div>";
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
    var c= "<div class=\"breadcrumbs-box\"><a href=\"#\">全部文章</a><span class=\"ml8 mr8\">></span>用户分类</div><dl class=\"filter-sort-box d-flex align-items-center\"><dt>排序：</dt><dd><a >默认</a></dd><dd><a>按更新时间</a></dd><dd><a >按访问量</a></dd><dd><a class=\"btn btn-sm rss\" href=\"#\"><svg class=\"icon\" aria-hidden=\"true\"><use xlink:href=\"#csdnc-rss\"></use></svg>RSS订阅</a></dd></dl>";
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
                var b= "<div class=\"article-item-box csdn-tracking-statistics\" data-articleid=\""+item.id+"\"><h4 class=\"\"><a href=\"#\" target=\"_blank\"><span class=\"article-type type-1 float-none\">原</span>"+item.title+"</a></h4><p class=\"content\"><a href=\"#\" target=\"_blank\">"+item.content+"</a></p><div class=\"info-box d-flex align-content-center\"><p><span class=\"date\">"+item.time+"</span></p><p class=\"point\"></p><p><span class=\"read-num\">阅读数<span class=\"num\">"+item.seeNum+"</span></span></p><p class=\"point\"></p><p><span class=\"read-num\">评论数<span class=\"num\">"+item.commentNum+"</span></span></p></div></div>";
                $("#articleList").append(b);
            })
        },
        error:function (data) {
        }
    });

};
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
function showBlogByNewTime() {
}