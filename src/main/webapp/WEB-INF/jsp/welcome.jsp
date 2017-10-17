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
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form method="post" id="logoutForm" action="${path}/logout">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<p>
			Welcome ${pageContext.request.userPrincipal.name} | <a
				onclick="document.forms['logoutForm'].submit()">Logout</a>
		</p>
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
	</c:if>
</body>
</html>