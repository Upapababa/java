<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/17
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>学员管理</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="container">
    <div class="panel panel-primary">
      <div class="panel-heading">
        <h1>用户列表</h1>
      </div>
      <div class="panel-body">
        <form action="users" method="post">
          <input type="text" class="form-control" id="search" style="width: 15%;float: left"
                 name="search" >
          <%--<inupt type="text" class="form-control" style="width: 15%;float: left" name="搜索"/>--%>
          &nbsp;
          <button type="submit" class="btn btn-success" id="sea">搜索</button>
          <a class="btn btn-primary" data-toggle="modal" data-target="#myModal">
            添加用户
          </a>
        </form>
        <form action="/deleteStudent" method="post">
          <input type="submit" class="btn btn-danger" value="批量删除"/>
        <br>
        <br>
        <table class="table table-striped table-hover table-bordered text-center">
          <tr>
            <td>
              <input type="checkbox" />全选
            </td>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>班级</td>
            <td>老师</td>
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
              <td>
                <input type="checkbox" name="xz" value='${student.sid}' />
              </td>
              <td>${student.sid}</td>
              <td>${student.sname}</td>
              <td>${student.sage}</td>
              <td>${student.ssex}</td>
              <td>${student.sclassno}</td>
              <td>${student.tname}</td>
              <td>
                <a class="btn btn-warning" data-toggle="modal" data-target="#myModal"
                   onclick="update('${student.sid}','${student.sname}','${student.sage}','${student.ssex}','${student.tname}','${student.sclassno}')">
                  修改
                </a>
                <a class="btn btn-danger" href="/deleteStudent?sid=${student.sid}">删除</a>
              </td>
            </tr>
          </c:forEach>
        </form>
        </table>
        <ul class="pagination">
          <c:if test="${page!=1}">
            <li><a href="/showservlet?page=${page-1}">&laquo;</a></li>
          </c:if>
          <c:forEach begin="1" end="${count1}" var="p">
            <c:if test="${p==page}" var="flag">
              <li><a href="/showservlet?page=${p}" style="background-color:#2aabd2;color:white;">${p}</a></li>
            </c:if>
            <c:if test="${not flag}">
              <li><a href="/showservlet?page=${p}" >${p}</a></li>
            </c:if>
          </c:forEach>
          <c:if test="${page!=count1}">
            <li><a href="/showservlet?page=${page+1}">&raquo;</a></li>
          </c:if>
        </ul>
      </div>
      <div class="panel-footer text-right">
        深圳知领
      </div>
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="reset()">
                &times;
              </button>
              <h4 class="modal-title" id="myModalLabel">
                添加用户信息
              </h4>
            </div>
            <div class="modal-body">

              <form class="form-horizontal" role="form" action="/addStudent" method="post">
                <input type="hidden" name="sid" id="sid"/>

                <div class="form-group">
                  <label  class="col-sm-2 control-label">姓名</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="sname"
                           name="sname" >
                  </div>
                </div>
                <div class="form-group">
                  <label  class="col-sm-2 control-label">年龄</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="sage"
                           name="sage" >
                  </div>
                </div>
                <div class="form-group">
                  <label  class="col-sm-2 control-label">密码</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="spwd"
                           name="spwd" >
                  </div>
                </div>
                <div class="form-group">
                  <label  class="col-sm-2 control-label">班级</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="sclassno"
                           name="sclassno" >
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">性别</label>
                  <div class="col-sm-10">
                    <label class="radio-inline">
                      <input type="radio" name="ssex" id="man" value="男" >男
                    </label>
                    <label class="radio-inline">
                      <input type="radio" name="ssex" id="woman"  value="女">女
                    </label>
                  </div>
                </div>
                <div class="form-group" >
                  <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success" >提交</button>
                    <button type="reset" class="btn btn-success">清空</button>
                  </div>
                </div>
              </form>

            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal -->
      </div>
    </div>
  </div>
  </body>
<script>
    $(function () {
        $("[type=checkbox]:first").click(function () {
            $("[type=checkbox]").prop("checked",this.checked);
        })
    })

</script>
</html>
