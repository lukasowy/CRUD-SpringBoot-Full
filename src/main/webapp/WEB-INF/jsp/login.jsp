<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LogIn</title>
<link rel="stylesheet"
	href="${path}/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
<style type="text/css">
body {
	background: url("https://cdn.pixabay.com/photo/2016/10/10/11/40/sunset-1728163_960_720.jpg") no-repeat center center fixed;
	background-size: cover; display : flex;
	align-items: center;
	height: 100vh;
	display: flex;
}
</style>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong>Login to your account</strong>
					</div>
					<div class="panel-body">
						<form action="${path}/user/login" method="post"
							class="form-signin form-horizontal">
							<c:if test="${error != null}">
								<div class="alert alert-danger">
									<strong>${error}</strong>
								</div>
							</c:if>
							<c:if test="${message != null}">
								<div class="alert alert-success">
									<strong>${message}</strong>
								</div>
							</c:if>
							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group input-group-md">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-user"></span>
										</span> <input class="form-control" type="text" name="username"
											placeholder="Enter User Name" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group input-group-md">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-lock"></span>
										</span> <input class="form-control" type="password" name="password"
											placeholder="Enter Password" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<div class="checkbox">

										<label><input type="checkbox" name="remember-me"
											id="remember-me" /> Remember me</label>
									</div>
								</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<div class="form-group">
								<div class="col-md-12">
									<button type="submit" class="btn btn-default btn-block">
										<span class="glyphicon glyphicon-log-in"> Login</span>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>