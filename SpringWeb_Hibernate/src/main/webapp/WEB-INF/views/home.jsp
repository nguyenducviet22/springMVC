<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customers</title>
</head>
<body>
	<h1>List Costumers</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Username</th>
			<th>Password</th>
			<th>Full name</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Received address</th>
			<th>Date of birth</th>
			<th>Phone number</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${list}" var="c">
			<tr>
				<td>${c.id }</td>
				<td>${c.username }</td>
				<td>${c.password }</td>
				<td>${c.fullName }</td>
				<td>${c.gender }</td>
				<td>${c.address }</td>
				<td>${c.receivedAddress }</td>
				<td>${c.dateOfBirth }</td>
				<td>${c.phoneNumber }</td>
				<td>${c.email }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>