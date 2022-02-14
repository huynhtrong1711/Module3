<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/14/2022
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <td>Information: </td>
        <td>${requestScope["product"].getInformation()}</td>
    </tr>
    <tr>
        <td>Country: </td>
        <td>${requestScope["product"].getCountry()}</td>
    </tr>
</table>
</body>
</html>
