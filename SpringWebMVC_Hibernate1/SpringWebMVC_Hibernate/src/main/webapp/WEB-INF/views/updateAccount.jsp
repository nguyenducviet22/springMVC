<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update title here</title>
</head>
<body>
	<form:form action="updateAccount" method="post" modelAttribute="c">
		<table border="1">
			<tr>
				<td>User name : </td>
				<td><form:input path="username" readonly="true"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" type="password"/></td>
			</tr>
			<tr>
				<td>Role ID</td>
				<td><form:input path="roleid" type="number"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" type="email"/></td>
			</tr>
			<tr>
				<td>Telephone</td>
				<td><form:input path="phone" type="tel"/></td>
			</tr>
			<tr>
				<td>Birthday</td>
				<td><form:input path="birthday" type="date"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Update"/>
					<input type="reset" value="Clear"/>
				</td>
			</tr>
	</table>
	</form:form>
	
</body>
</html>