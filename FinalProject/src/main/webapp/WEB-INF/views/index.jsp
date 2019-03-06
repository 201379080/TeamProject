<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>요기 갈까You?</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/searchMenu.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/inputCheck.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".tabSlideManu").hide();
		$("#imgStyle").click(function() {
			$(".tabSlideManu").animate({
				width : 'toggle'
			});
		});

		$("#tabManuImg").click(function() {
			$(".tabSlideManu").animate({
				width : 'toggle'
			});
		});		
	});
</script>
</head>
<body>
	<div class='wrapper'>
		<div class='header'>
			<div class='titleArea'>
				<table class="webTitleArea">
					<tr>
						<td id="webTitleTd"><a href="index.do"
							style="text-decoration: none; color: #FFFFFF">요기 갈까You?</a></td>
						<td id="imgIconTd"><img id="imgStyle"
							src="resources/img/menuIcon.png"></td>
					</tr>
				</table>
				<div class="tabSlideManu">
					<span> <img id="tabManuImg" src="resources/img/close.png">
					</span>
					<div class="tabSubManu" onclick="search();">검색</div>
					<div class="tabSubManu">메뉴2</div>
					<div class="tabSubManu">메뉴3</div>
					<div class="tabSubManu">메뉴4</div>
				</div>
			</div>
		</div>
		<div class='contentBody'>
			<jsp:include page="${contentPage }"></jsp:include>
		</div>
		<div class='footer'>
			<table class="manuTable">
				<tr>
					<td align="center" style="cursor: pointer; color: #FFFFFF;"
						onclick="search();">검색</td>
					<td align="center" style="cursor: pointer; color: #FFFFFF;">메뉴2</td>
					<td align="center" style="cursor: pointer; color: #FFFFFF;">메뉴3</td>
					<td align="center" style="cursor: pointer; color: #FFFFFF;">메뉴4</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>