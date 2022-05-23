<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/21/2022
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View customer</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
<h1>Customer details</h1>
<p>
<a class="btn btn-success" href="/customer"><i style='font-size:20px' class='fas'>&#xf359;</i>Back to customer list</a>
</p>
<table>
    <tr>
        <td>Id: </td>
        <td>${requestScope["customerView"].getIdCustomer()}</td>
    </tr>
    <tr>
        <td>Code: </td>
        <td>${requestScope["customerView"].getCustomerCode()}</td>
    </tr>
<%--    <tr>--%>
<%--        <td>Customer Type: </td>--%>
<%--        <td>${requestScope["customerView"].getCustomerTypeId()}</td>--%>
<%--    </tr>--%>
    <tr>
        <td>Name: </td>
        <td>${requestScope["customerView"].getCustomerName()}</td>
    </tr>
    <tr>
        <td>Birthday: </td>
        <td>${requestScope["customerView"].getCustomerBirthday()}</td>
    </tr>
    <tr>
        <td>Gender: </td>
        <td>${requestScope["customerView"].getCustomerGender() ? 'Nam' : 'Nữ'}</td>
<%--        <td><select class="form-control" id="customer_gender" name="customer_gender" required>--%>
<%--            <option value="true" ${requestScope["customerView"].getCustomerGender()?"selected":''}>Nam</option>--%>
<%--            <option value="false" ${!requestScope["customerView"].getCustomerGender()?"selected":''} >Nữ</option>--%>
<%--        </select></td>--%>
    </tr>
    <tr>
        <td>Id Card: </td>
        <td>${requestScope["customerView"].getCustomerCard()}</td>
    </tr>
    <tr>
        <td>Phone: </td>
        <td>${requestScope["customerView"].getCustomerPhone()}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${requestScope["customerView"].getCustomerEmail()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["customerView"].getCustomerAddress()}</td>
    </tr>
    <tr>
        <td>Customer Type: </td>
        <td>${requestScope["customerView"].getCustomerTypeName()}</td>
<%--        <td><select class="form-control" id="customer_type_id" name="customer_type_id">--%>
<%--            <c:forEach var="type" items="${customerTypeListView}">--%>
<%--                <option value="${type.customerTypeId}">${type.customerTypeName}</option>--%>
<%--            </c:forEach>--%>
<%--        </select></td>--%>

    </tr>

</table>
</body>
</html>
