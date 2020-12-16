<%@ page import="javavt18.rooms.Category" %>
<%@ page import="javavt18.rooms.Room" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/css/bootstrap.min.css" />"
          rel="stylesheet">
    <link href="/resources/css/basic.css" rel="stylesheet">

    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/1.9.0/jquery.min.js"  />"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/js/bootstrap.js"  />"></script>

    <title>Serg-Hotel - ${title}</title>
</head>
</tab>
<c:import url="page_components/header.jsp"></c:import>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-10 col-lg-offset-1">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="text-center">
                        <h1>${title}</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <div class="text-center"><h3>Categories</h3></div>
                        </div>
                        <table class="table table-striped table-condensed" id="room-categories">
                            <thead>
                            <th>
                                <button class="sort" data-sort="categories-name">Category name</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="number-of-places">Number of places</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="wi-fi">Wi-fi</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="breakfast">Breakfast</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="dinner">Dinner</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="jacuzzi">Jacuzzi</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="tv">TV</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="price">Price ($)</button>
                            </th>
                            <th>action</th>
                            </thead>
                            <tbody align="center" class="list">
                            <c:forEach var="category" items="${listCategory}" varStatus="status">
                                <tr>
                                    <td class="categories-name">${category.name}</td>
                                    <td class="number-of-places">${category.numberOfPlaces}</td>
                                    <td class="wi-fi">${category.wifi ? 'Included' : 'Surcharge'}</td>
                                    <td class="breakfast">${category.breakfast ? 'Included' : 'Surcharge'}</td>
                                    <td class="dinner">${category.dinner ? 'Included' : 'Surcharge'}</td>
                                    <td class="jacuzzi">${category.jacuzzi ? 'Included' : 'Surcharge'}</td>
                                    <td class="tv">${category.tv ? 'Included' : 'Surcharge'}</td>
                                    <td class="price">${category.price}</td>
                                    <td class="action">
                                        <a href="/${instrument}/edit-category/${category.idCategory}">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="/${instrument}/delete-category/${category.idCategory}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="panel-footer"><a class="btn btn-info" role="button"
                                                     href="/${instrument}/newCategory">Add new category &raquo</a></div>
                    </div>

                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <div class="text-center"><h3>Rooms</h3></div>
                        </div>
                        <table class="table table-striped table-condensed" id="rooms">
                            <thead>
                            <th>
                                <button class="sort" data-sort="category">category</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="roomName">roomName</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="roomNumber">roomNumber</button>
                            </th>
                            <th>
                                <button class="sort" data-sort="status">status</button>
                            </th>
                            <th>action</th>
                            </thead>
                            <tbody align="center" class="list">
                            <c:forEach var="room" items="${listRoom}" varStatus="status">
                                <tr>
                                    <%
                                        Category roomCategory = null;
                                        for (Category cat : (List<Category>) pageContext.findAttribute("listCategory")) {
                                            if (cat.getIdCategory() == ((Room) pageContext.findAttribute("room")).getIdCategory())
                                                roomCategory = cat;
                                        }
                                        pageContext.setAttribute("roomCategory", roomCategory);
                                    %>
                                    <td class="category">${roomCategory.name}</td>
                                    <td class="roomName">${room.roomName}</td>
                                    <td class="roomNumber">${room.roomNumber}</td>
                                    <td class="status">${room.status? 'reserved':'free'}</td>
                                    <td>
                                        <a href="/${instrument}/edit-room/${room.idRoom}">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="/${instrument}/delete-room/${room.idRoom}">Delete</a>
                                    </td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="panel-footer"><a class="btn btn-info" role="button" href="/${instrument}/newRoom">Add
                            new room &raquo</a></div>
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