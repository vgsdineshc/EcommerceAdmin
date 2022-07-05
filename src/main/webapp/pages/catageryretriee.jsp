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
<form action="addnewcatagery" method="post">
<input type="submit" value="Add New Catagery">
<%List<Catagery> catageries = (ArrayList<Catagery>)session.getAttribute("catageries"); %>
<table border="1" bgcolor = "lightblue">
<tr>
<td>Cat Id</td>
<td>Cat Name</td>
<td>Edit</td>
<td>Delete</td>
</tr>
<%
if(catageries.size()>0)
{
	int j=0;
for(int i=0; i<catageries.size();i++)
{ j++;%>
<tr>
<td><%=j%></td>
<td><%=catageries.get(i).getCname()%></td>
<td><a href="editcat?id=<%=catageries.get(i).getCid()%>"><input type="button" value="Edit"> </a></td>
<td><a href="deletecat?id=<%=catageries.get(i).getCid()%>"><input type="button" value="Delete"> </a></td>
<%}}else{%>
<p>No Records to display</p>
<%}%>
</tr>
</table>
</form>
</fieldset>
</body>
</html>