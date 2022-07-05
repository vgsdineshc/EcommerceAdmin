<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ecomm.admin.pojo.Catagery"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<%@include file="/pages/topmenu.jsp" %>
<form action = "categoryInsert" method="post">
<%List<Catagery> catageries = (ArrayList<Catagery>)session.getAttribute("catageriess"); %>
<table border="1" align="center" bgcolor = "lightgreen">
<%
String catName = new String();
String catId = new String();
if(catageries==null)
{
	
}
else
{
	if(catageries.size()>0)
	{
		catName=catageries.get(0).getCname();
		catId=String.valueOf(catageries.get(0).getCid());
	}
}
%>
<tr><td>Catagery Name : <input type="text" name="categoryname" required="required" value="<%=catName%>">
<input type="hidden" name="catId" value="<%=catId%>">
</td></tr>
</table>
<table align="center">
<tr><td><input type="submit" value="Save or Update Category"></td></tr>
</table>
</form>
</fieldset>
</body>
</html>