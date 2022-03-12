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
	<c:choose>
		<c:when test="${ logineddUserName == null }">
			<a href="/member/showLoginForm.do">로그인</a>
		</c:when>
		
		<c:otherwise>
			${ logineddUserName }님 환영합니다!
		</c:otherwise>
	</c:choose>
	<hr />
	
	<a href="/member/showJoinForm.do">회원가입</a>
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