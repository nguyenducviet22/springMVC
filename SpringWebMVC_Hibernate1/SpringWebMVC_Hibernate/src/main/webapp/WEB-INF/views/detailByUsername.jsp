<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail title here</title>
</head>
<body>
		<table border="1">
			<tr>
				<td>User name : </td>
				<td>${c.username}</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>${c.password}</td>
			</tr>
			<tr>
				<td>Role ID</td>
				<td>${c.roleid}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${c.email}</td>
			</tr>
			<tr>
				<td>Telephone</td>
				<td>${c.phone}</td>
			</tr>
			<tr>
				<td>Birthday</td>
				<td><fmt:formatDate value="${c.birthday}" pattern="dd/MM/yyyy"/></td>
			</tr>
	</table>
	
</body>
</html>