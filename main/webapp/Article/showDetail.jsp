<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
</head>
<body>
	<h3>게시글 상세</h3>
	<hr />
	<a href="/article/showList">목록으로 이동</a>
	<hr />
	
	<c:choose>
		<c:when test="${ loginedUserName == null }">
			<a href="/member/showLoginForm.do">로그인</a>
		</c:when>
		
		<c:otherwise>
			${ loginedUserName }님 환영합니다!
			<a href="/member/logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>
	<hr />
	
	<div>
		번 호 : ${ article.idx }			<br /> 
		등록일 : ${ article.regDate }		<br /> 
		수정일 : ${ article.updateDate }	<br /> 
		제 목 : ${ article.title }		<br /> 
		내 용 : ${ article.body }			<br /> 
		작성자 : ${ article.name }		<br /> 
	</div>
	<hr />
	
	<form action="/article/showModifyForm">
		<input type="hidden" name="idx" value="${ article.idx }">
		<input type="submit" value="수정">
	</form>
	
	<form action="/article/delete"  method="POST">
		<input type="hidden" name="idx" value="${ article.idx }">
		<input type="submit" value="삭제">
	</form>

</body>
</html>