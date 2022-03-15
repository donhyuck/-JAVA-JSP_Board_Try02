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

</body>
</html>