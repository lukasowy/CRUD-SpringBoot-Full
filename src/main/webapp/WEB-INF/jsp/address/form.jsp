<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong><span class="glyphicon glyphicon-plus-sign"></span>
			New User</strong>
	</div>
	<form:form method="post" class="form-horizontal"
		action="${path}/address/add" commandName="addressForm">
		<form:hidden path="id" />
		<div class="panel-body">
			<div class="form-group">
				<label class="col-md-2 control-label">Country:</label>
				<div class="col-md-4">
					<form:input class="form-control" path="country"
						placeholder="Enter Country" required="true" />
				</div>
				<label class="col-md-2 control-label">State:</label>
				<div class="col-md-4">
					<form:input class="form-control" path="state"
						placeholder="Enter State" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">City:</label>
				<div class="col-md-4">
					<form:input class="form-control" path="city"
						placeholder="Enter City" required="true" />
				</div>
				<label class="col-md-2 control-label">User:</label>
				<div class="col-md-4">
					<form:select class="form-control" path="user.id">
						<c:forEach items="${users}" var="user">
							<form:option value="${user.id}">${user.userName}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<form:button class="btn btn-xs btn-default" type="submit"
				value="Save">
				<span class="glyphicon glyphicon-floppy-disk"></span> Save
			</form:button>
		</div>
	</form:form>
</div>