<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Views title here</title>
<link rel="stylesheet" href='<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>'/>
</head>
<body>
	<c:if test="${not empty success}"><h3 style="color: green;">${success}</h3></c:if>
	<c:if test="${not empty err}"><h3 style="color: red;">${err}</h3></c:if>
	<form action="searchByName">
		Account Name : <input type="search" name="username"/><input type="submit" value="Search"/>
	</form>
	<hr/>
	<h3>${total}</h3>
	<hr/>
	<table border="1">
		<tr>
			<th>User name</th>
			<th>Password</th>
			<th>Role ID</th>
			<th>Email</th>
			<th>Telephone</th>
			<th>Birthday</th>
			<th>Details</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="c">
			<tr>
				<td>${c.username}</td>
				<td>${c.password}</td>
				<td>${c.roleid}</td>
				<td>${c.email}</td>
				<td>${c.phone}</td>
				<td><fmt:formatDate value="${c.birthday}" pattern="dd/MM/yyyy"/></td>
				<td><a href="detailAccount?username=${c.username}">Detail</a></td>
				<td><a href="preUpdateAccount?username=${c.username}">Update</a></td>
				<td><a href="deleteAccount?username=${c.username}" onclick="return confirm('Bạn có chắc chắn muốn xoá ?')">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<ul class="pagination">
			<c:forEach begin="1" end="${endPage}" var="i">
				<li class="page-item">
					<a class="page-link" href="listCustomer?page=${i}">${i}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
		
	<a href="initInsertAccount">Add new Account</a>
</body>
</html>