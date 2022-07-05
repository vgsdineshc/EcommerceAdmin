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
 <legend align="center">Admin Login</legend>
<form action="logindetails"  method="post">
<table border="1" bgcolor = "lightgreen" align="center">
<tr><td>Username : <input type="text" name="username" required="required"></td></tr>
<tr><td>Password : <input type="password" name="password" required="required"></td></tr>
<tr><td><input type="submit" value="Login"></td></tr>
</table>
</form>
<%if(request.getAttribute("error")!=null)
{
%>
<%=request.getAttribute("error")%>
<%} %>
</fieldset>
</body>
</html>