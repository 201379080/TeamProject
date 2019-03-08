function memoReplyInputCehck() {
	var mr_txt = document.memoReplyFm.mr_txt;
	
	if(isEmpty(mr_txt)) {
		alert("필수입력!");
		mr_txt.value="";
		mr_txt.focus();
		return false;
	}
	return true;
}