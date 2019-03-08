<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<form action="member.joinSuccess" name="memberFm" onsubmit="return memberInputCheck();" method="post" enctype="multipart/form-data">
		<table class="memberTableArea">
		<tr>
			<td id="textStyle" align="center">id</td>
			<td>
				<input id="jm_id" placeholder="입력 필수" autocomplete="off" name="jm_id" maxlength="11">
				&nbsp;<span id="joinCheck_id" style="cursor: pointer;">ID 중복</span>
			</td>
		</tr>
		<tr>
			<td id="textStyle" align="center">pw</td>
			<td>
				<input id="memberInputBox" type="password" name="jm_pw" placeholder="영문 대소문자, 숫자 조합" autocomplete="off">
			</td>
		</tr>
		<tr>
			<td id="textStyle" align="center">pw 확인</td>
			<td>
				<input id="memberInputBox" type="password" name="jm_pwCheck" autocomplete="off">
			</td>
		</tr>
		<tr>
			<td id="textStyle" align="center">이름</td>
			<td>
				<input id="memberInputBox" name="jm_name" autocomplete="off">
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input readonly="readonly" id="memberInputBox1" name="jm_addressNumber" placeholder="우편번호" autocomplete="off">
				&nbsp;<span id="textStyle1" style="cursor: pointer;">검색</span>
			</td>
		</tr>
		<tr>
			<td id="textStyle" align="center">주소</td>
			<td>
				<input readonly="readonly" id="memberInputBox2" name="jm_address" placeholder="주소" autocomplete="off">
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input id="memberInputBox" name="jm_subAddress" placeholder="상세주소" autocomplete="off">
			</td>
		</tr>
		<tr>
			<td id="textStyle" align="center">사진</td>
			<td>
				<input type="file" name="jm_photo">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button id="memberRegBtn">가입</button>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="memberResultComent">${r }</td>
		</tr>
		</table>
	</form>
</body>
</html>