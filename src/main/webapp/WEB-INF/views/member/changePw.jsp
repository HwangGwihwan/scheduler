<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function() {
		$('#btn').click(function() {
			if ($('#pw').val().length < 1) {
				alert('비밀번호를 입력하세요')
				return;
			}
			
			if ($('#pw').val() != $('#password').val()) {
				alert('비밀번호가 일치하지 않습니다');
				return;
			}
			
			if ($('#changePw').val().length < 1) {
				alert('바꿀 비밀번호를 입력하세요');
				return;
			}
			
			$.ajax({
				url:'/pwCheck/' + $('#id').val() + '/' + $('#changePw').val()
				, type:'get'
				, success: function(data) {
					if (data == true) {
						alert('이 비밀번호로는 변경할 수 없습니다');
						$('#changePw').val('');
					} else {
						$('#changeForm').submit();
					}
				}
			});
			
		});
	});
</script>
</head>
<body>
	<h1>비밀번호 변경</h1>
	<input type="hidden" id="password" value="${loginMember.pw}">
	<form id="changeForm" action="/changePw" method="post">
		<input type="hidden" id="id" name="id" value="${loginMember.id}">
		<div>
			비밀번호 <input type="password" id="pw">
		</div>
		<div>
			바꿀 비밀번호 <input type="password" id="changePw" name="pw">
		</div>
		<button type="button" id="btn">비밀번호 수정</button>
	</form>
</body>
</html>