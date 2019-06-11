
init();

var hrefs;

function init(){
    $.ajax({
        url: "getCbi",
        type: "POST",
        contentType:"application/json",
        dataType:"json",
        data:JSON.stringify({

        }),
        success:function(resp){
            console.log(resp);
            $(".vip_buy_top dd").empty("");
            $(resp).each(function (index, item) {
                $(".vip_card_wrap:eq("+index+") dd").append("<h5>"+item.cbi_name+"</h5><h6>"+item.cbi_id+"</h6>" +
                    "                        <h3><span>"+item.cbi_price+"</span>元</h3>")
            })
        },
        error:function () {
            alert("错误");
        }
    });

    $.ajax({
        url: "getVip",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        data:JSON.stringify({
        }),
        success:function(resp){
            console.log(resp);
            $(".js_compare_list").empty("");
            $(resp).each(function (index, item) {
                $("#vips").append(" <dl class=\"js_compare_list \" goods-id=\"2794\">" +
                    "                    <input type='text' value='"+item.vip_id+"'/>" +
                    "                    <dt><p>"+item.vip_name+"</p></dt>\n" +
                    "                    <dd> "+item.vip_down+"</dd>\n" +
                    "                    <dd>"+item.vip_time+"天</dd>\n" +
                    "                    <dd><img src=\"./image/down-yes@2x.png\" alt=\"\">\n" +
                    "                    </dd>\n" +
                    "                    <dd><img src=\"./image/down-yes@2x.png\" alt=\"\">\n" +
                    "                    </dd>\n" +
                    "                    <dd><img src=\"./image/down-yes@2x.png\" alt=\"\">\n" +
                    "                    </dd>\n" +
                    "                    <dd><img src=\"./image/down-yes@2x.png\" alt=\"\">\n" +
                    "                    </dd>\n" +
                    "                    <dd><img src=\"./image/down-yes@2x.png\" alt=\"\">\n" +
                    "                    </dd>\n" +
                    "                    <dd class='vip_puy'>\n" +
                    "                        "+item.vip_price+"\n" +
                    "                    </dd></dl>")
            });
            $(".js_compare_list").click(function () {
                $(".vip_card_wrap").removeClass('card_cur');
                $(".js_compare_list").removeClass('super-vip');
                $(this).addClass('super-vip');
                $("#jinger").html($(this).find(".vip_puy").html());
                hrefs="pay.html?vipId="+$(this).find("input").val()
            });
        },
        error:function () {
            alert("错误");
        }
    })

}



$(".vip_card_wrap").click(function() {
    $(this).siblings('.vip_card_wrap').removeClass('card_cur');
    $(this).addClass('card_cur');
    $("#jinger").html($(this).find("span").html());
    $(".vip-compare dl").removeClass("super-vip");
    hrefs="pay2.html?CbiId="+$(this).find("h6").html()

});




$("#tiao").click(function () {
    if ($("#jinger").html()=="00.00元"){
        alert("请先选择商品!");
        return;
    }
    location.href=hrefs
});
