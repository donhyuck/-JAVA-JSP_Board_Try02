<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 수정 페이지</title>
</head>
<body>
	<h3>주소록 수정</h3>
	
	<%@ include file="addrHeader.jspf" %>
	
	<form action="/address/modify"  method="POST">
		<input type="hidden" name="idx" value="${ address.idx }"/>
		주소지 변경 : <input type="text" name="addr" value="${ address.addr }"/>	<br />
		연락처 변경 : <input type="text" name="phone" value="${ address.phone }"/>		<br />
		<input type="submit" value="수정"/>
	</form>
	

</body>
</html>