<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Form</title>
</head>
<body>
	<h1>Insert Product</h1>
	<form:form action="insert" modelAttribute="pro" method="post">
		<table>
			<tr>
				<td>Id</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><form:input path="amount" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Insert" /><input type="reset"
					value="Clear" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>