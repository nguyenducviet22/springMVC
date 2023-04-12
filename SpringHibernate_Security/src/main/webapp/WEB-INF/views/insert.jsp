<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Form</title>
<style>
.colorError {
	color: red;
}
</style>
</head>
<body>
	<h1>Insert Customer</h1>
	<h3 style="color: red">${error}</h3>
	<form:form action="insert" modelAttribute="cus" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Username</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td>Full name</td>
				<td><form:input path="fullName" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Insert" /><input type="reset"
					value="Clear" /> <a href="listCustomers">home</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>