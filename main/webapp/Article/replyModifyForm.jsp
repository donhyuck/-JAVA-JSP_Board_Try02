<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정</title>
</head>
<body>
	<h3>댓글 수정</h3>
	
	<form action="/article/replyModify" method="POST">
		<input type="hidden" name="idx" value="${ reply.idx }">
		<input type="hidden" name="articleIdx" value="${ reply.articleIdx }">
		${ loginedUserName }	<br />
		<input type="text" name="body" value="${ reply.body }">	<br />
		<input type="submit" value="수정">
	</form>

</body>
</html>