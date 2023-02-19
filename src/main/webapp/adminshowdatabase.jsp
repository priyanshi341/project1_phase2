<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Data About Flights </h1>
<sql:setDataSource var="conn" driver="com.mysql.cj.jdbc.Driver"  url="jdbc:mysql://localhost:3306/flyawayproject"
user="root" password="priyanshig341@2000" />

<sql:query var="result" dataSource="${conn }">
select * from adminadddata
</sql:query>

<table border=1 cellSpacing=0 cellpadding=10>
<tr>
<th>Id</th><th>Source</th><th>Destination</th><th>Arrival Time</th><th>Destination Time</th><th>Price</th>
</tr>
<c:forEach items="${result.rows }" var="p">
<tr>
<td><c:out value="${p.id }"></c:out></td>
<td><c:out value="${p.Source }"></c:out></td>
<td><c:out value="${p.destination }"></c:out></td>
<td><c:out value="${p.destinationtime }"></c:out></td>
<td><c:out value="${p.arrivaltime }"></c:out></td>
<td><c:out value="${p.price }"></c:out></td>
</tr>
 </c:forEach>
</table>
</body>
</html>