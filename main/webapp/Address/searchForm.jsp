<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 검색</title>
</head>
<body>
	<h3>주소록 검색</h3>
	
	<%@ include file="addrHeader.jspf" %>
	
	<form action="/address/search" method="POST">
		<input type="hidden" name="infoType" value="name">
		<input type="text" name="keyword" placeholder="찾으시는 성함을 입력하세요."/>
		<input type="submit" value="검색">
	</form>
	
	<form action="/address/search" method="POST">
		<input type="hidden" name="infoType" value="addr">
		<input type="text" name="keyword" placeholder="거주지를 입력하세요."/>
		<input type="submit" value="검색">
	</form>
	
	<form action="/address/search" method="POST">
		<input type="hidden" name="infoType" value="phone">
		<input type="text" name="keyword" placeholder="연락처를 입력하세요."/>
		<input type="submit" value="검색">
	</form>
	<hr />
	
	<c:forEach items="${ addressList }" var="address">
		번 호 : ${ address.idx }		<br />
		주 소 : ${ address.addr }		<br />
		연락처 : ${ address.phone }	<br />
		성 명 : ${ address.name }		<br />
		
		<c:if test="${ loginedUserName == address.name }">
			<form action="/address/showModifyForm" style="display:inline;">
				<input type="hidden" name="idx" value="${ address.idx }">
				<input type="submit" value="수정">
			</form>
			
			<form action="/address/delete" method="POST" style="display:inline;">
				<input type="hidden" name="idx" value="${ address.idx }">
				<input type="submit" value="삭제">
			</form>
		</c:if>
		<hr />
	</c:forEach>

</body>
</html>