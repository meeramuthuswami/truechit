<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chit View Page</title>
</head>

<style>

	.error {
		color: #ff0000;
	}
</style>

<body>
	<p>Chit Details</p>
	<table>
	<tr>
	<td>Chit Id</td><td>{chit.chitId}</td></tr>
	<tr><td>Chit Name</td><td>{chit.chitName}</td></tr>
	<tr><td>Number Of Users</td><td>{chit.numberofUsers}</td></tr>
	<tr><td>Number Of Phases</td><td>{chit.numberofPhases}</td></tr>
	<tr><td>Chit Type</td><td>{chit.chitType}</td></tr>
	<tr><td>Status</td><td>{chit.status}</td></tr>
	<tr><td>Chit Amount</td><td>{chit.chitAmount}</td></tr>
	</table>
	<!--  if eligible for current bid -->
	<form:form method="POST" modelAttribute="user">
	
	<p>Participate in current bid</p>

	Max bid amount is :<!--  Retrieve max bid amount for current chit -->
	<label for="bidAmount">bid amount</label>
	<form:input path="bidAmount" id="bidAmount"/>
	</form:form>
</body>

</html>