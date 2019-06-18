<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User page</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
    <style>
        <%@ include file="/WEB-INF/view/css/style.css" %>
    </style>
</head>
<body class="m-3">
<h1>Users</h1>
<div class="search-menu">
    <form id="userForm" action="${pageContext.request.contextPath}/user" method="post">
        <div class="form-group">
            <label for="name">Имя</label>
            <input type="text" name="name" id="name" placeholder="Vasia">
        </div>
        <div class="form-group menu-item">
            <label for="surname">Фамилия</label>
            <input type="text" name="surname" id="surname" placeholder="Vasin">
        </div>
        <div class="form-group menu-item date-picker">
            <label for="date">Страше чем</label>
            <input type="date" name="birthDate" id="date">
        </div>
        <div class="form-group menu-item ">
            <label for="offset">начиная с</label>
            <input type="number" id="offset" name="offset" min="0" required value="0">
        </div>
        <div class="form-group menu-item">
            <label for="limit">заканчивая</label>
            <input type="number" id="limit" name="limit" min="0" required value="0">
        </div>
        <div class="form-group-date col-md-2">
            <label for="records">Записей на странице</label>
            <select class="form-control" id="records" name="recordsPerPage">
                <option value="1">1</option>
                <option value="2" selected>2</option>
            </select>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
        <div class="row col-md-5">
            <table class="table table-striped table-bordered table-sm">
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Birth date</th>
                </tr>
                <c:forEach var="user" items="${requestScope.users}">
                    <tr>
                        <td>${user.name}</td>
                        <td>${user.surname} </td>
                        <td>${user.birthDate}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <nav aria-label="Navigation for countries">
            <ul class="pagination">
                <c:if test="${requestScope.currentPage != 1}">
                    <li class="page-item"><a class="page-link"
                                             href="user?recordsPerPage=${requestScope.recordsPerPage}
                                             &currentPage=${requestScope.currentPage-1}">Previous</a>
                    </li>
                </c:if>

                <c:forEach begin="1" end="${requestScope.pageNumber}" var="i">
                    <c:choose>
                        <c:when test="${requestScope.currentPage eq i}">
                            <li class="page-item active"><a class="page-link">
                                    ${i} <span class="sr-only">(current)</span></a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link"
                                                     href="user?recordsPerPage=${requestScope.recordsPerPage}
                                                     &currentPage=${i}">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${requestScope.currentPage lt requestScope.n}">
                    <li class="page-item"><a class="page-link"
                                             href="user?recordsPerPage=${requestScope.recordsPerPage}
                                             &currentPage=${requestScope.currentPage+1}">Next</a>
                    </li>
                </c:if>
            </ul>
        </nav>
        <input type="hidden" name="currentPage" value="1">
    </form>
</div>
</body>
</html>
