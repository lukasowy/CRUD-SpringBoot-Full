<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong> <span class="glyphicon glyphicon-info-sign"></span>
			Address List
		</strong>
	</div>
	<div class="panel-body">
		<table
			class="table table-bordered table-condensed table-hover table-striped">
			<thead>
				<tr>
					<th>Country</th>
					<th>State</th>
					<th>City</th>
					<th>User</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${addresses}" var="address">
					<tr>
						<td>${address.country}</td>
						<td>${address.state}</td>
						<td>${address.city}</td>
						<td>${address.user.userName}</td>
						<td><a href="${path}/address/edit/${address.id}"><span
								class="glyphicon glyphicon-edit"></span></a></td>
						<td><a href="${path}/address/delete/${address.id}"><span
								class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
