<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h3>게시글 목록</h3>
	<hr />
	<a href="/article/showAddForm">글쓰기</a>
	<hr />
	
	<c:forEach items="${ articleList }" var="article">
		번 호 : ${ article.idx }		<br />
		<a href="/article/showDetail?idx=${ article.idx }">제 목 : ${ article.title }</a>	<br />
		작성자 : ${ article.name }	<br />
		<hr />
	</c:forEach>

</body>
</html>