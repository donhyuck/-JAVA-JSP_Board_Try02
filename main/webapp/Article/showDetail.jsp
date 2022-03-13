<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
</head>
<body>
	<h3>게시글 상세</h3>
	<hr />
	<%@ include file="header.jspf" %>
	
	<a href="/article/showList">목록으로 이동</a>
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
	<hr />
		
	<h3>댓글</h3>
	<h5>
	<form action="/article/replyWrite" method="POST">
		${ loginedUserName }	<br />
		<input type="text" name="body" placeholder="여기에 댓글을 작성하세요."/> <br />
		<input type="hidden" name="articleIdx" value="article.idx">
		<input type="hidden" name="name" value="${ loginedUserName }">
		<input type="submit" value="댓글 남기기">
	</form>
	</h5>

</body>
</html>