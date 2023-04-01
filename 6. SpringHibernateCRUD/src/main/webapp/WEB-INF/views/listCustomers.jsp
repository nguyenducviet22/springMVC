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
	<div class="container">
		<h1>List Costumers</h1>
		<form action="search">
			Customer name <input type="text" name="searchName" /><input
				type="submit" value="Search" />
		</form>
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
				<th>Detail</th>
				<th>Delete</th>
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
					<td><a href="detail?pid=${c.id }">detail</a></td>
					<td><a href="delete?pid=${c.id }"
						onclick="return confirm('Delete?')">delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="initInsert">Add new one</a>
	</div>
</body>
</html>