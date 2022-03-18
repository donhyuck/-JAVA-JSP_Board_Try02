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
	
	<c:if test="${ pwCheck != 'PASS' }">
		<!-- 비밀번호 확인 영역 -->
		<form action="/member/loginPwCheck.do" method="POST">
			<input type="hidden" name="loginedUserName" value="${ member.name }">
			<input type="hidden" name="loginPw" value="${ member.loginPw }">
			현재 비밀번호 : <input type="text" name="loginPwCheck">			<br />
			<input type="submit" value="확인">							<br />
		</form>
		본인 확인을 위해 현재 비밀번호를 입력해주세요. <br />
	
	</c:if>
	
	<c:if test="${not empty pwCheck}">
		<c:choose>
			<c:when test="${ pwCheck == 'PASS' }">
				<!-- 비밀번호 변경 영역 -->
				<form action="/member/loginPwChange.do" method="POST">
					<input type="hidden" name="idx" value="${ member.idx }">	<br />
					새 비밀번호 : <input type="text" name="loginPw">				<br />
					
					<input type="submit" value="변경">							<br />
				</form>
			</c:when>
			
			<c:otherwise>
				잘못된 비밀번호입니다. <br />
			</c:otherwise>
		</c:choose>
	</c:if>

</body>
</html>