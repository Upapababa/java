<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/24
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>用户登录：
                <span style="color: red;">${msg}</span>
            </h1>
        </div>
        <div class="panel-body">

            <form class="form-horizontal" action="/login" method="post">
                <div class="form-group">
                    <label for="u" class="col-sm-2 control-label">用户名：</label>
                    <div class="col-sm-10">
                        <input type="hidden" name="uri" value=${uri}>
                        <input type="hidden" name="fid" value=${fid}>
                        <input type="hidden" name="uid"  />
                        <input  class="form-control" id="u" name="uname"  >
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
                </div>
            </form>


        </div>
        <div class="panel-footer text-right">
            深圳知领，版权所有。
        </div>
    </div>
</div>
<script>
    function gotopage(p) {
        $("#pageindex").val(p);
        $("#myForm").submit();  //手动提交表单！！！
    }
</script>
</body>
</html>
