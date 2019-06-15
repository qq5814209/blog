$("#csdn-toolbar").load("module/bk_header.html");

var $fans;
var $attention;
var $changeFans;
var $changeAttention;

//获取粉丝数和关注数并渲染,及个人信息
$.ajax({
    type: 'POST',
    url: "selectUserInfo",
    async: false,
    success: function (data) {
        console.log(data);
        //渲染关注数、粉丝数部分
        var html =
            "<ul class='my_fans_bar'>" +
            "<li class='tab_item cur' onclick = 'changeFans()' id='changeFans'>" +
            "<span>粉丝</span>" +
            "<em>" + data.attentions + "</em>" +
            "</li>" +
            "<li class='tab_item' onclick='changeAttention()' id='changeAttention'>" +
            "<span>关注</span>" +
            "<em>" + data.fans + "</em>" +
            "</li>" +
            "</ul>" +
            "<div class='fan_att_con' id='my_from'>" +
            "</div>";
        $("#my_fans").append(html);
        $changeFans = $("#changeFans");
        $changeAttention = $("#changeAttention");
        //    渲染个人信息部分

        var personalHtml = "<dl class=\"my_person_t_small clearfix\">" +
            "                <dt>" +
            "                    <img alt=\"\" class=\"head_img\" src=\"image/" + data.userInfo.url + "\">" +
            "                </dt>" +
            "                <dd>" +
            "                    <h4 class=\"username\">" +
            "                        " + data.userInfo.name +
            "                    </h4>" +
            "                </dd>" +
            "                <dd class=\"user_desc\">" +
            "                    "+ data.userInfo.brief +
            "                </dd>" +
            "            </dl>" +
            "            <dl class=\"person_wrap\">" +
            "                <dd style=\"height: 15px\"></dd>" +
            "                <dd class=\"person_b\">" +
            "                    <ul>" +
            "                        <li>" +
            "                            <span>\n" +
            "                                "+data.userInfo.job +
            "                            </span>" +
            "                        </li>" +
            "                        <li>" +
            "                            <span>" +
            "                                "+data.userInfo.country+" "+data.userInfo.city+" "+data.userInfo.town +
            "                            </span>" +
            "                        </li>" +
            "                    </ul>" +
            "                </dd>" +
            "            </dl>";
        $("#my_person").append(personalHtml);
    }
});

//获取粉丝用户信息并渲染
$.ajax({
    type: 'GET',
    url: "selectCareByUserId",
    success: function (data) {
        console.log(data);
        var html2 = "<ul class='tab_page clearfix' style='display: block;' id='fans'>";
        $(data).each(function (index, item) {
            html2 +=
                "<li>" +
                "<a href=\"bk_list.html?userId="+item.user_id+"\" target='_blank'>" +
                "<img alt='' class='fans_img' src=\"./image/" + item.url + "\">" +
                "</a>" +
                "<a class='fans_title' href='#'>" + item.name + "</a>" +
                "</li>"
        });
        html2 += "</ul>";
        $("#my_from").append(html2);
        $fans = $("#fans");
    }
});

//获取关注用户信息并渲染
$.ajax({
    type: 'GET',
    url: "selectCareByUserFromId",
    success: function (data) {
        console.log(data);
        var html3 = "<ul class='tab_page' style='display: none;' id='attention'>";
        $(data).each(function (index, item) {
            html3 +=
                "<li>" +
                "<a href=\"bk_list.html?userId="+item.user_id+"\" target='_blank'>" +
                "<img alt='' class='fans_img' src=\"./image/" + item.url + "\">" +
                "</a>" +
                "<a class='fans_title' href='#'>" + item.name + "</a>" +
                "</li>"
        });
        html3 += "</ul>" + "</div>";
        $("#my_from").append(html3);
        $attention = $("#attention");
    }
});

function changeFans() {
    $fans.css("display", "block");
    $changeFans.addClass("cur");
    $attention.css("display", "none");
    $changeAttention.removeClass("cur");
}

function changeAttention() {
    $fans.css("display", "none");
    $changeFans.removeClass("cur");
    $attention.css("display", "block");
    $changeAttention.addClass("cur");
}



//统计个人信息
var level;//等级
$.ajax({
    type:'GET',
    url:"selectCount",
    success:function (data) {
        console.log(data);
        var sunValue = data.sun_value;
        if(sunValue >0 && sunValue <= 100){
            level = 1;
        }else if(sunValue >100 && sunValue <= 300){
            level = 2;
        }else if(sunValue >300 && sunValue <= 600){
            level = 3;
        }else if(sunValue > 600){
            level = 4;
        }

        var html = "<ul class=\"mod_my_t clearfix\">\n" +
            "                        <li>\n" +
            "                            <span>"+level+"</span>\n" +
            "                            <a href=\"#\" target=\"_blank\"><strong>等级</strong></a>\n" +
            "                        </li>\n" +
            "                        <li>\n" +
            "                            <span>"+data.sum_blog+"</span>\n" +
            "                            <a href=\"#\" target=\"_blank\"><strong>博客数量</strong></a>\n" +
            "                        </li>\n" +
            "                        <li>\n" +
            "                            <span>"+data.sum_browse+"</span>\n" +
            "                            <strong>访问量</strong>\n" +
            "                        </li>\n" +
            "                        <li>\n" +
            "                            <span>"+data.sum_fans+"</span>\n" +
            "                            <strong>粉丝数量</strong>\n" +
            "                        </li>\n" +
            "                        <li>\n" +
            "                            <span>"+data.sum_praise+"</span>\n" +
            "                            <strong>总获赞</strong>\n" +
            "                        </li>\n" +
            "                        <li>\n" +
            "                            <span>"+data.sum_comment+"</span>\n" +
            "                            <strong>总评论</strong>\n" +
            "                        </li>\n" +
            "                    </ul>"

        $("#sumCount").append(html);
    }

});


    var userId=window.location.search.split("=")[1];
    $.ajax({
        type:"post",
        dataType:"JSON",
        url:"/showBlog?userId="+userId,
        contentType:"application/json",
        success:function (data) {
            $("#tab_page_list").empty();
            $.each(data,function (index,item) {
                var contents = spilt(item.content,item.title);
                var c= "<dt><h3><a href=\"bk_list.html?userId="+userId+"\" target=\"_blank\">"+item.title+"</a></h3></dt><dd><p class=\"tab_page_intro\">"+contents+"</p></dd><dd class=\"tab_page_con_b clearfix\"><div class=\"tab_page_b_l fl\"><label><em>"+item.seeNum+"</em>次阅读</label></div><div class=\"tab_page_b_r fr\">"+item.time+"</div></dd>\n";
                $("#tab_page_list").append(c);
            })
        },
        error:function (data) {
        }
    });


function spilt(content,title) {

    var s= content.split("</p>")[1]
    if (s==null){
        return title;
    } else {
        return s.replace("<p>","");
    }
};