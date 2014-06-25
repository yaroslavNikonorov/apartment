<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="apartment.domain.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<table>
    <tr>
        <td>Name</td>
        <td>Phone</td>
        <td>Email</td>
    </tr>
    <%

        for (User user : (Iterable<User>) request.getAttribute("users")) {
    %>
    <%--<c:forEach items="${users}" var="user">--%>
    <tr>
        <td>
            <%out.println(user.getUsername());%>
            <%--<c:out value="${user.get}"/>--%>
        </td>
        <td>
            <%out.println(user.getPhone());%>
        </td>
        <td>
            <%out.println(user.getEmail());%>
        </td>
    </tr>
    <%}%>
    <%--</c:forEach>--%>
    <tr>
        <td></td>
        <td>
            <input type="button" name="Add" value="Add" onclick="location.href='/user/add';"/>
        </td>
    </tr>
</table>

</body>
</html>
