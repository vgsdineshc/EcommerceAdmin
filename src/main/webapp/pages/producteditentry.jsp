<%@page import="com.ecomm.admin.pojo.Product"%>
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
<form action="producteditinsert" method="post" bgcolor = "lightgreen">
<table border="1">
<%Product product = (Product)session.getAttribute("productEdit"); %>
<tr>
<td>Product Name:</td>
<td> <input type="text" name="productName" value="<%=product.getPname()%>" required="required"></td>
</tr>
<tr>
<td>Price</td>
<td> <input type="text" name="productPrice" value="<%=product.getPrice()%>" required="required"></td>
</tr>
<tr>
<td>Catagery</td>
<td><select name="catId" required="required">
<%List<Catagery> catageries = (ArrayList<Catagery>)session.getAttribute("catageries");
for(int i=0;i<catageries.size();i++)
{
%>
<%if(String.valueOf(catageries.get(i).getCid()).equals(String.valueOf(product.getCatagery().getCid())))
{%>
<option value="<%=catageries.get(i).getCid()%>" selected="selected"><%=catageries.get(i).getCname()%></option>	
<%} else {%>
<option value="<%=catageries.get(i).getCid()%>"><%=catageries.get(i).getCname()%></option>
<%}%>
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