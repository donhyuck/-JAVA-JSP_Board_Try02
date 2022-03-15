<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록된 주소록 목록</title>
</head>
<body>
	<h4>${ loginedUserName } 님의 주소록 내역입니다.</h4>
	
	<%@ include file="addrHeader.jspf" %>
	
	<c:forEach items="${ addressList }" var="address">
		<c:if test="${ loginedUserName == address.name }">
			번 호 : ${ address.idx }		<br />
			주 소 : ${ address.addr }		<br />
			연락처 : ${ address.phone }	<br />
			성 명 : ${ address.name }		<br />
			
			<form action="/address/showModifyForm" style="display:inline;">
				<input type="hidden" name="idx" value="${ address.idx }">
				<input type="submit" value="수정">
			</form>
			
			<form action="/address/delete" method="POST" style="display:inline;">
				<input type="hidden" name="idx" value="${ address.idx }">
				<input type="submit" value="삭제">
			</form>
			<!-- style="display:inline;" 해당 코드로 inline속성을 부여한다. -->
			<hr />
		</c:if>
	</c:forEach> 
	
	

</body>
</html>