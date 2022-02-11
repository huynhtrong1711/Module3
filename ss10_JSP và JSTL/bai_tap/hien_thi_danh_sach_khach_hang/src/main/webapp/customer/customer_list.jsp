<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/11/2022
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách cầu thủ</h2>
<table border="1">
   <tr>
       <th>STT</th>
       <th>Tên</th>
       <th>Ngày sinh</th>
       <th>Quốc gia</th>
       <th>Ảnh</th>
   </tr>
    <c:forEach var="customer" items="${list}">
        <tr>
            <td><c:out value="${customer.code}"></c:out></td>
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.dateOB}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td><img src="${customer.picture}" alt="" width="100px"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
