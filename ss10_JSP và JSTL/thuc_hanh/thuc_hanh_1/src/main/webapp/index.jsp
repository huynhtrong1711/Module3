<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/11/2022
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Currency Converter</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<form method="post" action="converter.jsp">
  <label>Rate: </label><br/>
  <input type="text" name="rate" placeholder="RATE"/><br/>
  <label>USD: </label><br/>
  <input type="text" name="usd" placeholder="USD"/><br/>
  <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>
