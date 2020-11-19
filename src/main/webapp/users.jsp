<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Users</title>
</head>
<body>
<h1>LIST USERS</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Password</th>
        <th>BirthDate</th>
        <c:forEach items = "${users}" var="user">
    <tr>
        <td>${user.getId()}</td>
        <td>${user.getLogin()}</td>
        <td>${user.getPassword()}</td>
        <td>${user.getBirthdate()}</td>
    </tr>
    </c:forEach>
    </tr>
</table>
</body>
</html>
