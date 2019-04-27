<%--
  Created by IntelliJ IDEA.
  User: Sc
  Date: 27.04.2019
  Time: 1:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="user" items="${requestScope.users}">
    <p><c:out value="User id:${user.id} name :${user.name}"></c:out></p>
</c:forEach>
</body>
</html>
