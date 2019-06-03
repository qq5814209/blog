<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <%@include file="../fragments/common.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="../fragments/header.jsp"%>
    <content>
        <%@include file="../fragments/left.jsp"%>

        <div class="right">
            <!--面包屑-->
            <div class="breadcrumb layui-bg-gray">
                    <span class="layui-breadcrumb" lay-separator=">">
                        <a href="">首页</a>
                        <a href="">案例</a>
                        <a><cite>文件上传</cite></a>
                    </span>
            </div>

            <!--主体内容区-->
            <div class="form-content layui-container">
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="test1">上传图片</button>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" id="demo1">
                        <p id="demoText"></p>
                        <input type="text" id="demo1FileName">
                    </div>
                </div>

                <p>
                    <a href="#" id="yl"> 点击预览上传图片</a>
                </p>
            </div>
        </div>
    </content>
    <%@include file="../fragments/footer.jsp"%>
</div>




<script>
    //一般直接写在一个js文件中
    layui.use(['element','form','upload'],function () {
        var $ = layui.$
            ,upload = layui.upload;

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            ,url: '/storage/files/ul'
            ,field: 'file'
            ,done: function(res){
                    $("#demo1FileName").val(res.data.path);
                    $('#demo1').attr('src', "/storage/images/" + res.data.path+"_92x92"); //图片链接（base64）
                    $("#yl").attr("href","/storage/images/" + res.data.path);
                //上传成功
            }
            /*,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }*/
        });
    });
</script>
</body>
</html>