<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>

<body>
	<form:form method="post" action="${path}/user/add" commandName="userForm">
		<p>
			User Id:
			<form:input path="userIdd" placeholder="Enter User Id" />
		</p>
		<p>
			User Name:
			<form:input path="userName" placeholder="Enter User Name" />
		</p>
		<p>
			Password:
			<form:password path="password" placeholder="Enter Password" />
		</p>
		<p>
			Role:
			<form:select path="role.id">
				<c:forEach items="${roles}" var="role">
					<form:option value="${role.id}">${role.name}</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:button type="submit" value="Save">
				Save
			</form:button>
			<a href="${path}/user/list">List User</a>

		</p>
	</form:form>
</body>
</html>