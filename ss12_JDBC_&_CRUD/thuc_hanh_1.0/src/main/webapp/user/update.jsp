<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/17/2022
  Time: 8:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <form method="post">
        <label>Id</label> <input name="id" readonly value="${users.getId()}" ><br>
        <label for="name_user">Name User : </label> <input type="text" name="name_user" id="name_user" value="${requestScope["users"].getName()}"> <br>
        <label for="email">Email : </label> <input type="text" name="email" id="email" value="${requestScope["users"].getEmail()}"> <br>
        <label for="country">Country : </label> <input type="text" name="country" id="country" value="${requestScope["users"].getCountry()}"> <br>
        <button type="submit">Update User</button>
    </form>
    </body>
    </html>
