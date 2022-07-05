<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1"
           bgcolor="lightgreen"> 
<tr>
<td>UserName : <b><%=session.getAttribute("username")%></b></td>
<td><a href="catagerRet">Category</a></td>
<td><a href="productView">Product</a></td>
<td><a href="logout">Logout</a></td>
</tr>
    </table>
</body>
</html>