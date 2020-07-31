<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/30
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
      <link rel="stylesheet" href="layer/theme/default/layer.css">
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="layer/layer.js"></script>

  </head>
  <body onload="sel(1)">
  <div class="container">
    <div class="panel panel-primary">
      <div class="panel-heading">
        <h1>会议室列表</h1>
      </div>

      <div class="panel-body">

          <table class="table">

              <a class="btn btn-success" data-toggle="modal" data-target="#myModal">添加</a><span>${msg}</span>

              <tr>
                <%--序号、会议室编号、会议室名称、会议室地 址、会议室容量--%>
                <td>序号</td>
                <td>会议室编号</td>
                <td>会议室名称</td>
                <td>会议室地址</td>
                <td>会议室容量</td>
                <td>操作</td>
              </tr>
              <tbody id="tbody">

              </tbody>
              <%--旧代码，利用jsp实现--%>
              <%--会议室信息--%>
              <%--<c:forEach items="${list}" var="cr">--%>
                  <%--<tr id='${cr.crid}'>--%>
                    <%--<td>${cr.crid}</td>--%>
                    <%--<td>${cr.crno}</td>--%>
                    <%--<td>${cr.crname}</td>--%>
                    <%--<td>${cr.craddr}</td>--%>
                    <%--<td>${cr.capacity}</td>--%>
                    <%--<td>--%>
                        <%--<a class="btn btn-success" href="#" data-toggle="modal" data-target="#myModal"--%>
                           <%--onclick="update('${cr.crid}','${cr.crno}','${cr.crname}','${cr.craddr}','${cr.capacity}')">--%>
                            <%--修改--%>
                        <%--</a>--%>
                        <%--<a class="btn btn-danger" onclick="del('${cr.crid}')" >删除</a>--%>
                    <%--</td>--%>
                  <%--</tr>--%>
              <%--</c:forEach>--%>
          </table>

          <%--分页信息--%>
          <ul class="pagination" id="fy">
              <%--旧代码，利用jsp实现--%>
              <%--<c:if test="${page!=1}">--%>
                  <%--<li><a href="/show?page=${page-1}">&laquo;</a></li>--%>
              <%--</c:if>--%>
              <%--<c:forEach begin="1" end="${count}" var="s">--%>
                  <%--<c:if test="${s==page}" var="flag">--%>
                      <%--<li><a href="/show?page=${s}" style="background-color:#2aabd2;color:white;">${s}</a></li>--%>
                  <%--</c:if>--%>
                  <%--<c:if test="${not flag}">--%>
                      <%--<li><a href="/show?page=${s}">${s}</a></li>--%>
                  <%--</c:if>--%>
              <%--</c:forEach>--%>

              <%--<c:if test="${page!=count}">--%>
                  <%--<li><a href="/show?page=${page+1}">&raquo;</a></li>--%>
              <%--</c:if>--%>
          </ul>

      </div>

        <!-- 模态框（Modal） -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">添加或修改用户信息</h4>
                    </div>

                    //添加表单
                    <div class="modal-body">
                        <form  id="hform" class="form-horizontal" role="form" >
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">会议室编号：</label>
                            <div class="col-sm-5">
                                <input hidden name="uid" id="crid">
                                <input type="number" class="form-control" id="crno" name="uno"  >
                            </div>
                        </div>

                        <div class="form-group">
                            <label  class="col-sm-2 control-label">会议室名：</label>
                            <div class="col-sm-5">
                                <input  class="form-control" id="crname" name="uname"  >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">会议室地址：</label>
                            <div class="col-sm-5">
                                <input  class="form-control" id="craddr"  name="uaddr"  >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">会议室容量：</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="capacity"  name="upa"  >
                            </div>
                        </div>


                        <%--//提交表单--%>
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" onclick="tj()" class="btn btn-primary">提交</button>

                    </form>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>

      <div class="panel-footer text-right">
        深圳知领，版权所有。
      </div>
    </div>
  </div>
  </body>
<script>
function sel(page){
    //新代码，利用ajax实现分页和查询会议室信息
    $.get("/show?page="+page,function (data) {
        var p="";       //利用p实现查询会议室信息
        var pp="";    //利用pp实现分页的html代码
        if(Number(data.page)!=1){   //当单前页码不为1时显示上一页标签
            pp+="<li><a onclick='sel("+Number(data.page-1)+")'>&laquo;</a></li>";
        }
        for (var i = 1; i <= Number(data.count) ; i++) {
            if(i==Number(data.page)){
                pp+="<li><a onclick='sel("+i+")' style=\"background-color:#2aabd2;color:white;\">"+i+"</a></li>";
            }else{
                pp+="<li><a onclick='sel("+i+")'>"+i+"</a></li>";
            }
        }
        if(Number(data.page)!=Number(data.count)){
            pp+="<li><a onclick='sel("+Number(data.page+1)+")'>&raquo;</a></li>";
        }
        $(data.list).each(function (i,v) {
            p+="<tr id='"+v.crid+"'>";
            p+="<td>"+v.crid+"</td>";
            p+="<td>"+v.crno+"</td>";
            p+="<td>"+v.crname+"</td>";
            p+="<td>"+v.craddr+"</td>";
            p+="<td>"+v.capacity+"</td>";
            p+="<td>";
            p+="<a class=\"btn btn-success\" href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\" \t";
            p+="onclick=\"update('"+v.crid+"','"+v.crno+"','"+v.crname+"','"+v.craddr+"','"+v.capacity+"')\">";
            p+="修改</a>";
            p+="<a class=\"btn btn-danger\" onclick=\"del('"+v.crid+"')\" >删除</a>";
            p+="</td>";
            p+="</tr>";
        });$("#tbody").html(p);
            $("#fy").html(pp);
    },"json")
}

    function tj() {
        $.post("/add",
             $("#hform").serialize(),
            function (data) {
            $("#myModal").modal("hide");
            sel(1);
            layer.msg(data, {icon: 6});
        },"text");
    }



    function update(crid,crno,crname,craddr,capacity) {
        $("#crid").val(crid);
        $("#crno").val(crno);
        $("#crname").val(crname);
        $("#craddr").val(craddr);
        $("#capacity").val(capacity);
    }
    function del(crid) {
        $.get("/add?crid="+crid,function (data) {
            if(data!=0){
                $("#"+crid).remove();
                $("span").val("删除成功");
            }
        },"text")
    }


</script>
</html>
