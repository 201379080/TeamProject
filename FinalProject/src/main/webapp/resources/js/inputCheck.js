function inputCheck() {
	var keyword = document.inputFormTag.search;
	
	if(isEmpty(keyword)) {
		alert("내용 입력!");
		keyword.value = "";
		keyword.focus();
		return false;
	}
	return true;
}