<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong><span class="glyphicon glyphicon-user"></span> User
			List</strong>
	</div>
	<div class="panel-body">
		<table
			class="table table-bordered table-condensed table-hover table-striped">
			<thead>
				<tr>
					<th>User Id</th>
					<th>User Name</th>
					<th>Password</th>
					<th>Role</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.userIdd}</td>
						<td>${user.userName}</td>
						<td>${user.password}</td>
						<td>${user.role.name}</td>
						<td><a href="${path}/user/edit/${user.id}"><span
								class="glyphicon glyphicon-edit"></span></a></td>
						<td><a href="${path}/user/delete/${user.id}"><span
								class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
