<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/22/2022
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<h1 style="text-align: center">PRODUCT TABLE</h1>
<a class="btn btn-success" href="/products?action=create"><i style='font-size:20px' class='fas'>&#xf382;</i>Add new customer</a>
<form action="/products?action=searchByName" method="get">
    <input type="hidden" name="action" value="searchByName">
    <label>Name Product: </label>
    <input type="text" name="name">
    <button type="submit"><i style='font-size:20px' class='fas'>&#xf002;</i>Tìm kiếm</button>
</form>
<table id="product" class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Amount</th>
        <th scope="col">Color</th>
        <th scope="col">Description</th>
        <th scope="col">Category</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td >${product.id}</td>
            <td >${product.nameProduct}</td>
<%--            <td ><a href="/products?action=view&customerId=${product.getId()}">${product.nameProduct}</a></td>--%>
            <td >${product.price}</td>
            <td >${product.amount}</td>
            <td >${product.color}</td>
            <td >${product.description}</td>
            <td >${product.nameCategory}</td>
            <td>
                <button type="button" class="btn btn-warning"><a  href="/products?action=update&id=${product.getId()}"><i style='font-size:20px' class='far'>&#xf044;</i>Edit</a></button>
                <button onclick="deleteFrom('${product.getId()}','${product.getNameProduct()}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
                    <i style="font-size: 20px" class="material-icons">&#xe872;</i>Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure delete <span class="text-danger" id="name-customer"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button onclick="submitFormDelete()" type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>

<form hidden id="form-delete" method="post" action="/products">
    <input type="text" name="action" value="delete">
    <input type="text" name="id" id="id-customer">
</form>

<script>
    function deleteFrom(id, name) {
        document.getElementById("id-customer").value = id;
        document.getElementById("name-customer").innerText = name;
        console.log(id);
    }
    function submitFormDelete() {
        document.getElementById("form-delete").submit();
    }
</script>

<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>

<script>
    $(document).ready(function() {
        $('#product').DataTable();
    } );
</script>
</body>
</html>
