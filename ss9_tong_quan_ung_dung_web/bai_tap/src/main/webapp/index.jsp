<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/11/2022
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<body>
<form method="post" action="/calculate">
  <div class="product">
    <h2>Product Information</h2>
    <label><b>Product Description:</b></label><br/>
    <input type="text" name="description" size="60"  placeholder="Product Description"/><br/>
    <label><b>List Price:</b></label><br/>
    <input type="text" name="list" size="60" placeholder="List Price"/><br/>
    <label><b>Discount Percent(%):</b></label><br/>
    <input type="text" name="discount" size="60" placeholder="Discount Percent"/><br/>
    <input type="submit" value="Calculate Discount"/>
  </div>
</form>
</body>
</html>
