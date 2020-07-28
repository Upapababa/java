<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/27
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户评价界面</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>评论区
                <%--<span>${msg}</span>--%>
            </h1>
        </div>

        <div class="panel-body">

            <div class="media" style="margin-left: 300px">
                <div class="media-left">
                    <img src="imgs/${f.fimg}" class="media-object" style="width:300px">
                </div>
                <div class="media-body">
                    <h2 class="media-heading">${f.fname}</h2>
                    <h3>${f.ftype}</h3>
                    <h3>${f.fshop}</h3>
                    <h3>${f.fprice}</h3>
                </div>
            </div>
            <hr />

            <c:forEach items="${list}" var="list">
                <div class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">${list.pdate},${list.uname}:</label>
                        <div class="col-sm-7">
                            <p style="margin: 7px 0px 10px">${list.msg} <a style="float: right" class="huifu">回复</a></p>
                        </div>
                    </div>

                    <c:forEach items="${list.list2}" var="list2">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">${list2.adate},${list2.uname}回复@ ${list.uname}:</label>
                            <div class="col-sm-6">
                                <p style="margin: 7px 0px 10px">${list2.amsg} <a style="float: right">回复</a></p>
                            </div>
                        </div>
                    </c:forEach>

                    <div  hidden class=" form-group">
                        <form action="/HuifuServlet" method="post" >
                            <input hidden name="pid" value="${list.pid}">
                            <input hidden name="fid" value="${f.fid}">
                            <label class="col-sm-4 control-label">回复@${list.uname}：</label>
                            <input  name="huifu"  style="width: 570px;height: 33px">
                            <button  class=" btn btn-success" id="tj" type="submit">提交</button>
                        </form>
                    </div>
                    <hr/>
                </div>
            </c:forEach>

            <form class="form-horizontal" role="form" action="/appraise" method="post">
                <input hidden name="fid" value="${f.fid}">
                <div class="form-group">
                    <label class="col-sm-3 control-label">我的评价</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="pinjia"/>
                    </div>
                </div>
                <hr/>
                <button type="submit" class="btn btn-success btn-block">提交评价</button>
                <a href="/food" class="btn btn-danger btn-block">返回购物</a>
            </form>

        </div>



        <div class="panel-footer text-right">
            深圳知领java44班开发。版权所有，复制必究！
        </div>
    </div>
</div>

<script>
    $(".huifu").click(function () {
        $(this).parent().parent().parent().parent().children().last().prev().show();
    })

</script>

</body>
</html>
