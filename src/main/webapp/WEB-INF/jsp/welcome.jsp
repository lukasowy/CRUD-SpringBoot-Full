<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD Spring Boot Full</title>
</head>

<body>
	<h1>${message}</h1>
	<p>
		<a href="${path}/user/list">User List</a>
	</p>
	<p>
		<a href="${path}/address/list">Address List</a>
	</p>
</body>
</html>