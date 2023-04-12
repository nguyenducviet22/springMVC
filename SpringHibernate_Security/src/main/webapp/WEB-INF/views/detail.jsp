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
	</table>
	<a href="load?pid=${cus.id }">update</a>
	<a href="listCustomers">home</a>

</body>
</html>