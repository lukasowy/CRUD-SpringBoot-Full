<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${path}/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
<title>CRUD Spring Boot Full</title>
<style>
.row {
	margin-top: 50px;
	margin-left: 0px;
	margin-right: 0px;
}

.menu {
	height: 100%;
	position: fixed;
	background-color: #f8f8f8;
}

.menu .menu-container .navbar-nav li {
	width: 100%;
	border-bottom: 1px solid #e7e7e7e;
}
</style>
</head>

<body>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form method="post" id="logoutForm" action="${path}/logout">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<div class="navbar navbar-default navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="javascript:void(0);">CRUD
						SpringBoot</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${path}"><span
								class="glyphicon glyphicon-home"></span>Home</a></li>
						<li><a href="javascript:void(0);"><span
								class="glyphicon glyphicon-info-sign"></span>About</a></li>
						<li><a href="javascript:void(0);"><span
								class="glyphicon glyphicon-phone-alt"></span>Contact</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="javascript:void(0);"
							onclick="document.forms['logoutForm'].submit()">Welcome
								${pageContext.request.userPrincipal.name} | Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="menu navbar navbar-default">
				<div class="menu-container">
					<ul class="nav navbar-nav">
						<li><a href="${path}/user/list"><span
								class="glyphicon glyphicon-user"></span> User List</a></li>
						<li><a href="${path}/address/list"><span
								class="glyphicon glyphicon-info-sign"></span> Address List</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="panel-body" style="margin-left: 210px;">
				<h1>${message}</h1>
				<c:forEach begin="0" end="3" varStatus="loop">
					<div class="col-md-12">
						<h2>${heading }</h2>
						<p>${description}</p>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="navbar navbar-default navbar-fixed-bottom">
			<div class="container">
				<div class="col-md-10 navbar-text text-center">2017. All
					Rights Reserved by lukasowy</div>
			</div>

		</div>
	</c:if>
</body>
</html>