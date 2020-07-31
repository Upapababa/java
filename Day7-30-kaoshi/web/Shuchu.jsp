<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/31
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<tr id='${v.crid}'>
    <td>v.crid</td>
    <td>v.crno</td>
    <td>v.crname</td>
    <td>v.craddr</td>
    <td>v.capacity</td>
    <td>
        <a class="btn btn-success" href="#" data-toggle="modal" data-target="#myModal"
        onclick="update(v.crid,v.crno,v.crname,v.craddr,v.capacity)">
        修改
        </a>
        <a class="btn btn-danger" onclick="del(v.crid)" >删除</a>
    </td>
</tr>
</body>
</html>
