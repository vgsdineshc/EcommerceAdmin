<%@page import="java.util.ArrayList"%>
<%@page import="com.ecomm.admin.pojo.Catagery"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<%@include file="/pages/topmenu.jsp" %>
<form action="productinsert" method="post">
<table border="1" bgcolor = "lightgreen">
<tr>
<td>Product Name:</td>
<td> <input type="text" name="productName" required="required"></td>
</tr>
<tr>
<td>Price</td>
<td> <input type="text" name="productPrice" required="required"></td>
</tr>
<tr>
<td>Catagery</td>
<td><select name="catId" required="required">
<%List<Catagery> catageries = (ArrayList<Catagery>)session.getAttribute("catageries");
for(int i=0;i<catageries.size();i++)
{
%>
<option value="<%=catageries.get(i).getCid()%>"><%=catageries.get(i).getCname()%></option>
<%} %>
</select>
</td>
</tr>
<tr>
<td>
<input type="submit" value="Submit">
</td>
</tr>
</table>
</form>
</fieldset>
</body>
</html>