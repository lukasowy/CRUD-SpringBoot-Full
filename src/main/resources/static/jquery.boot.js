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
			$(".inner-jsp").html(data);
		}
	});
}

function deleteData(type, id) {
	if (confirm("Are you sure you want to delete this?")) {
		$.ajax({
			type : "GET",
			url : "/" + type + "/delete/" + id,
			success : function(data) {
				fetchList(type);
				alert(data.message);
			}
		});
	} else {
		retrun
		false;
	}
}