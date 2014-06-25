<%@ page import="apartment.domain.Apartment" %>
<%@ page import="apartment.domain.Bid" %>
<%--<%@ page import="apartment.domain.User" %>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--<h3><%out.println((String)request.getAttribute("user"));%></h3>--%>
<%--<h3><%out.println((String)request.getAttribute("id"));%></h3>--%>
<table>
    <tr>
        <td>Address</td>
        <td>Bids</td>
        <td></td>
    </tr>
    <%

        if (request.getAttribute("apartments") != null) {
            for (Apartment apartment : (Iterable<Apartment>) request.getAttribute("apartments")) {
    %>
    <tr>
        <td>
            <%out.print(apartment.getAddress());%>
        </td>
        <td>
            <%
                for (Bid bid : apartment.getBids()) {
                    if(bid.getClient()!=null){
                        out.print(bid.getClient().getName()+": "+bid.getPrice());
//                        out.print(bid.getPrice());
                    }
            %> </br>
            <%}%>
        </td>
        <td>
            <form action="/apartment/addbid" method="get">
                <input type="hidden" value="<%out.print(apartment.getId());%>" name="apartmentId">
                <input type="text" value="" name="price">
                <input type="submit" value="Add">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
    <tr>
        <td></td>
        <td>
            <input type="button" name="Add" value="Add" onclick="location.href='/apartment/add';"/>
        </td>
    </tr>
</table>

</body>
</html>
