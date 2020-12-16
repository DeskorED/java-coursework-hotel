<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
                        <h1>${action} category <small>using ${title}</small></h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form:form method="POST" modelAttribute="category" class="form-horizontal">
                        <form:hidden path="idCategory"/>
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">Name of category:</label>
                            <div class="col-sm-9">
                                <form:input path="name" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="numberOfPlaces" class="col-sm-3 control-label">Number of places:</label>
                            <div class="col-sm-9">
                                <form:input path="numberOfPlaces" class="form-control" type="number"  max="12"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">Wi-fi:</label>
                            <div class="col-sm-9">
                                <form:checkbox path="wifi" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">Breakfast:</label>
                            <div class="col-sm-9">
                                <form:checkbox path="breakfast" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">Dinner:</label>
                            <div class="col-sm-9">
                                <form:checkbox path="dinner" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">Jacuzzi:</label>
                            <div class="col-sm-9">
                                <form:checkbox path="jacuzzi" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">TV:</label>
                            <div class="col-sm-9">
                                <form:checkbox path="tv" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Price" class="col-sm-3 control-label">Price ($):</label>
                            <div class="col-sm-9">
                                <form:input path="price" class="form-control" />
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