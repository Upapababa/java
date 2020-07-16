<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/15
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<html>
<head>
    <title>账号管理</title>
</head>
<body>
<div style="width: 800px;height: 600px;margin: 115px auto;border: 1px solid #d5d5d5">
    <div class="panel-heading" style="background-color: #2aabd2;font-weight: 700;
        color: white;text-align: center;height: 100px">
        <span style="color: red" >
            <label style="font-size: 65px">${sname}</label>
        </span>
        <span>
            <label style="font-size: 30px">先生欢迎您的登录</label>
        </span>
    </div>
    <div>
        <br><br><br><br>
        <a type="button" class="btn btn-primary btn-lg " onclick="show()">查询余额</a>
        <a type="button" class="btn btn-primary btn-lg " onclick="save()" style="float: right" >存&nbsp;&nbsp;&nbsp;&nbsp;  款</a>
        <br><br><br><br><br><br>
        <a type="button" class="btn btn-primary btn-lg " onclick="qukuan()">取&nbsp;&nbsp;&nbsp;&nbsp;  款</a>
        <a type="button" class="btn btn-primary btn-lg " onclick="zz()" style="float: right" >转&nbsp;&nbsp;&nbsp;&nbsp;  账</a>
        <br><br><br><br><br><br>
        <a type="button" class="btn btn-primary btn-lg " onclick="upd()" >修改密码</a>
        <a type="button" class="btn btn-primary btn-lg " style="float: right" href="index.jsp">退&nbsp;&nbsp;&nbsp;&nbsp;  出</a>
        <%--查询余额--%>
        <div style="position: absolute;left:610px;top: 300px;border: 1px solid #d5d5d5;
            width: 400px;height: 300px;text-align: center;" hidden id="show">
            <div style="margin-top: 125px">
                <span style="color: green " >
                    <label style="font-size: 35px">您的余额为：${balance}</label>
                </span>
            </div>
        </div>
        <%--存款--%>
        <div style="position: absolute;left:610px;top: 300px;border: 1px solid #d5d5d5;width: 400px;
        height: 300px" hidden id="save">
            <form class="form-horizontal" role="form" action="/saveservlet" method="post">
                <div class="form-group" style="margin-top: 125px">
                    <label  class="col-sm-2 control-label">存款</label>
                    <div class="col-sm-10">
                        <input type="hidden" name="mno" value=${mno} >
                        <input type="hidden" name="sname" value=${sname} >
                        <input type="text" style="width: 70%" class="form-control" name="jine" placeholder="请输入存款金额">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" class="btn btn-success btn-lg btn-block" style="width: 70%">
                    </div>
                </div>
            </form>
        </div>
        <%--取款--%>
        <div style="position: absolute;left:610px;top: 300px;border: 1px solid #d5d5d5;width: 400px;
        height: 300px" hidden id="qukuan">
            <form class="form-horizontal" role="form" action="/qukuanservlet" method="post">
                <div class="form-group" style="margin-top: 125px">
                    <label  class="col-sm-2 control-label">取款</label>
                    <div class="col-sm-10">
                        <input type="hidden" name="mno" value=${mno} >
                        <input type="hidden" name="sname" value=${sname} >
                        <input type="text" style="width: 70%" class="form-control" name="jine" placeholder="请输入存款金额">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" class="btn btn-success btn-lg btn-block" style="width: 70%">
                    </div>
                </div>
            </form>
        </div>
        <%--转账--%>
        <div style="position: absolute;left:610px;top: 300px;border: 1px solid #d5d5d5;width: 400px;
        height: 300px" hidden id="zz">
            <form class="form-horizontal" role="form" action="/zzservlet" method="post">
                <div class="form-group" style="margin-top: 65px">
                    <label  class="col-sm-2 control-label" style="padding-right: 0px">卡号</label>
                    <div class="col-sm-10">
                        <input type="hidden" name="mno" value=${mno} >
                        <input type="hidden" name="mpwd" value=${mpwd} >
                        <input type="hidden" name="sname" value=${sname} >
                        <input type="text" style="width: 70%" class="form-control" name="nno" placeholder="请输入要转入的卡号">
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label" style="padding-right: 0px">金额</label>
                    <div class="col-sm-10">
                        <input type="text" style="width: 70%" class="form-control" name="money" placeholder="请输入金额">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" class="btn btn-success btn-lg btn-block" style="width: 70%">
                    </div>
                </div>
            </form>
        </div>
        <%--修改密码--%>
        <div style="position: absolute;left:610px;top: 300px;border: 1px solid #d5d5d5;width: 400px;
        height: 300px" hidden id="upd">
            <form class="form-horizontal" role="form" action="/updservlet" method="post">
                <div class="form-group" style="margin-top: 65px">
                    <label  class="col-sm-2 control-label" style="padding-right: 0px">原密码</label>
                    <div class="col-sm-10">
                        <input type="hidden" name="mno" value=${mno} >
                        <input type="hidden" name="mpwd" value=${mpwd} >
                        <input type="hidden" name="sname" value=${sname} >
                        <input type="text" style="width: 70%" class="form-control" name="opwd" placeholder="请输入原密码">
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label" style="padding-right: 0px">新密码</label>
                    <div class="col-sm-10">
                        <input type="text" style="width: 70%" class="form-control" name="npwd" placeholder="请输入新密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" class="btn btn-success btn-lg btn-block" style="width: 70%">
                    </div>
                </div>
            </form>
        </div>
        <div style="position: absolute;left:610px;top: 300px;border: 1px solid #d5d5d5;
            width: 400px;height: 300px;text-align: center;"  id="start">
                <div style="margin-top: 125px">
                    <span style="color: red " >
                        <label style="font-size: 35px">${msg1}</label>
                    </span>
                </div>
        </div>

    </div>
</div>
</body>
<script type="text/javascript">
    function show() {
        $("#show").prop("hidden","");
        $("#save").prop("hidden","hidden");
        $("#qukuan").prop("hidden","hidden");
        $("#zz").prop("hidden","hidden");
        $("#upd").prop("hidden","hidden");
        $("#start").prop("hidden","hidden");
    }
    function save() {
        $("#show").prop("hidden","hidden");
        $("#save").prop("hidden","");
        $("#qukuan").prop("hidden","hidden");
        $("#zz").prop("hidden","hidden");
        $("#upd").prop("hidden","hidden");
        $("#start").prop("hidden","hidden");
    }
    function qukuan() {
        $("#show").prop("hidden","hidden");
        $("#save").prop("hidden","hidden");
        $("#qukuan").prop("hidden","");
        $("#zz").prop("hidden","hidden");
        $("#upd").prop("hidden","hidden");
        $("#start").prop("hidden","hidden");
    }
    function zz() {
        $("#show").prop("hidden","hidden");
        $("#save").prop("hidden","hidden");
        $("#qukuan").prop("hidden","hidden");
        $("#zz").prop("hidden","");
        $("#upd").prop("hidden","hidden");
        $("#start").prop("hidden","hidden");
    }
    function upd() {
        $("#show").prop("hidden","hidden");
        $("#save").prop("hidden","hidden");
        $("#qukuan").prop("hidden","hidden");
        $("#zz").prop("hidden","hidden");
        $("#upd").prop("hidden","");
        $("#start").prop("hidden","hidden");
    }
</script>
</html>
