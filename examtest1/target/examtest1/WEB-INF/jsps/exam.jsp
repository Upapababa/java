<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/20
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试界面</title>
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
<body onload="select(${paperid})">

<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>${papername}(满分:${remarks})</h1>
        </div>


        <div class="panel-body">
            <form>
                <table class="table table-striped table-hover" id="tbody">

                </table>
                <a onclick="tj()" class="btn btn-success btn-block btn-lg">交卷</a>
            </form>

        </div>

        <div class="panel-footer text-right">
            深圳知领，版权所有。
        </div>
    </div>
</div>

</body>

<script>
    function select(paperid) {
        $.post("/items/select.action",
            "paperid="+paperid,
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
                        p+="<li><input type='radio' name='"+v.eid+"' value='a'>"+v.ea+"<li>";
                        p+="<li><input type='radio' name='"+v.eid+"' value='b'>"+v.eb+"<li>";
                        p+="</td></tr>"
                        s+=1;
                    }else if(v.etype==2){
                        pp+="<tr>";
                        pp+="<td>第"+(m+3)+"题【单选题】:"+v.ename+"("+v.escore+"分)</td>";
                        pp+="</tr><tr><td>";
                        pp+="<li><input type='radio' name='"+v.eid+"' value='a'>"+v.ea+"<li>";
                        pp+="<li><input type='radio' name='"+v.eid+"' value='b'>"+v.eb+"<li>";
                        pp+="<li><input type='radio' name='"+v.eid+"' value='c'>"+v.ec+"<li>";
                        pp+="<li><input type='radio' name='"+v.eid+"' value='d'>"+v.ed+"<li>";
                        pp+="</td></tr>"
                        m+=1;
                    }else{
                        ppp+="<tr>";
                        ppp+="<td>第"+(n+6)+"题【多选题】:"+v.ename+"("+v.escore+"分)</td>";
                        ppp+="</tr><tr><td>";
                        ppp+="<li><input type='checkbox' name='"+v.eid+"' value='a'>"+v.ea+"<li>";
                        ppp+="<li><input type='checkbox' name='"+v.eid+"' value='b'>"+v.eb+"<li>";
                        ppp+="<li><input type='checkbox' name='"+v.eid+"' value='c'>"+v.ec+"<li>";
                        ppp+="<li><input type='checkbox' name='"+v.eid+"' value='d'>"+v.ed+"<li>";
                        ppp+="</td></tr>"
                        n+=1;
                    }

                });$("#tbody").html(p+pp+ppp);
            },"json");
    }
    
    function tj() {
        $.ajax({
            url:"/items/submit.action",
            type:"post",
            data:JSON.stringify($('form').serializeObject()),
            contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
            success:function (data) {
                window.location.href="/score/great.action?score="+data;
            }
        })
    }

    $.fn.serializeObject = function() {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [ o[this.name] ];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
</script>
</html>
