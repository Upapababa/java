<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>深圳美团外卖点餐页面</title>
    <%--引用bootstrap框架； --%>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>深圳美团外卖点餐页面
                <span>${msg}</span>
            </h1>
        </div>
        <div class="panel-body">

            <div class="row">
                <c:forEach items="${list}" var="f">
                    <div class="col-sm-6 col-md-3">
                        <div class="thumbnail">
                            <img src="imgs/${f.fimg}" alt="${f.fname}">
                            <div class="caption">
                                <h3>${f.fname}: ${f.fprice}元 </h3>
                                <p>${f.fshop}/${f.ftype}</p>
                                <p><a href="/shop?fid=${f.fid}" class="btn btn-primary">放入购物车</a>
                                    <a href="/appraise?fid=${f.fid}" class="btn btn-danger" >查看评价</a></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <a href="car.jsp" class="btn btn-success btn-lg btn-block">查看我的购物车</a>

        </div>
        <div class="panel-footer text-right">
                深圳知领java44班开发。版权所有，复制必究！
        </div>
    </div>
</div>


</body>
</html>
