<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/17/2022
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
</head>
<body>
<h2>List User</h2>
<a href="/users?action=create">Create Student</a>
<h2>${message}</h2>
<table border="1" id="c10" class="table table-striped table-bordered" style="width:70%">
    <thead>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="usersList" items="${list}">
        <tr>
            <td>${usersList.getId()}</td>
            <td>${usersList.getName()}</td>
            <td>${usersList.getEmail()}</td>
            <td>${usersList.getCountry()}</td>
            <td>
                <a href="/users?action=update&id=${usersList.getId()}">Edit</a>
                <a href="/users?action=delete&id=${usersList.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#c10').DataTable();
    } );
</script>

</body>
</html>
