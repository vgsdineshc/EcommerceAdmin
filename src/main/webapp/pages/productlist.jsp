<%@page import="com.ecomm.admin.pojo.Product"%>
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
<form action="productentry">
<input type="submit" value="Add New Product">
<table border="1" bgcolor = "lightblue">
<tr>
<td>Sl.No</td>
<td>Product Name</td>
<td>Product Price</td>
<td>Categary Name</td>
<td>Edit</td>
<td>Delete</td></tr>
<%List<Product> products = (List<Product>)session.getAttribute("productRet");
int j = 0;
if(products.size()>0)
{
for(int i =0; i<products.size();i++)
{
j++;
%>
	<tr><td><%=j%></td>
	<td><%=products.get(i).getPname()%></td>
	<td><%=products.get(i).getPrice()%></td>
	<td><%=products.get(i).getCatagery().getCname()%></td>
	<td><a href="productEdit?proId=<%=products.get(i).getPid()%>"><input type="button" value="Edit"></a></td>
	<td><a href="productDelete?proId=<%=products.get(i).getPid()%>"><input type="button" value="Delete"></a></td>
	<%}} else { out.println("Please select add new product to provide the details");}%>
	</table>
</form>
</fieldset>
</body>
</html>