<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/login.css">
<link rel="stylesheet" href="resources/css/memberInfo.css">
<link rel="stylesheet" href="resources/css/textmemo.css">
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/memberInputCheck.js"></script>
<script type="text/javascript" src="resources/js/textmemoInputCheck.js"></script>
<script type="text/javascript" src="resources/js/memoReplyInputCheck.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/js/summonInput.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	$(function(){
		connectSummonEvent();
		connectSummonAddrInputEvent();
		connectIdCheckEvent();
	});
</script>
</head>
<body>
	<table class="loginTableArea">
		<tr>
			<td>
				<jsp:include page="${loginPage }"></jsp:include>
			</td>
		</tr>
	</table>
	
	<table class="siteTitleArea">
		<tr>
			<td>
			<a href="home.do" style="text-decoration: none; color: #000000;">회원가입 사이트</a>
			</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td>
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>