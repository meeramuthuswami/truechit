<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Front Page</title>
</head>
<body>
	<h2>List of Chits</h2>	
	<table>
		<tr>
			<td>NAME</td>
		</tr>
		<c:forEach items="${chits}" var="chit">
			<tr>
			<td>${chit.name}</td>
			<td>${chit.status}</td>
			<td><a href="<c:url value='/open-${chit.id}-userchit' />">view</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New User</a>
</body>

</html>