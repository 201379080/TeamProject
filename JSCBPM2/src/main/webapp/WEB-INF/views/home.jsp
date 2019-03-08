<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="textmemo.write" name="textMemoFm" onsubmit="return textmemoInputCheck();">
		<table class="textmemoTable">
			<tr>
				<td align="center">
					<img src="resources/img/icon.jpg" id="memoIcon" style="cursor: pointer;">
				</td>
			</tr>
			<tr>
				<td align="center" class="memoTitleArea">
					<span class="memoTitleSpan">메모</span>
				</td>
			</tr>
			<tr>
				<td align="center" class="memoTitleArea">
					<input id="titleInput" name="tm_title" maxlength="50" placeholder="제목 " autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center" class="memoTitleArea">
					<textarea id="titleAreaInput" name="tm_content" maxlength="200" placeholder="내용 입력"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center" class="memoTitleArea">
					<button id="memoRegBtn">등록</button>
				</td>
			</tr>
		</table>
	</form>
	<c:forEach var="memo" items="${memo }">
		<form action="reply.write" name="memoReplyFm" onsubmit="return memoReplyInputCehck();">
			<table border="1" class="memoResultTable">
				<tr>
					<td colspan="3" id="memoResultIdName">${memo.tm_id }(${memo.tm_name })</td>
				</tr>
				<tr>
					<td colspan="3" align="center" id="memoResultTitle" onclick="deleteMemo()" title="${memo.tm_title }">${memo.tm_title }</td>
				</tr>
				<tr>
					<td colspan="3" id="memoResultDate" align="right">
						<fmt:formatDate type="both" value="${memo.tm_date }" dateStyle="long" timeStyle="short"/>
					</td>
				</tr>
				<tr>
					<td colspan="3" id="memoResultContentArea" align="center">${memo.tm_content }</td>
				</tr>
				<c:forEach var="rp" items="${rps }">
				<c:choose>
				<c:when test="${memo.tm_no == rp.mr_tm_no}">
					<tr>
						<td id="replyResultTd">${rp.mr_owner }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${rp.mr_txt }</td>
						<td id="replyResultTd">
							<fmt:formatDate type="both" value="${rp.mr_date }" dateStyle="short" timeStyle="short"/>
						</td>
						<td id="replyDeleteBtn" onclick="deleteReply()" title="${rp.mr_no }">삭제</td>
					</tr>
				</c:when>
				</c:choose>
				</c:forEach>
				<tr>
					<td id="replyInputArea">${sessionScope.loginMember.jm_id }&nbsp;<input id="replyInput" name="mr_txt" autocomplete="off"><input type="hidden" name="mr_tm_no" value="${memo.tm_no }" autocomplete="off"></td>
					<td colspan="2" id="replyInputArea" align="center">
						<button id="replyBtn">쓰기</button><br>${r }
					</td>
				</tr>
			</table>
		</form>
	</c:forEach>
</body>
</html>