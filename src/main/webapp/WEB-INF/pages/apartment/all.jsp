<%@ page import="apartment.domain.Apartment" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<table>
    <tr>
        <td>Name</td>
        <td>Address</td>
    </tr>
    <%

        for (Apartment apartment : (Iterable<Apartment>) request.getAttribute("apartments")) {
    %>
    <tr>
        <td>
            <%out.println(apartment.getName());%>
        </td>
        <td>
            <%out.println(apartment.getAddress());%>
        </td>
    </tr>
    <%}%>
    <tr>
        <td></td>
        <td>
            <input type="button" name="Add" value="Add" onclick="location.href='/apartment/add';"/>
        </td>
    </tr>
</table>

</body>
</html>
