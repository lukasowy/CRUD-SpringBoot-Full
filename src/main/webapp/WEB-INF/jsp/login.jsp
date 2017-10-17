<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LogIn</title>
</head>

<body>
	<h1>Login</h1>
	<form action="${path}/user/login" method="post" class="form-signin">
		<p style="color: red;">${error}</p>
		<p style="color: green;">${message}</p>
		<p>
			User Name: <input type="text" name="username"
				placeholder="Enter User Name" />
		</p>
		<p>
			Password: <input type="password" name="password"
				placeholder="Enter Password" />
		</p>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<p>
			<button type="submit">Login</button>
		</p>
	</form>
</body>
</html>