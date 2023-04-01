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
	<h1>Insert Student</h1>
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
				<td>Gender <br> <form:errors path="gender"
						cssClass="colorError" /></td>
				<td><form:select path="gender">
						<form:option value=""></form:option>
						<form:option value="Male">Male</form:option>
						<form:option value="Female">Female</form:option>
						<form:option value="Other">Other</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:textarea path="address" /></td>
			</tr>
			<tr>
				<td>Received address</td>
				<td><form:textarea path="receivedAddress" /></td>
			</tr>
			<tr>
				<td>Date of birth</td>
				<td><form:input path="dateOfBirth" type="date" /></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><form:input path="phoneNumber" type="tel"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" type="email"/></td>
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