<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="/resources/css/basic.css" rel="stylesheet">

    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/1.9.0/jquery.min.js"  />"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/js/bootstrap.js"  />"></script>

    <title>Serg-Hotel - ${title}</title>
</head>
</tab>
<c:import url="page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-10 col-lg-offset-1">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="text-center">
                        <h1>${title}</h1>
                    </div>
                </div>
                <div class="alert alert-info" role="alert">
                    <a class="btn btn-primary" role="button" href="/${instrument}/pdfReport?view=pdfView" target="_blank">Download PDF report</a>
                    <a class="btn btn-primary" role="button" href="/${instrument}/xlsxReport.xlsx?view=excelView" target="_blank">Download Excel report</a>
                </div>
                <div class="panel-body">
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <div class="text-center"><h3>Categories</h3></div>
                        </div>
                        <table class="table table-striped table-condensed" id="room-categories">
                            <thead>
                            <th><button class="sort" data-sort="categories-name">category name</button></th>
                            <th><button class="sort" data-sort="categories-id">category id</button></th>
                            <th><button class="sort" data-sort="number-of-places">number of places</button></th>
                            <th><button class="sort" data-sort="wi-fi">wifi</button></th>
                            <th><button class="sort" data-sort="breakfast">breakfast</button></th>
                            <th><button class="sort" data-sort="dinner">dinner</button></th>
                            <th><button class="sort" data-sort="jacuzzi">jacuzzi</button></th>
                            <th><button class="sort" data-sort="tv">tv</button></th>
                            <th><button class="sort" data-sort="price">price</button></th>
                            <th>action</th>
                            </thead>
                            <tbody align="center" class="list">
                            <c:forEach var="category" items="${listCategory}" varStatus="status">
                                <tr>
                                    <td class="categories-name">${category.name}</td>
                                    <td class="categories-id">${category.idCategory}</td>
                                    <td class="number-of-places">${category.numberOfPlaces}</td>
                                    <td class="wi-fi">${category.wifi ? 'Входит в стоимость' : 'Дополнительная плата'}</td>
                                    <td class="breakfast">${category.breakfast ? 'Входит в стоимость' : 'Дополнительная плата'}</td>
                                    <td class="dinner">${category.dinner ? 'Входит в стоимость' : 'Дополнительная плата'}</td>
                                    <td class="jacuzzi">${category.jacuzzi ? 'Входит в стоимость' : 'Дополнительная плата'}</td>
                                    <td class="tv">${category.tv ? 'Входит в стоимость' : 'Дополнительная плата'}</td>
                                    <td class="price">${category.price}</td>
                                    <td class="action">
                                        <a href="/${instrument}/edit-Category/${category.idCategory}">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="/${instrument}/delete-Category/${category.idCategory}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="panel-footer"><a class="btn btn-info" role="button" href="/${instrument}/newCategory">Add new category &raquo</a></div>
                    </div>

                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <div class="text-center"><h3>Rooms</h3></div>
                        </div>
                        <table class="table table-striped table-condensed" id="rooms">
                            <thead>
                            <th><button class="sort" data-sort="category">category</button></th>
                            <th><button class="sort" data-sort="idRoom">idRoom</button></th>
                            <th><button class="sort" data-sort="roomName">roomName</button></th>
                            <th><button class="sort" data-sort="roomNumber">roomNumber</button></th>
                            <th><button class="sort" data-sort="status">status</button></th>
                            <th>action</th>
                            </thead>
                            <tbody align="center" class="list">
                            <c:forEach var="room" items="${listRoom}" varStatus="status">
                                <tr>
                                    <td class="category">${room.idCategory}</td>
                                    <td class="idRoom">${room.idRoom}</td>
                                    <td class="roomName">${room.roomName}</td>
                                    <td class="roomNumber">${room.roomNumber}</td>
                                    <td class="status">${room.status}</td>
                                    <td>
                                        <a href="/${instrument}/edit-room/${room.idRoom}">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="/${instrument}/delete-room/${room.idRoom}">Delete</a>
                                    </td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="panel-footer"><a class="btn btn-info" role="button" href="/${instrument}/newRoom">Add new room &raquo</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/resources/js/list.min.js"></script>
<script src="/resources/js/content-list.js"></script>
</body>
</html>