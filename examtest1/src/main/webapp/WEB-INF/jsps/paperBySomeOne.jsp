<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/21
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的所有试卷</title>
    <link rel="stylesheet" href="/../bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/../layer/theme/default/layer.css">
    <script src="/../bootstrap/js/jquery.min.js"></script>
    <script src="/../bootstrap/js/bootstrap.min.js"></script>
    <script src="/../layer/layer.js"></script>
</head>
<body onload="select(${paperid})">
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>我的所有试卷列表</h1>
        </div>

        <div class="panel-body">

            <table class="table table-hover table-striped">
                <tr>
                    <td>序号</td>
                    <td>试卷编号</td>
                    <td>试卷名称</td>
                    <td>试卷分数</td>
                    <td>我的分数</td>
                    <td>正确题数</td>
                    <td>错误题数</td>
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
    function select(paperid) {
        $.post("/myItems/selectItems.action",
        "paperid="+paperid,
        function (data) {
            var p="";
            $(data).each(function (i,v){
                p+="<tr>";
                p+="<td>"+(i+1)+"</td>";
                p+="<td>"+v.paperid+"</td>";
                p+="<td>"+v.papername+"</td>";
                p+="<td>"+v.remarks+"</td>";
                p+="<td>"+v.score+"</td>";
                p+="<td>"+v.rights+"</td>";
                p+="<td>"+v.errors+"</td>";
                p+="<td>";
                p+="<a href='/scoredetail/luru.action?scoreid="+v.scoreid+"&paperid="+v.paperid+"' class=\"btn btn-success\">我要查看试卷</a>";
            });$("#tbody").html(p);
        },"json");
    }

</script>
</html>
