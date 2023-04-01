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
	<form:form action="insertStudent" modelAttribute="stu" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Id <br> <form:errors path="id" cssClass="colorError" /></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>Name <br> <form:errors path="name"
						cssClass="colorError" /></td>
				<td><form:input path="name" /></td>
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
			<tr>
				<td>Birthdate <br> <form:errors path="birthdate"
						cssClass="colorError" /></td>
				<td><form:input path="birthdate" type="date" /></td>
			</tr>
			<tr>
				<td>Address <br> <form:errors path="address"
						cssClass="colorError" /></td>
				<td><form:textarea path="address" /></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><input type="file" name="imageSource" /></td>
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