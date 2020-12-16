<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link href="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="/resources/css/basic.css" rel="stylesheet">

    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/1.9.0/jquery.min.js"  />"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/js/bootstrap.js"  />"></script>

    <title>${title}</title>
</head>
<body>
<c:import url="page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="text-center">
                        <h1>${action} room <small>using ${title}</small></h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form:form method="POST" modelAttribute="room" class="form-horizontal">
                        <form:hidden path="idRoom"/>
                        <div class="form-group">
                            <label for="idCategory" class="col-sm-3 control-label" >Category:</label>
                            <div class="col-sm-9">
                                <form:select path="idCategory" multiple="false" class="form-control">
                                    <c:forEach var="category" items="${listCategory}" varStatus="status">
                                        <c:choose>
                                            <c:when test="${room.idCategory == category.idCategory}">
                                                <option selected value="${category.idCategory}">${category.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${category.idCategory}">${category.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="roomName" class="col-sm-3 control-label">Room:</label>
                            <div class="col-sm-9">
                                <form:input path="roomName" class="form-control" required="required"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="roomNumber" class="col-sm-3 control-label">RoomNumber:</label>
                            <div class="col-sm-9">
                                <form:input  path="roomNumber" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">Status:</label>
                            <div class="col-sm-9">
                                <form:checkbox path="status" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>