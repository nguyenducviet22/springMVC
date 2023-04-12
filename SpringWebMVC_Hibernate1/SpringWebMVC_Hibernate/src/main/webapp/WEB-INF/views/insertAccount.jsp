<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 style="color: red;text-align: center;">${err}</h3>
	<form:form action="insertAccount" method="post" modelAttribute="c">
		<table border="1">
			<tr>
				<td>User name : </td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" type="password"/></td>
			</tr>

				<form:input path="roleid" type="hidden" value="1"/>

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
					<input type="submit" value="Insert"/>
					<input type="reset" value="Clear"/>
				</td>
			</tr>
	</table>
	</form:form>
	
</body>
</html>