//一般直接写在一个js文件中
layui.use(['element','form'],function () {
    var form = layui.form;
    //监听提交
    form.on('submit(formSubmit)', function(data){
        //提交之前讲所选权限的ID 拼装成一个字符串
        var treeObj = $.fn.zTree.getZTreeObj("resourcesTree");
        var nodes = treeObj.getCheckedNodes(true);
        var idArr = [];
        $.each(nodes,function(i,item){
            idArr.push(item.id);
        })
        $("#resourcesCodes").val(idArr.join(","));
        return true;
    });


    var setting = {
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };

    var id = $("#id").val();
    $.ajax({
        url:"/role/tree",
        type:'get',
        dataType:'json',
        data:{roleId:id},
        success:function(msg){
            if(msg.code == 200) {
                var data = msg.data;
                $.fn.zTree.init($("#resourcesTree"), setting, data);
            }
        },
        error:function(e){
            console.log("权限树加载失败");
        }
    });
});