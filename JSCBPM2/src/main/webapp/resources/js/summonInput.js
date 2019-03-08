function connectSummonEvent() {
	var summon = false;
	$("#memoIcon").click(function(){
		if(!summon) {
			$(".textmemoTable").css("bottom", "0px");
		} else {
			$(".textmemoTable").css("bottom", "-320px");
		}
		summon = !summon;
	});
	
	// 타이머
	setInterval(function(){
		//Math.random()	// 0.0 ~ 0.99999
		var x = Math.random() * 1000;
		var y = Math.random() * 1000;
		$("img").css("top", x + "px").css("left", y+"px");
	}, 500);		// 0.5초마다 함수 자동 호출
}

function connectSummonAddrInputEvent() {
	$("#textStyle1").click(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	        	$("#memberInputBox1").val(data.zonecode);
	        	$("#memberInputBox2").val(data.address);
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	        }
	    }).open();
	});
}