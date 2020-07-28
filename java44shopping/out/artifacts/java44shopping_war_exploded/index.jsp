<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/24
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>完成界面</title>
  <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
  <script src="bootstrap/js/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <div class="panel panel-primary">
    <div class="panel-heading">
      <h1>支付成功
        <span style="color: red;float: right">当前用户：${user.uname}</span>
      </h1>
    </div>
    <div class="panel-body">
      <%--<form method="post" action="/upd">--%>
        <table class="table table-hover  table-striped table-condensed text-center">
          <tr>
            <td>订单号:</td>
            <td>${orderid}</td>
          </tr>
          <tr>
            <td>姓名:</td>
            <td>${user.uname}</td>
          </tr>
          <tr>
            <td>手机号:</td>
            <td>${utele}</td>
            <%--<td>--%>
              <%--<div class="col-sm-10">--%>
                <%--<input  class="form-control" name="utele"  value="${utele}">--%>
              <%--</div>--%>
            <%--</td>--%>
          </tr>
          <tr>
            <td>地址:</td>
            <td>${uaddr}</td>
            <%--<td>--%>
              <%--<div class="col-sm-10">--%>
                <%--<input  class="form-control" name="uaddr"  value="${uaddr}">--%>
              <%--</div>--%>
            <%--</td>--%>
          </tr>
          <tr>
            <td>备注:</td>
            <td>${beizhu}</td>
            <%--<td>--%>
              <%--<div class="col-sm-10">--%>
                <%--<input  class="form-control" name="uaddr"  value="${beizhu}">--%>
              <%--</div>--%>
            <%--</td>--%>
          </tr>
          <tr>
            <td>状态:</td>
            <td>已支付</td>
          </tr>
        </table>
        <table class="table table-hover  table-striped table-condensed text-center">
          <tr>
            <td>菜名</td>
            <td>单价</td>
            <td>数量</td>
            <td>小计</td>
          </tr>
          <c:forEach items="${list}" var="of">
            <tr>
              <td>${of.fname}</td>
              <td>${of.fprice}</td>
              <td>${of.num}</td>
              <td>${of.xiaoji}</td>
            </tr>
          </c:forEach>
          <tr>
            <td colspan="4">

              共计：${sum1}件， 总金额是：${total1}元。

            </td>
          </tr>
        </table>

        <%--<button type="submit" class="btn btn-success btn-lg btn-block">确认支付</button>--%>
        <a href="/food" class="btn btn-danger btn-lg btn-block">返回</a>
      <%--</form>--%>
    </div>
    <div class="panel-footer text-right">
      深圳知领java44班开发。版权所有，复制必究！
    </div>
  </div>
</div>

</body>
</html>
