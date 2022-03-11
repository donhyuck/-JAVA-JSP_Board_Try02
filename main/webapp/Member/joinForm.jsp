<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원가입</h3>
	
	<form action="/member/join.do" method="POST">
		아이디 : <input type="text" name="loginId">	<br />
		비밀번호 : <input type="text" name="loginPw">	<br />
		이름 : <input type="text" name="name">		<br />
		
		<input type="submit" value="가입">
	</form>

</body>
</html>