<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$("#searchInput").keyup(function(e){
			var keyword = $("#searchInput").val();
			$.ajax({
				url : "search.get",
				data : {ge_title : keyword},
				success : function(data) {
					$(".searchResultTable").empty();
					$(data).find("searchs").each(function(i, search){
						
						var ge_title = $(search).find("ge_title").text();
						var ge_start_date = $(search).find("ge_start_date").text();
						var ge_end_date = $(search).find("ge_end_date").text();
						var ge_addr = $(search).find("ge_addr").text();
						var ge_image = $(search).find("ge_image").text();
						var ge_image2 = $("<img>").attr("src", ge_image).css("width", "300px");
						var td1 = $("<td></td>").append(ge_image2).css('max-width','100%');
						var td2 = $("<td></td>").text(ge_title);
						var td3 = $("<td></td>").text(ge_start_date);
						var td4 = $("<td></td>").text(ge_end_date);
						var td5 = $("<td></td>").text(ge_addr);
						
						var tr1 = $("<tr></tr>").append(td1);
						var tr2 = $("<tr></tr>").append(td2);
						var tr3 = $("<tr></tr>").append(td3);
						var tr4 = $("<tr></tr>").append(td4);
						var tr5 = $("<tr></tr>").append(td5);
						
						$(".searchResultTable").prepend(tr1, tr2, tr3, tr4, tr5);
					});
					var win = $(window).width();
					$(".searchResultTable").css("width", win + "px");
				}
			});
		});
	});
</script>
</head>
<body>
	<div class='searchBar'>
		<table class="searchTableArea">
			<tr>
				<td align="center"><input id="searchInput" name="ge_title"
					placeholder="내용 입력" autocomplete="off"></td>
				<td align="center">
					<button id="searchBtn">
						<img src="resources/img/search.png" id="searchIcon" width="40px"
							height="40px">
					</button>
				</td>
			</tr>
		</table>
	</div>
	<div class="searchResultArea">
		<table class="searchResultTable"></table>
	</div>
</body>
</html>