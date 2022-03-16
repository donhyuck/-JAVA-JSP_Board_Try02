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
	
	<form action="/address/showAddrList"><input type="submit" value="주소록 전체목록"></form><br />
	<form action="/address/showSearchForm"><input type="submit" value="하는 주소록 검색"></form><br />
	<form action="/address/showAddForm"><input type="submit" value="주소록 등록"></form><br />
	<form action="/address/showMyAddrList">
		<input type="hidden" name="loginedUserName" value="${ loginedUserName }">
		<button>내 주소록 보기</button>
	</form>
	
</body>
</html>