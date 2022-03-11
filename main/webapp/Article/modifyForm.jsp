<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 페이지</title>
</head>
<body>
	<h3>게시물 수정</h3>
	
	<form action="/article/modify"  method="POST">
		<input type="hidden" name="idx" value="${ article.idx }"/>
		새 제목 : <input type="text" name="title" value="${ article.title }"/>	<br />
		새 내용 : <input type="text" name="body" value="${ article.body }"/>		<br />
		
		<input type="submit" value="수정"/>
	</form>
	

</body>
</html>