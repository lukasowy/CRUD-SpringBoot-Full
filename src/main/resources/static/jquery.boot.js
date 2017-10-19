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

function modifyDate(url) {
	$.ajax({
		type : "GET",
		url : url,
		success : function(data) {
			$(".panel-body").html(data);
		}
	});
}