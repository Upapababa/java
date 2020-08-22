<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/21
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的试卷</title>
    <link rel="stylesheet" href="/../bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/../layer/theme/default/layer.css">
    <script src="/../bootstrap/js/jquery.min.js"></script>
    <script src="/../bootstrap/js/bootstrap.min.js"></script>
    <script src="/../layer/layer.js"></script>

    <style>
        li{
            list-style: none!important;
            margin: 20px 50px;
        }
    </style>
</head>

<body onload="toshow(${paperid},${scoreid})">

<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>${papername}(满分:${remarks})</h1>
        </div>

        <div class="panel-body">
            <table class="table table-striped table-hover" id="tbody">


            </table>
            <a href="/scoredetail/fh.action" class="btn btn-success btn-block btn-lg">返回</a>

        </div>

        <div class="panel-footer text-right">
            深圳知领，版权所有。
        </div>

    </div>
</div>
</body>

<script>
    function toshow(paperid,scoreid) {
        $.post("/scoredetail/show.action",
        "paperid="+paperid+"&scoreid="+scoreid,
        function (data) {
            var p="";
            var pp="";
            var ppp="";
            var s=1;
            var m=1;
            var n=1;
            $(data).each(function (i,v) {
                if(v.etype==1){
                    p+="<tr>";
                    p+="<td>第"+s+"题【判断题】:"+v.ename+"("+v.escore+"分)</td>";
                    p+="</tr><tr><td>";
                    p+="<li><input type='radio' name='"+v.eid+"' value='a'>"+v.ea+"</li>";
                    p+="<li><input type='radio' name='"+v.eid+"' value='b'>"+v.eb+"</li>";
                    p+="<br><br><div style='border:3px pink dashed'>";
                    p+="<li><p style='color: red'>我的答案:"+v.uanswer+"</p></li>";
                    p+="<li><p style='color: red'>正确答案:"+v.ekeys+"</p></li>";
                    p+="<li><p style='color: red'>实际得分:"+v.upoint+"</p></li>";
                    p+="<li><p style='color: red'>试题分析:"+v.ehints+"</p></li>";
                    p+="</div></td></tr>"
                    s+=1;
                }else if(v.etype==2){
                    pp+="<tr>";
                    pp+="<td>第"+(m+3)+"题【单选题】:"+v.ename+"("+v.escore+"分)</td>";
                    pp+="</tr><tr><td>";
                    pp+="<li><input type='radio' name='"+v.eid+"' value='a'>"+v.ea+"</li>";
                    pp+="<li><input type='radio' name='"+v.eid+"' value='b'>"+v.eb+"</li>";
                    pp+="<li><input type='radio' name='"+v.eid+"' value='c'>"+v.ec+"</li>";
                    pp+="<li><input type='radio' name='"+v.eid+"' value='d'>"+v.ed+"</li>";
                    pp+="<br><br><div style='border:3px pink dashed'>";
                    pp+="<li><p style='color: red'>我的答案:"+v.uanswer+"</p></li>";
                    pp+="<li><p style='color: red'>正确答案:"+v.ekeys+"</p></li>";
                    pp+="<li><p style='color: red'>实际得分:"+v.upoint+"</p></li>";
                    pp+="<li><p style='color: red'>试题分析:"+v.ehints+"</p></li>";
                    pp+="</div></td></tr>"
                    m+=1;
                }else{
                    ppp+="<tr>";
                    ppp+="<td>第"+(n+6)+"题【多选题】:"+v.ename+"("+v.escore+"分)</td>";
                    ppp+="</tr><tr><td>";
                    ppp+="<li><input type='checkbox' name='"+v.eid+"' value='a'>"+v.ea+"</li>";
                    ppp+="<li><input type='checkbox' name='"+v.eid+"' value='b'>"+v.eb+"</li>";
                    ppp+="<li><input type='checkbox' name='"+v.eid+"' value='c'>"+v.ec+"</li>";
                    ppp+="<li><input type='checkbox' name='"+v.eid+"' value='d'>"+v.ed+"</li>";
                    ppp+="<br><br><div style='border:3px pink dashed'><li><p style='color: red'>我的答案:"+v.uanswer+"</p></li>";
                    ppp+="<li><p style='color: red'>正确答案:"+v.ekeys+"</p></li>";
                    ppp+="<li><p style='color: red'>实际得分:"+v.upoint+"</p></li>";
                    ppp+="<li><p style='color: red'>试题分析:"+v.ehints+"</p></li>";
                    ppp+="</div></td></tr>"
                    n+=1;
                }

            });$("#tbody").html(p+pp+ppp);
        },"json")


    }

</script>

</html>
