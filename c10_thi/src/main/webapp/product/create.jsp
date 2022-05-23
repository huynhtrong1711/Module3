<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/24/2022
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <%--    <meta name='viewport' content='width=device-width, initial-scale=1'>--%>
    <%--    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>--%>
</head>
<body>
<h1 style="text-align: center">ADD PRODUCT</h1>
<p>
    <a class="btn btn-success" href="/product">Back to product list</a>
</p>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-9">
            <form action="/product?action=create" method="post">
                <div class="form-group">
                    <label for="product_name">Name</label>
                    <input type="text" class="form-control" id="product_name" name="name_product">
                </div>
                <div class="form-group">
                    <label for="price">Price</label>
                    <input type="text" class="form-control" id="price" name="price">
                </div>
                <div class="form-group">
                    <label for="amount">Amount</label>
                    <input type="text" class="form-control" id="amount" name="amount">
                </div>
                <div class="form-group">
                    <label for="color">color</label>
                    <input type="text" class="form-control" id="color" name="color">
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" id="description" name="description">
                </div>
                <div class="form-group">
                    <label for="id_category">Category</label>
                    <%--          <input type="text" class="form-control" id="customer_type_id" name="customer_type_id">--%>
                    <select class="form-control" id="id_category" name="id_category">
                        <c:forEach var="type" items="${categoryList}">
                            <option value="${type.idCategory}">${type.nameCategory}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
<%--<i style='font-size:20px' class='fas'>&#xf359;</i>--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
