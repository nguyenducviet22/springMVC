<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/css/style.css" /> " rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/js/" />"></script>
</head>
<body>
	<!-- <h1>Hello ${person.name }, and you are ${person.age } years old.</h1> -->

	<a href="<c:url value="/forward" />">Forward</a>
	<a href="<c:url value="/redirect" />">Redirect</a>

	<h1>Hello ${name }</h1>
	<img alt="image" src="<c:url value="/image/1.png" />">

	<c:if test="${fullName != null}">
		<h1>Hello ${fullName }</h1>
	</c:if>
	<c:url value="/hello-post" var="action" />
	<form:form method="post" action="${action }" modelAttribute="user">
		<form:input path="lastName" />
		<form:input path="fisrtName" />
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>