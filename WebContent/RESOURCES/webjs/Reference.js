/**
 * Javascript for Login page
 */
var userList = [];

var user1 = {"name":"Mike","password":"123"};
var user2 = {"name":"Smith","password":"234"};

userList.push(user1);
userList.push(user2);

$("#btnLogin").click(function() {
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/My_ZZJ/business/login",
//		dataType: "json",
//		headers: {'Accept':'application/json','Content-Type':'application/json'},
//		data: JSON.stringify(userList),
		data: {"name":"mike","password":"123"},
		beforeSend: function() {
			alert("Ready to send!");
		},
		success: function(data) {
			alert("hello");
			alert(data);
		},
		complete: function() {
			alert("complete");
		},
		error: function() {
			alert("error");
		}
	});
});