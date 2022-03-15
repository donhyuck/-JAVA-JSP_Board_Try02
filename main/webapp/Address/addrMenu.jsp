<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 메뉴</title>
</head>
<body>
	<h3>주소록 메뉴</h3>
	
	<%@ include file="addrHeader.jspf" %>
	
	1. <a href="/address/showAddrList">주소록 전체목록</a>		<br />
	2. <a href="/address/showSearchForm">원하는 주소록 검색</a>	<br />
	3. <a href="/address/showAddForm">주소록 등록</a>			<br />
	4. <a href="#">주소록 수정</a>			<br />
	5. <a href="#">주소록 삭제</a>			<br />
	
</body>
</html>