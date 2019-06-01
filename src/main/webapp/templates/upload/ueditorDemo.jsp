<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <%@include file="../fragments/common.jsp"%>
    <script type="text/javascript" charset="utf-8" src="/static/plugins/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/static/plugins/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="/static/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
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
                        <a><cite>文本编辑器</cite></a>
                    </span>
            </div>

            <!--主体内容区-->
            <div class="form-content layui-container">
                <form action="#">
                    <textarea id="editor" name="info" type="text/plain" style="width:1024px;height:500px;"></textarea>
                    <button type="submit">
                        提交
                    </button>
                </form>

            </div>
        </div>
    </content>
    <%@include file="../fragments/footer.jsp"%>
</div>




<script>
    //一般直接写在一个js文件中
    layui.use(['element','form','upload'],function () {
        //实例化编辑器
        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
        var ue = UE.getEditor('editor');
    });
</script>
</body>
</html>