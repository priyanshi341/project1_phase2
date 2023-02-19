<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.math.BigDecimal" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

  BigDecimal d=new BigDecimal(request.getParameter("val"));
session.setAttribute("price",d);  
    
%>

<h3>User Details</h3>
<br>
<form action="user">
Name:<input type="text" name="name"><br><br>
Age:<input type="text" name="age"><br><br>
Date of Birth:<input type="date" name="date"><br><br>
Address:<input type="text" name="address"><br><br>
Mobile Number:<input type="text" name="mobile"><br><br>
<input type="submit" value="Next">
</form>
</body>
</html>