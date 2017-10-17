<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address List</title>
</head>

<body>
	<table border="1">
		<thead>
			<tr>
				<th>Country</th>
				<th>State</th>
				<th>City</th>
				<th>User</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${addresses}" var="address">
				<tr>
					<td>${address.country}</td>
					<td>${address.state}</td>
					<td>${address.city}</td>
					<td>${address.user.userName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="${path}/">Home</a>
	</p>
</body>
</html>