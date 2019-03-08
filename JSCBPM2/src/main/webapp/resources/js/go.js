function memberInputPage() {
	location.href = "member.register";
}

function logout() {
	if(confirm("로그아웃 하시겠습니까?")) {
		location.href = "member.logout";
	}
}

function deleteMemberId() {
	if(confirm("회원탈퇴 하시겠습니까?")) {
		location.href = "member.delete";
	}
}

function deleteMemo() {
	var title = document.getElementById("memoResultTitle").getAttribute("title");
	if(confirm("삭제하시겠습니까?")) {
		location.href = "textmemo.delete?tm_title="+title;
	}
}

function deleteReply() {
	var title2 = document.getElementById("replyDeleteBtn").getAttribute("title");
	if(confirm("댓글 삭제?")) {
		location.href = "reply.delete?mr_no="+title2;
	}
}