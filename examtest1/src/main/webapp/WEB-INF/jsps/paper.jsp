<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/20
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>试卷页面</title>
    <link rel="stylesheet" href="/../bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/../layer/theme/default/layer.css">
    <script src="/../bootstrap/js/jquery.min.js"></script>
    <script src="/../bootstrap/js/bootstrap.min.js"></script>
    <script src="/../layer/layer.js"></script>
</head>
<body onload="select('')">
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>所有试卷列表</h1>
        </div>

        <div class="panel-body">

            <form >
                <input type="text" name="papername" id="papername" value="">
                <a  onclick="select2()" class="btn btn-success">模糊查询</a>
            </form>

            <table class="table table-hover table-striped">
                <tr>
                    <td>序号</td>
                    <td>试卷编号</td>
                    <td>试卷名称</td>
                    <td>试卷分数</td>
                    <td>创建时间</td>
                    <td>操作</td>
                </tr>
                <tbody id="tbody">

                </tbody>
            </table>


        </div>

        <div class="panel-footer text-right">
            深圳知领，版权所有。
        </div>
    </div>
</div>
</body>
<script>
    function select(papername) {
        $.get("/paper/selectpaper.action?papername="+papername,function (data) {
            var p ="";
            $(data).each(function (i,v) {
                p+="<tr>";
                p+="<td>"+(i+1)+"</td>";
                p+="<td>"+v.paperid+"</td>";
                p+="<td>"+v.papername+"</td>";
                p+="<td>"+v.remarks+"</td>";
                p+="<td>"+v.createTime+"</td>";
                p+="<td>";
                p+="<a href='/paper/exam.action?paperid="+v.paperid+"&papername="+v.papername+"&remarks="+v.remarks+"' class=\"btn btn-success\">我要参加考试</a>";
                p+="<a href='/score/jop.action?paperid="+v.paperid+"' class=\"btn btn-danger\">我所有的试卷</a>";
            });$("#tbody").html(p);
        },"json")
    }

    function select2() {
        var papername=$("#papername").val();
        select(papername);
    }
</script>

</html>
