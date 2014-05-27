<%@ page import="apartment.domain.Group" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<table>
    <tr>
        <td>Name</td>
    </tr>
    <%

        for (Group group: (Iterable<Group>) request.getAttribute("groups")) {
    %>
    <tr>
        <td>
            <%out.println(group.getGroupname());%>
        </td>
    </tr>
    <%}%>
    <tr>
        <td></td>
        <td>
            <input type="button" name="Add" value="Add" onclick="location.href='/group/add';"/>
        </td>
    </tr>
</table>
</body>
</html>
