<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시글 등록</h3>
	
	<%@ include file="header.jspf" %>
	
	<form action="/article/write" method="POST">
		제 목 : <input type="text" name="title"> <br />
		내 용 : <input type="text" name="body"> <br />
		작성자 : ${ loginedUserName }
		<input type="hidden" name="name" value="${ loginedUserName }"> <br />
		<input type="submit" value="게시글 등록">
	</form>

</body>
</html>