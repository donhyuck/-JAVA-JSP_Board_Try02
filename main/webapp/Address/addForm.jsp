<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 등록</title>
</head>
<body>
	<h3>주소록 등록</h3>
	
	<%@ include file="addrHeader.jspf" %>
	
	<form action="/address/write" method="POST">
		주 소 : <input type="text" name="addr">	<br />
		연락처 : <input type="text" name="phone">	<br />
		성 명 : ${ loginedUserName }
		<input type="hidden" name="name" value="${ loginedUserName }">	<br />
		<input type="submit" value="등록"/>
	</form>
	
</body>
</html>