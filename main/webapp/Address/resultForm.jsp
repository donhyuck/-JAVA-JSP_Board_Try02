<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 검색</title>
</head>
<body>
	<h3>주소록 검색결과</h3>
	
	<%@ include file="addrHeader.jspf" %>
	
	<a href="/address/showSearchForm">다시 검색하기</a>
	<hr />
	
	<c:forEach items="${ addressList }" var="address">
		번 호 : ${ address.idx }		<br />
		주 소 : ${ address.addr }		<br />
		연락처 : ${ address.phone }	<br />
		성 명 : ${ address.name }		<br />
		<hr />
	</c:forEach>

</body>
</html>