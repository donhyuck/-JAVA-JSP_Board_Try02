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
	
	<b>기본정보</b>				<br />
	이름 : ${ member.name }	<br />
	회원가입일 : ${fn:substring(member.regDate, 0, 4)}년 ${fn:substring(member.regDate, 5, 7)}월 ${fn:substring(member.regDate, 8, 10)}일	 <br />
	
	<a href="#">비밀번호 변경</a>
	<hr />
	
	<b>나의 활동</b>		<br />
	<a href="#">내가 쓴 글</a> xx건				<br />
	<a href="#">내가 쓴 댓글</a> xx건			<br />
	<hr />
	
	<b><a href="#">연락처 정보</a> xx건 </b>	<br />
	
</body>
</html>