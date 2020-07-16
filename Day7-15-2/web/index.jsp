<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/15
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>银行账户管理系统</title>
  <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
  <script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
  <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body >
<div style="width: 500px;height: 300px;margin: 115px auto;border: 1px solid #d5d5d5">
  <div class="panel-heading" style="background-color: #2aabd2;font-weight: 700;
    color: white;text-align: center">
    <h3>用户登录</h3>
    <span style="color: red">
      ${msg}
    </span>
  </div>
  <div class="panel-body">
    <form class="form-horizontal" role="form" action="/yzsevlet" method="post">
      <div class="form-group">
        <label  class="col-sm-2 control-label">账号</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="mno" placeholder="请输入账号">
        </div>
      </div>
      <div class="form-group">
        <label  class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="mpwd" placeholder="请输入密码">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-success" >登录</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>
