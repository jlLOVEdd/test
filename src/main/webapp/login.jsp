<%--
  Created by IntelliJ IDEA.
  User: js170830xlr
  Date: 2018/1/16
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>loginPage</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/layui.css" media="all">
</head>
<body class="layui-bg-cyan">
    <div class="layui-container" style="margin-top:240px">
        <div class="layui-fluid">
            <div class="layui-row">
                <div class="layui-col-md4 layui-col-md-offset4">
                    <form class="layui-form " action="/webapp/login" method="get">
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户：</label>
                            <div class="layui-input-block">
                                <input class="layui-input"  type="text" name="username" lay-verify="required" autocomplete="off" placeholder="请输入用户名" >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label" >密码：</label>
                            <div class="layui-input-block">
                                <input class="layui-input"  type="password" name="password" lay-verify="required" autocomplete="off" placeholder="请输入密码" >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block" style="margin-left: 110px">
                            <button class="layui-btn" lay-submit lay-filter="go" >登陆</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/common/layui.js"></script>
    <script>
        layui.use(['form','layer'],function () {
            var $ = layui.jquery;
            var form  =layui.form
                ,layer = layui.layer;
           // layer.msg("this is my world");
            form.on('submit(go)',function (data) {
                var datas = data.field;
                var action = data.form.action;
                console.log(datas);
                console.log(action);

                $.ajax({
                    url:action,
                    data:datas,
                    type:"POST",
                    dataType:"json",
                    success:function(data){
                        if(data.success){
                            window.location.href="main";
                        }else{
                            console.log(data.success);
                            console.log(data.msg);
                            layer.open({
                                skin: 'demo-class',
                                offset: 'auto',
                                content: '<div style="padding: 10px 20px;text-align:center;margin:0 auto"><span style="color: #fd3e1f; font-size: 16px;">'+ data.msg +'</spn></div>',
                                area: ['300px', '200px'],
                                yes: function(index, layero) {
                                    if (data.msg == "密码错误") {
//                                        $("input[name='password']").focus();
                                    } else {
                                        $("input[name='username']").focus();
                                    }
                                    layer.close(index); //如果设定了yes回调，需进行手工关闭

                                }
                            });

                        }

                    },
                    error:function(msg){
                        console.log("error"+JSON.stringify(msg));
                        layer.msg('未知错误！杀个程序员祭天', { icon: 5 });
                    }
                });
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
        });

    </script>
</body>
</html>
