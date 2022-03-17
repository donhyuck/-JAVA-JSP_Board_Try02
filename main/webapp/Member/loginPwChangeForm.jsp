<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>
	<h3>비밀번호 변경</h3>
	
	<form action="/member/loginPwChange.do" method="POST">
		<input type="hidden" name="idx" value="${ member.idx }">	<br />
		아이디 : ${ member.loginId }											<br />
		새 비밀번호 : <input type="text" name="loginPw">				<br />
		
		<input type="submit" value="변경">							<br />
	</form>

</body>
</html>