<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<h3>로 그 인</h3><br>
	<hr>
	<br>
	<form action="review" method = "POST">
		<input type = "hidden" name ="meta" value = "login">
		ID : <input type ="text" placeholder="아이디" name ="id">
		PW : <input type ="password" placeholder="비밀번호" name ="password">
		<button>로그인</button>
	</form>

</body>
</html>