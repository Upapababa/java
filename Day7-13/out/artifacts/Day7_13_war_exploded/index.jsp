<%@ page import="com.sz.zhiling.text.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sz.zhiling.text.MyUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/13
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>我的第一个网站</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="container">
    <div class="panel panel-primary">
      <div class="panel-heading">
        <h1>用户列表</h1>
      </div>
    <div class="panel-body">
      <table class="table table-striped table-hover table-bordered text-center">
         <tr>
           <td>编号</td>
           <td>姓名</td>
           <td>年龄</td>
           <td>性别</td>
           <td>密码</td>
           <td>班级</td>
           <td>操作</td>
         </tr>
        <%--<%--%>
          <%--List<Student> s = MyUtil.show();--%>
          <%--for (Student s1:s) {--%>
         <%--%>--%>
        <%--<tr>--%>
          <%--<td>${}</td>--%>
          <%--<td><%=s1.getSname()%></td>--%>
          <%--<td><%=s1.getSage()%></td>--%>
          <%--<td><%=s1.getSsex()%></td>--%>
          <%--<td><%=s1.getSpwd()%></td>--%>
          <%--<td><%=s1.getSclassno()%></td>--%>
          <%--<td>--%>
            <%--<a href="#" class="btn btn-success">修改</a>--%>
            <%--<a href="/delete?sid=<%=s1.getSid()%>" class="btn btn-danger">删除</a>--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<%--%>
          <%--}--%>
        <%--%>--%>
        <c:forEach items="${list}" var="student">
          <tr>
            <td>${student.sid}</td>
            <td>${student.sname}</td>
            <td>${student.sage}</td>
            <td>${student.ssex}</td>
            <td>${student.spwd}</td>
            <td>${student.sclassno}</td>
            <td>
              <a class="btn btn-warning">修改</a>
              <a class="btn btn-danger" href="/test01/deleteStudent?stuid=${student.sid}">删除</a>
            </td>
          </tr>
        </c:forEach>

      </table>
    </div>
    <div class="panel-footer text-right">
        深圳知领
    </div>
   </div>
  </div>
  </body>
</html>
