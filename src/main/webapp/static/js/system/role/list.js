layui.use(['element','table'],function () {
    var $ = layui.$;
    layui.table.render({
        elem: '#demo'
        ,id:"mytable"
        ,url: '/role/list' //数据接口
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
            ,{field: 'name', title: '角色名称'}
            ,{field: 'remark', title: '备注'}
            ,{title:'操作',toolbar:"#toolbar"}

        ]]
    });

    //工具条
    layui.table.on("tool(test)",function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        if("edit" == layEvent){
            location.href = "/role/ui/edit?id=" + data.id;
        }else if("delete" == layEvent){
            location.href = "/role/delete?id=" + data.id;
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
        location.href = "/role/delete?" + params;

    });
});