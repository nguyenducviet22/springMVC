<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<img alt="Image" src="<c:url value="resources"/>/images/${stu.image}" />
			</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${stu.name }</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>${stu.gender }</td>
		</tr>
		<tr>
			<td>Birthdate</td>
			<td>${stu.birthdate }</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${stu.address }</td>
		</tr>
	</table>
	<a href="initStudent">Insert</a>
</body>
</html>