<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="member.logout" method="post">
		<table class="loginSuccessTable">
			<tr>
				<td>
					<img src="resources/img/${sessionScope.loginMember.jm_photo }" style="height: 25px; border-radius: 10px">
				</td>
				<td>
					${sessionScope.loginMember.jm_id }(${sessionScope.loginMember.jm_name })
				</td>
				<td>
					<button id="logoutBtn" onclick="logout();">로그아웃</button>
				</td>
				<td>
					<a href="member.Info" id="memberInfoBtn">회원정보</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>