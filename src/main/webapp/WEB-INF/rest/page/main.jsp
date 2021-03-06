<%--
  Created by IntelliJ IDEA.
  User: js170830xlr
  Date: 2018/1/18
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>个人项目主页布局</title>
    <link rel="stylesheet" href="common/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div id="menuView">

    </div>


    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">内容主体区域</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="common/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element', 'laytpl'], function () {
        var element = layui.element,
            laytpl = layui.laytpl,
            $ = layui.jquery;
        var data =[];
        $.ajax({
            url: "resources/selectAllMenu",
            data:[],
            type:"POST",
            dataType:"json",
            success:function(data11){
                data=data11;
                var template = [
                    '<div class="layui-side layui-bg-black">'
                    , '<div class="layui-side-scroll">'
                    , '{{# if(d.data && d.data.length > 0) { }}'
                    , '{{# layui.each(d.data, function(index, topMenu) { }}'
                    , '<ul class="layui-nav layui-nav-tree" lay-filter="menuFilter">'
                    , '<li class="layui-nav-item layui-nav-itemed">'
                    , '<a class="" href="javascript:;">{{ topMenu.name }}</a>'
                    , '{{# if(topMenu.childrenList && topMenu.childrenList.length > 0) { }}'
                    , '<dl class="layui-nav-child">'
                    , '{{# layui.each(topMenu.childrenList, function(i, childMenu) { }}'
                    , '<dd><a href="javascript:;">{{ childMenu.name }}</a></dd>'
                    , '{{# }); }}'
                    , '</dl>'
                    , '{{# } }}'
                    , '</li>'
                    , '</ul>'
                    , '{{# }); }}'
                    , '{{# } }}'
                    , '</div>'
                    , '</div>'
                ].join('');
                var view = $('#menuView');
                laytpl(template).render(data, function (html) {
                    view.html(html);
                });
                element.init();
            }
    });

    });
</script>
</body>
</html>
