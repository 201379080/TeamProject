function textmemoInputCheck() {
	var tm_title = document.textMemoFm.tm_title;
	var tm_content = document.textMemoFm.tm_content;
	
	if(isEmpty(tm_title)) {
		alert("필수입력!");
		tm_title.value="";
		tm_title.focus();
		return false;
	} else if(isEmpty(tm_content)) {
		alert("필수입력!");
		tm_content.value="";
		tm_content.focus();
		return false;
	}
	return true;
}