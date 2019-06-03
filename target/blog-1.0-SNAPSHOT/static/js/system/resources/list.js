    layui.use(['element','table'],function () {
        var $ = layui.$;
        layui.table.render({
            elem: '#demo'
            ,id:"mytable"
            ,url: '/resources/list' //数据接口
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
                ,{field: 'name', title: '资源名称'}
                ,{field: 'type', title: '类型',templet:function(row){
                    switch (row.type){
                        case 1: return '模块';
                        case 2: return '主页面';
                        case 3: return '附属页面';
                        case 9: return '操作';
                        default: return '其它';
                    }

                }}
                ,{field: 'url', title: 'URL'}
                ,{field: 'parentModule', title: '所属模块'}
                ,{field: 'parentPage', title: '所属页面'}
                ,{field: 'code', title: '资源编码'}
                ,{field: 'sortNo', title: '排序'}
                ,{title:'操作',toolbar:"#toolbar"}

            ]]
        });

        //工具条
        layui.table.on("tool(test)",function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            if("edit" == layEvent){
                location.href = "/resources/ui/edit?id=" + data.id;
            }else if("delete" == layEvent){
                location.href = "/resources/delete?id=" + data.id;
            }
        });

        //批量删除
        $("#deleteAll").on('click',function(){
            var checkStatus = layui.table.checkStatus('mytable'); //test即为基础参数id对应的值
            if(checkStatus.data.length < 1) return false;
            var params = '';
            $.each(checkStatus.data,function(i,v){
                params += "id=" + v.id + "&";
            })
            //删除
            location.href = "/resources/delete?" + params;

        });
    });