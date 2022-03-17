<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>
	<h3>비밀번호 변경</h3>
	
	<%@ include file="/Article/header.jspf" %>
	<!-- 비밀번호 확인 영역 -->
	<form action="/member/loginPwCheck.do" method="POST">
		<input type="hidden" name="name" value="${ member.name }">
		<input type="hidden" name="loginPw" value="${ member.loginPw }">
		현재 비밀번호 : <input type="text" name="loginPwCheck">			<br />
		<input type="submit" value="확인">							<br />
	</form>
	${ certification }
	<c:choose>
		<c:when test="${empty pwCheck}">
			비밀번호를 확인합니다.
		</c:when>
		
		<c:when test="${ certification == 'PASS' }">
			<!-- 비밀번호 변경 영역 -->
			<form action="/member/loginPwChange.do" method="POST">
				<input type="hidden" name="idx" value="${ member.idx }">	<br />
				새 비밀번호 : <input type="text" name="loginPw">				<br />
				
				<input type="submit" value="변경">							<br />
			</form>
		</c:when>
		
		<c:otherwise>
			잘못된 비밀번호입니다.
		</c:otherwise>
	</c:choose>
	
</body>
</html>