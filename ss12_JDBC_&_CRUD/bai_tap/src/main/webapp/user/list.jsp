<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/17/2022
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h2>List User</h2>
<form action="/usersE" method="get">
    <input type="hidden" name="action" value="search">
    <label>Country Users: </label>
    <input type="text" name="country">
    <button type="submit">Tìm kiếm</button>
</form>
<a href="/usersE?action=create">Create User</a>
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
                <a href="/usersE?action=update&id=${usersList.getId()}">Edit</a>
                <a href="/usersE?action=delete&id=${usersList.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script>
    $(document).ready(function() {
        $('#c10').DataTable();
    } );
</script>

</body>
</html>

