<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="/resources/css/basic.css" rel="stylesheet">
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/1.9.0/jquery.min.js"  />"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/js/bootstrap.js"  />"></script>
    <title>Hotel controller</title>
</head>
<body>
<c:import url="page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <div class="jumbotron" id="index_jumbotron">
                <div class="text-center"><h1>Serg HOTEL</h1></div>
                <p class="lead text-center text-nowrap">A piece of heavenly pleasure at the end of the earth</p>
            </div>
            <div class="cols">
                <div class="row">
                    <div class="col-lg-4">
                        <img class="img-rounded" src="/resources/img/koggala-beach-hotel.jpg" alt="Hotel logo" width="400" height="360">
                        <p>You have come to the site of my hotel, which is the 8th wonder of the world, my hotel has the title of 10 stars and our restaurant has 5 Michelin stars</p>
                        <p><a class="btn btn-primary" href="/rooms" role="button">View room-list &raquo;</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>