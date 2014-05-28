<%@ page import="apartment.domain.Group" %>
<%@ page import="apartment.domain.Role" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/user/add" method="post">
    <label for="id_username">Username</label>
    <input type="text" id="id_username" name="username" value=""></br>
    <label for="id_groups">Groups</label>
    <select multiple="multiple" size="3" id="id_groups" class="checkout_select" name="groups">
        <%for (Role role: (Role[])request.getAttribute("roles")){%>
        <option value=<%out.println(role.name());%>><%out.println(role.name());%></option>
        <%}%>
    </select>
    <label for="id_phone">Phone</label>
    <input type="text" id="id_phone" name="phone" value=""></br>
    <label for="id_email">Email</label>
    <input type="text" id="id_email" name="email" value=""></br>
    <label for="id_password">Password</label>
    <input type="password" id="id_password" name="password" value=""></br>
    <input type="submit" value="add">
    <input type="reset" value="clear">
</form>
</body>
</html>
