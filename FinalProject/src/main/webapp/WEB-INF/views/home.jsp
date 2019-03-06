<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('.bxslider').bxSlider({
			auto : true, // 자동으로 애니메이션 시작
			speed : 500, // 애니메이션 속도
			pause : 5000, // 애니메이션 유지 시간 (1000은 1초)
			mode : 'horizontal', // 슬라이드 모드 ('fade', 'horizontal', 'vertical' 이 있음)
			autoControls : false, // 시작 및 중지버튼 보여짐
			pager : true, // 페이지 표시 보여짐
			captions : true, // 이미지 위에 텍스트를 넣을 수 있음
		});
	});
</script>
</head>
<body>
	<div class="homeContentsArea">
		<div class="imageSlide">
			<ul class="bxslider">
				<li><img src="resources/img/Italy.jpg" title="콜로세움"></li>
				<li><img src="resources/img/London.jpeg" title="런던아이"></li>
				<li><img src="resources/img/paris.jpg" title="에펠탑"></li>
			</ul>
		</div>
	</div>
	<h3 class="introduceTitle">사이트 소개</h3>
	<div class="mainVideoArea">
		<iframe class="mainVideo" height="250px" src="https://www.youtube.com/embed/FN5NTyHq9GQ" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	</div>
</body>
</html>