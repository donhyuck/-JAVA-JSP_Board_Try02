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
	<a href="http://localhost:9100/article/showList">목록으로 이동</a>
	<hr />
	
	<div>
		번 호 : ${ article.idx }			<br /> 
		등록일 : ${ article.regDate }		<br /> 
		수정일 : ${ article.updateDate }	<br /> 
		제 목 : ${ article.title }		<br /> 
		내 용 : ${ article.body }			<br /> 
		작성자 : ${ article.name }		<br /> 
	
	</div>

</body>
</html>