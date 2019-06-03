layui.use(['element','form'],function () {
    $ = layui.$;
    //  当选择类型后
    layui.form.on('select(type)', function(data){
        $("#yemian").val("").empty();
        $("#mokuai").val("").empty();
        if(data.value && data.value == 2) {
            $("#ssmk").show();
            $("#url").show().find("input").attr("lay-verify","required");
            $("#ssym").hide();
        }else if(data.value && (data.value == 3||data.value == 9)){
            $("#ssmk").show();
            $("#ssym").show();
            $("#url").show().find("input").attr("lay-verify","required");
        }else {
            $("#ssmk").hide();
            $("#ssym").hide();
            $("#url").hide().find("input").val("").removeAttr("lay-verify");
            return false;
        }

        //如果选择的是主页面则异步获取所有的模块
        $.ajax({
            url:"/resources/modules",
            dataType:'JSON',
            type:'GET',
            success:function(resp){
                if(resp.code == 200){
                    var modules = resp.data;
                    var $mokuai = $("#mokuai").empty().append('<option value="">请选择模块</option>');
                    $.each(modules,function(i,module){
                        $mokuai.append('<option value="'+module.code+'">'+module.name+'</option>');
                    })
                    layui.form.render('select'); //重新渲染下拉框
                }
            }
        });

    });
    //  当选择模块后,获取本模块所有页面（主页及其附属页面）
    layui.form.on('select(mokuai)', function(data){
        //如果选择的是主页面则异步获取所有的模块
        $.ajax({
            url:"/resources/pages?moduleCode="+data.value,
            dataType:'JSON',
            type:'GET',
            success:function(resp){
                if(resp.code == 200){
                    var modules = resp.data;
                    var $yemian = $("#yemian").empty();
                    $.each(modules,function(i,page){
                        $yemian.append('<option value="'+page.code+'">'+page.name+'</option>');
                    })
                    layui.form.render('select'); //重新渲染下拉框
                }
            }

        });

    });
});