$(function() {
	$("#userList").click(function() {
		fetchList("user");
	});
	$("#addressList").click(function() {
		fetchList("address");
	});
});

function addForm(type) {
	modifyDate("/" + type + "/form");
}

function editForm(type, id) {
	modifyDate("/" + type + "/edit/" + id);
}

function fetchList(type) {
	modifyDate("/" + type + "/list");
}
function refresh(type) {
	modifyDate("/" + type + "/refresh");
}
function modifyDate(url) {
	$.ajax({
		type : "GET",
		url : url,
		success : function(data) {
			$(".inner-jsp").html(data);
		}
	});
}

function deleteData(type, id) {
	toastr
			.warning(
					"<div>Are you sure you want to delete this?</div>"
							+ "<div class='btn-group pull-right'>"
							+ "<button type='button' id='confirmationYes' class='btn btn-xs btn-dangare'><i class='glyphicon glyphicon-ok'></i> Yes</button>"
							+ "<button type='button' class='btn btn-xs btn-default clear'><i class='glyphicon glyphicon-remove'></i> No</button>"
							+ "</div>", "Delete Confirmation", {
						allowHtml : true,
						closeButton : true,
						onShown : function() {
							$("#confirmationYes").click(
									function() {
										$.ajax({
											type : "GET",
											url : "/" + type + "/delete/" + id,
											success : function(data) {
												fetchList(type);
												toastr.success(data.message,
														"Delete Confirmation",
														{
															closeButton : true
														});
											}
										});
									});
						}
					});
}