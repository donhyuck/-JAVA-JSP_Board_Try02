<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 목록</title>
</head>
<body>
	<h3>주소록 목록</h3>
	
	<%@ include file="addrHeader.jspf" %>
	
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