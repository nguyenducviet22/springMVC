<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<h1>Detail Customer</h1>
	<table>
		<tr>
			<td>Id</td>
			<td>${cus.id }</td>
		</tr>
		<tr>
			<td>Username</td>
			<td>${cus.username }</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>${cus.password }</td>
		</tr>
		<tr>
			<td>Full name</td>
			<td>${cus.fullName }</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>${cus.gender }</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${cus.address }</td>
		</tr>
		<tr>
			<td>Received address</td>
			<td>${cus.receivedAddress }</td>
		</tr>
		<tr>
			<td>Date of birth</td>
			<td>${cus.dateOfBirth }</td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td>${cus.phoneNumber }</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${cus.email }</td>
		</tr>
	</table>
	<a href="load?pid=${cus.id }">update</a>
	<a href="listCustomers">home</a>

</body>
</html>