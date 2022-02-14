<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/14/2022
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/product?action=create">Create new product</a>
</p>
<form>
<input type="text" name="search" placeholder="search by name">
<input type="text" name="action" hidden value="search">
<button>Search</button>
</form>
<table border="1" id="example" class="table table-striped" style="width:70%">
    <thead>
    <tr>
        <th>Name</th>
        <th>Information</th>
        <th>Country</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><a href="/product?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getInformation()}</td>
            <td>${product.getCountry()}</td>
            <td><a href="/product?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/product?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#example').DataTable();
    } );
</script>

</body>
</html>
