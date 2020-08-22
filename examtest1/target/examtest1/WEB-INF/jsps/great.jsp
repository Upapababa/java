<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/21
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩</title>
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
            <h1>您的成绩为：${score}</h1>
            <a class="btn btn-block btn-success btn-lg" href="/score/back.action">放回主界面</a>
        </div>
    </div>
</div>

</body>
</html>
