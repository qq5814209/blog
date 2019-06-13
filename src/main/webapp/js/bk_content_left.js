<!--需要获取用户id-->

function classNum(){
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/asideContent?userId=1",
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
        url:"/archiveList?userId=1",
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
        url:"/findComment?userId=1",
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