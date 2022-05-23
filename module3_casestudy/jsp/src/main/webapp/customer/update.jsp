<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/21/2022
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
<h1 style="text-align: center">UPDATE CUSTOMER</h1>
<p>
    <a class="btn btn-success" href="/customer"><i style='font-size:20px' class='fas'>&#xf359;</i>Back to customer list</a>
</p>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-9">
            <form action="/customer?action=update" method="post">
                <div class="form-group">
                    <div class="form-group">
                        <label for="customer_id">Id Customer</label>
                        <input class="form-control" id="customer_id" name="customer_id" readonly value="${customer.getIdCustomer()}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group">
                        <label for="customer_code">Code</label>
                        <input type="text" class="form-control" id="customer_code" name="customer_code" value="${customer.getCustomerCode()}">
                    </div>
                    <label for="customer_name">Name</label>
                    <input type="text" class="form-control" id="customer_name" name="customer_name" value="${customer.getCustomerName()}">
                </div>
                <div class="form-group">
                    <label for="customer_birthday">Birthday</label>
                    <input type="date" class="form-control" id="customer_birthday" name="customer_birthday" value="${customer.getCustomerBirthday()}">
                </div>
                <div class="form-group">
                    <label for="customer_gender">Gender</label>
                    <select class="form-control" id="customer_gender" name="customer_gender" required>
<%--                        <option  value="${customer.getCustomerGender()}">Chọn...</option>--%>
                        <option value="true" ${customer.getCustomerGender()?"selected":''}>Nam</option>
                        <option value="false" ${!customer.getCustomerGender()?"selected":''} >Nữ</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="customer_id_card">Id Card</label>
                    <input type="text" class="form-control" id="customer_id_card" name="customer_id_card" value="${customer.getCustomerCard()}">
                </div>
                <div class="form-group">
                    <label for="customer_phone">Phone</label>
                    <input type="text" class="form-control" id="customer_phone" name="customer_phone" value="${customer.getCustomerPhone()}">
                </div>
                <div class="form-group">
                    <label for="customer_email">Email</label>
                    <input type="text" class="form-control" id="customer_email" name="customer_email" value="${customer.getCustomerEmail()}">
                </div>
                <div class="form-group">
                    <label for="customer_address">Address</label>
                    <input type="text" class="form-control" id="customer_address" name="customer_address" value="${customer.getCustomerAddress()}">
                </div>
                <div class="form-group">
                    <label for="customer_type_id">CustomerType</label>
                    <%--          <input type="text" class="form-control" id="customer_type_id" name="customer_type_id">--%>
                    <select class="form-control" id="customer_type_id" name="customer_type_id">
                        <c:forEach var="type" items="${customerTypeLists}">
                            <option ${type.customerTypeId == customer.customerTypeId ? 'selected' : ''} value="${type.customerTypeId}">${type.customerTypeName}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
