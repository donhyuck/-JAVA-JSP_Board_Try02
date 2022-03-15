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
	
	<form action="/address/searchByName" method="POST">
		<input type="text" name="name" placeholder="찾으시는 성함을 입력하세요."/>
		<input type="submit" value="검색">
	</form>
	
	<form action="/address/searchByAddr" method="POST">
		<input type="text" name="addr" placeholder="거주지를 입력하세요."/>
		<input type="submit" value="검색">
	</form>
	
	<form action="/address/searchByPhone" method="POST">
		<input type="text" name="phone" placeholder="연락처를 입력하세요."/>
		<input type="submit" value="검색">
	</form>

</body>
</html>