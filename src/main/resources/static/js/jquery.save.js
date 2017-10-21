$(function() {
	$("#submitUserForm").submit(function(e) {
		e.preventDefault();
		var frm = $("#submitUserForm");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
		});
		saveRequestData(frm, data, "user");
	});

	$("#submitAddressForm").submit(function(e) {
		e.preventDefault();
		var frm = $("#submitAddressForm");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
		});
		saveRequestData(frm, data, "address");
	});
});

function saveRequestData(frm, data, type) {
	$.ajax({
		contentType : "application/json; charset=utf-8",
		type : frm.attr("method"),
		url : frm.attr("action"),
		dataType : 'json',
		data : JSON.stringify(data),
		success : function(data) {
			alert(data.message);
			toastr.success(data.message, data.title, {
				closeBatton: true
			});
			fetchList(type);
		}
	});
}