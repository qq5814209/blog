layui.use(['element','table'],function () {
    var $ = layui.$,
        table = layui.table,
        layer = layui.layer;
    table.render({
        elem: '#demo'
        ,id:"mytable"
        ,url: '/user/list' //数据接口
        ,page: true //开启分页
        ,response: {
            statusName: 'code' //数据状态的字段名称，默认：code
            ,statusCode: 200 //成功的状态码，默认：0
            ,msgName: 'msg' //状态信息的字段名称，默认：msg
            ,countName: 'total' //数据总数的字段名称，默认：count
            ,dataName: 'rows' //数据列表的字段名称，默认：data
        }
        ,cols: [[ //表头
            {type:'checkbox'}
            ,{title: '序号',type:'numbers'}
            ,{field: 'userName', title: '用户名'}
            ,{field: 'phone', title: '手机号码'}
            ,{field: 'email', title: '邮箱'}
            ,{field: 'status', title: '状态',templet:function(r){
                switch (r.status){
                    case 0: return "禁用";
                    case 1: return "启用";
                }
            }}
            ,{field: 'role', title: '角色',templet:function(r){
                if(r.role){
                    return r.role.name;
                }else {
                    return "无";
                }

            }}
            ,{title:'操作',toolbar:"#toolbar"}

        ]]
    });

    //工具条
    table.on("tool(test)",function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        if("edit" == layEvent){
            location.href = "/user/ui/edit?id=" + data.id;
        }else if("delete" == layEvent){
            location.href = "/user/delete?id=" + data.id;
        }else if("changeStatus" == layEvent){
            location.href = "/user/status?id=" + data.id;
        }else if("changeRole" == layEvent){
            //变更角色弹窗
            layer.open({
                type: 2
                ,title: '变更角色'
                ,area: ['450px', '320px']
                ,shade: 0
                ,content: '/user/ui/changerole?id=' + data.id
                ,btn: ['变更', '取消'] //只是为了演示
                ,yes: function(index, layero){
                    var $form = layer.getChildFrame('form', index);
                    var data = $form.serialize();
                    $.ajax({
                        url:"/user/changerole",
                        type:'post',
                        dataType:'json',
                        data:data,
                        success:function(msg){
                            if(msg.code == 200) {
                                layer.close(index);
                                //重新加载表格数据
                                table.reload("mytable");
                            }
                        }
                    });
                }
                ,btn2: function(index, layero){
                    layer.close(index);
                }
            });
        }
    });

    //批量删除
    $("#deleteAll").on('click',function(){
        var checkStatus = layui.table.checkStatus('mytable'); //test即为基础参数id对应的值
        if(checkStatus.data.length < 1) return false;
        var params = '';
        $.each(checkStatus.data,function(i,v){
            params += "id=" + v.id + "&";
        });
        //删除
        location.href = "/user/delete?" + params;

    });

});