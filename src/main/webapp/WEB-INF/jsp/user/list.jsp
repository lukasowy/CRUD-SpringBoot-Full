<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong><span class="glyphicon glyphicon-list"></span> User
			List</strong>
		<div class="btn-group pull-right">
			<a href="javascript:void(0);" class="btn btn-default btn-sm"
				onclick="addForm('user')" title="Add New User"><span
				class="glyphicon glyphicon-plus-sign"></span></a> <a
				href="javascript:void(0);" class="btn btn-default btn-sm"
				onclick="refresh('user')" title="Refresh User"><span
				class="glyphicon glyphicon-refresh"></span></a>
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
