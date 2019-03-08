<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<form action="member.loginSuccess" name="loginFm" onsubmit="return loginInputCheck();" method="post">
		<table class="loginTableArea2">
			<tr>
				<td>
					<input name="jm_id" placeholder="ID" autocomplete="off" id="loginIdInput">
				</td>
				<td>
					<input name="jm_pw" type="password" placeholder="PW" id="loginPwInput">
				</td>
				<td id="autologinTd">
					<input id="autologinTd" name="jm_auto" type="checkbox">자동로그인
				</td>
				<td>
					<button id="loginBtn">로그인</button>
				</td>		
				<td>
					<span id="memberBtn" onclick="memberInputPage();">회원가입</span>
				</td>
				<td align="right">
					${r }
				</td>
			</tr>
		</table>
	</form>
</body>
</html>