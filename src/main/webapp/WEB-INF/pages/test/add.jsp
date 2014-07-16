<%--
  Created by IntelliJ IDEA.
  User: yar
  Date: 6/16/14
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/test/add" method="post">
    <label for="id_name">Name</label>
    <input id="id_name" type="text" name="name"> </br>
    <label for="id_phone">Phone</label>
    <input id="id_phone" type="text" name="phone"> </br>
    <label for="id_email">Email</label>
    <input id="id_email" type="text" name="email"> </br>
    <%String apartmentId= (String) request.getAttribute("apartmentId");
    String price= (String) request.getAttribute("price");
    if(apartmentId!=null&&price!=null){%>
    <input type="hidden" name="apartmentId" value="<%out.print(apartmentId);%>">
    <input type="hidden" name="price" value="<%out.print(price);%>">
    <%}%>
    <input type="submit" value="Add">
    <input type="reset" value="Clear">
</form>
</body>
</html>
