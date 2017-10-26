<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong><span class="glyphicon glyphicon-list"></span> User
			List</strong>
		<div class="pull-right">
			<a href="javascript:void(0);" onclick="addForm('user')"><span
				class="glyphicon glyphicon-plus-sign"></span> New User</a>
		</div>
	</div>
	<div class="panel-body">
		<table
			class="table table-bordered table-condensed table-hover table-striped">
			<thead>
				<tr>
					<th>User Id</th>
					<th>User Name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Role</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.userId}</td>
						<td>${user.userName}</td>
						<td>${user.email}</td>
						<td>${user.mobile}</td>
						<td>${user.role.name}</td>
						<td><a href="javascript:void(0);"
							onclick="editForm('user', '${user.id}')"><span
								class="glyphicon glyphicon-edit"></span></a></td>
						<td><a href="javascript:void(0);"
							onclick="deleteData('user', '${user.id}')"><span
								class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
