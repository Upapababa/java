<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/20
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="/../bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/../layer/theme/default/layer.css">
    <script src="/../bootstrap/js/jquery.min.js"></script>
    <script src="/../bootstrap/js/bootstrap.min.js"></script>
    <script src="/../layer/layer.js"></script>
</head>
<body>

<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>登录界面</h1>
            <span style="color: red;text-align: right;">${msg}</span>
        </div>

        <div class="panel-body">

            <form class="form-horizontal" action="/user/login.action" method="post">
                <div class="form-group">
                    <label for="uname" class="col-sm-2 control-label">用户名：</label>
                    <div class="col-sm-10">
                        <input type="hidden" name="userid"  />
                        <input  class="form-control" id="uname" name="uname"  >
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword3" name="upwd"  >
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary btn-block btn-lg">确认登录</button>
                    </div>

                    <div class="col-sm-offset-2 col-sm-10">
                        <a  href="/user/reg.action" class="btn btn-success btn-block btn-lg">我要注册</a>
                    </div>
                </div>
            </form>


        </div>

        <div class="panel-footer text-right">
            深圳知领，版权所有。
        </div>
    </div>
</div>

</body>
</html>
