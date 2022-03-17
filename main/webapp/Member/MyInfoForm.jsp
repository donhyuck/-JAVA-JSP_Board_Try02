<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보</title>
</head>
<body>
	<h3>개인정보</h3>
	
	<%@ include file="/Article/header.jspf" %>
	
	<div><b>기본정보</b></div>				
	이름 : ${ member.name }		<br />
	회원가입일 : ${fn:substring(member.regDate, 0, 4)}년 ${fn:substring(member.regDate, 5, 7)}월 ${fn:substring(member.regDate, 8, 10)}일	 <br />
	<br />
	<form action="/member/showLoginPwChangeForm.do">
		<input type="hidden" name="loginedUserName" value="${ loginedUserName }">
		<input type="submit" value="비밀번호 변경">
	</form>
	<hr />
	
	<div><b>나의 활동</b></div>
	<form action="/article/showMyArticleList" style="display: inline">
		<input type="hidden" name="loginedUserName" value="${ loginedUserName }">
		<input type="submit" value="내가 쓴 글">
	</form>
	
	<form action="/address/showMyAddrList" style="display: inline">
		<input type="hidden" name="loginedUserName" value="${ loginedUserName }">
		<input type="submit" value="연락처 정보">
	</form>
	
</body>
</html>