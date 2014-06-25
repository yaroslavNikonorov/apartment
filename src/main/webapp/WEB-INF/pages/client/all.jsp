<%@ page import="apartment.domain.Client" %>
<%--
  Created by IntelliJ IDEA.
  User: yar
  Date: 6/20/14
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <tr><td>Name</td></tr>
    <%for(Client client: (Iterable<Client>)request.getAttribute("clients")){%>
    <tr><td><%out.print(client.getName());%></td></tr>
    <%}%>
</table>
</body>
</html>
