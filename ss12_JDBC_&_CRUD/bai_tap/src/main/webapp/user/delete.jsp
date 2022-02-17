<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/17/2022
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting user</title>
</head>
<body>
<h1>Delete user</h1>
<p>
    <a href="/usersE">Back to user list</a>
</p>
<form method="post" action="/usersE?action=delete">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>User information</legend>
        <table>
            <input type="hidden" name="id" value="${requestScope["userDelete"].getId()}">
            <tr>
                <td>Name: </td>
                <td>${requestScope["userDelete"].getName()}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${requestScope["userDelete"].getEmail()}</td>
            </tr>
            <tr>
                <td>Country: </td>
                <td>${requestScope["userDelete"].getCountry()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete user"></td>
                <td><a href="/usersE">Back to user list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
