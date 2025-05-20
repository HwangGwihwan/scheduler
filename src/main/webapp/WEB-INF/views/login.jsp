<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function() {
		$('#btn').click(function() {
			if ($('#id').val().length < 1) {
				alert('아이디를 입력하세요');
				return;
			}
			
			if ($('#pw').val().length < 1) {
				alert('비밀번호를 입력하세요');
				return;
			}
			
			$('#loginForm').submit();
		});
	});
</script>
</head>
<body>
	<h1>로그인</h1>
	<form id="loginForm" action="/login" method="post">
		<div>ID: </div>
		<div>
			<input type="text" id="id" name="id">
		</div>
		<div>PW: </div>
		<div>
			<input type="password" id="pw" name="pw">
		</div>
		<div><button type="button" id="btn">로그인</button></div>
	</form>
	
</body>
</html>