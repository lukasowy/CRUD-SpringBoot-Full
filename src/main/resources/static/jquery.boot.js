$(function() {
	$("#userList").click(function() {
		fetchList("user");
	});
	$("#addressList").click(function() {
		fetchList("address");
	});
});

function fetchList(type){
	$.ajax({
		type: "GET",
		url: "/" + type + "/list",
		success: function(data){
			$(".panel-body").html(data);
		}
	});
}