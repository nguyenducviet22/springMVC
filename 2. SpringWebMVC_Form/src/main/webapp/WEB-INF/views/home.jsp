<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>Name</td>
			<td>${pro.name }</td>
		</tr>
		<tr>
			<td>Amount</td>
			<td>${pro.amount }</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>${pro.price }</td>
		</tr>
		<tr>
			<td>Description</td>
			<td>${pro.description }</td>
		</tr>
	</table>
	<a href="initInsert">Insert</a>
</body>
</html>