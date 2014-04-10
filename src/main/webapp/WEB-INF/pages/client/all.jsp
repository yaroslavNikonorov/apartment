<%@ page import="apartment.domain.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: yar
  Date: 4/10/14
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
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
        List<Client> clients = (List<Client>) request.getAttribute("allClients");
        for (Client client : clients) {
    %>
    <tr>
        <td>
            <%out.println(client.getName());%>
        </td>
        <td>
            <%out.println(client.getPhone());%>
        </td>
        <td>
            <%out.println(client.getEmail());%>
        </td>
    </tr>
    <%}%>
    <tr>
        <td></td>
        <td>
            <input type="button" name="Add" value="Add" onclick="location.href='/client/add';"/>
        </td>
    </tr>
</table>


</body>
</html>
