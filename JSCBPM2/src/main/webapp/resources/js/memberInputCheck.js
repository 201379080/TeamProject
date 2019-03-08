function connectIdCheckEvent(){
	$("#jm_id").keyup(function(){
		var id = $(this).val();
		$.ajax({
			url : "member.id.check",
			data : {jm_id : id},		// {파라메터명:값, 파라메터명:값, ...}
			success : function(data){
				if(id.length == 0) {
					$("#joinCheck_id").text("ID입력");
					$("#joinCheck_id").css("color", "green")
				} else if($(data).find("member").length == 1) {
					$("#joinCheck_id").text("ID중복");
					$("#joinCheck_id").css("color", "red")
				} else {
					$("#joinCheck_id").text("OK");
					$("#joinCheck_id").css("color", "blue")
				}
			}
		});
	});
}

function memberInputCheck() {
	var jm_id = document.memberFm.jm_id;
	var jm_pw = document.memberFm.jm_pw;
	var jm_pwCheck = document.memberFm.jm_pwCheck;
	var jm_name = document.memberFm.jm_name;
	var jm_addressNumber = document.memberFm.jm_addressNumber;
	var jm_address = document.memberFm.jm_address;
	var jm_subAddress = document.memberFm.jm_subAddress;
	
	if(isEmpty(jm_id) || lessThan(jm_id, 4) || containsHS(jm_id) || $("#joinCheck_id").text() == "ID중복") {
		alert("필수입력!");
		jm_id.value="";
		jm_id.focus();
		return false;
	} else if(isEmpty(jm_pw) || lessThan(jm_pw, 5) || notContains(jm_pw, "1234567890") || notContains(jm_pw, "!@#$%^&*()")) {
		alert("필수입력!");
		jm_pw.value="";
		jm_pw.focus();
		return false;
	} else if(isEmpty(jm_pwCheck) || lessThan(jm_pwCheck, 5) || notEquals(jm_pw, jm_pwCheck)) {
		alert("필수입력!");
		jm_pwCheck.value="";
		jm_pwCheck.focus();
		return false;
	} else if(isEmpty(jm_name) || lessThan(jm_name, 2)) {
		alert("필수입력!");
		jm_name.value="";
		jm_name.focus();
		return false;
	} else if(isEmpty(jm_addressNumber) || isNotNumber(jm_addressNumber)) {
		alert("필수입력!");
		jm_addressNumber.value="";
		jm_addressNumber.focus();
		return false;
	} else if(isEmpty(jm_address) || lessThan(jm_address, 7)) {
		alert("필수입력!");
		jm_address.value="";
		jm_address.focus();
		return false;
	} else if(isEmpty(jm_subAddress) || lessThan(jm_subAddress, 8)) {
		alert("필수입력!");
		jm_subAddress.value="";
		jm_subAddress.focus();
		return false;
	}
	return true;
	
}

function loginInputCheck() {
	var jm_id = document.loginFm.jm_id;
	var jm_pw = document.loginFm.jm_pw;
	
	if(isEmpty(jm_id) || lessThan(jm_id, 4) || containsHS(jm_id)) {
		alert("필수입력!");
		jm_id.value="";
		jm_id.focus();
		return false;
	} else if(isEmpty(jm_pw) || lessThan(jm_pw, 5) || notContains(jm_pw, "1234567890") || notContains(jm_pw, "!@#$%^&*()")) {
		alert("필수입력!");
		jm_pw.value="";
		jm_pw.focus();
		return false;
	}
	return true;
	
}