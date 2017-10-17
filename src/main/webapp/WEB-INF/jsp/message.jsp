<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message</title>
</head>

<body>
	<h1>${message}</h1>
	<p>
		<a href="${path}/user/list">User List</a>
	</p>
	<p>
		<a href="${path}/user/form">Add User</a>
	</p>
	<p>
		<a href="${path}/address/list">Address List</a>
	</p>
	<p>
		<a href="${path}/address/form">Add Address</a>
	</p>
	<p>
		<a href="${path}/">Home</a>
	</p>
</body>
</html>