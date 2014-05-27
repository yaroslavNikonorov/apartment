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
    <tr>
        <td>
            <%out.println(user.getUsername());%>
        </td>
        <td>
            <%out.println(user.getPhone());%>
        </td>
        <td>
            <%out.println(user.getEmail());%>
        </td>
    </tr>
    <%}%>
    <tr>
        <td></td>
        <td>
            <input type="button" name="Add" value="Add" onclick="location.href='/user/add';"/>
        </td>
    </tr>
</table>

</body>
</html>
