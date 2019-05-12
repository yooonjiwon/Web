<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title>Bootstrap Modal</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="/demo/resources/style/login-modal.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#show-modal').on('click', function(event) {
		$('#login-modal').modal({
			show : true
		});
		event.preventDefault();
	});
	
	$('#login-button').on('click', function(event){
		event.preventDefault();
		
		//1. 화면 갱신 방식 (동기 방식)
		//$('#login-form').submit();
		
		//2. 비동기 방식 (jQuery, Ajax 사용)
		var param = $('#login-form').serialize()
		alert(param);
		
		$.ajax({
			url : 'url',
			method : 'post',
			data : param,
			success : function(data, status, xhr) {
				$('#login-modal').modal({
					show : false
				});
				//javascript로 화면요소 변경
			},
			error : function(xhr, status, err) {
				alert('로그인 실패');
			}
		});

	});
})
</script>
</head>
<body>

	<h3>
	<a href="#" data-toggle="modal" data-target="#login-modal">Show Modal 1</a><!-- 자동 연결 -->
	<br /><br />
	<a href="#" id="show-modal">Show Modal 2</a><!-- 수동 연결 (jQuery code 사용) -->
	</h3>

	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="display: none;">
		<div class="modal-dialog">
			<div class="loginmodal-container">
				<h1>Login to Your Account</h1>
				<br>
				<form id="login-form">
					<input type="text" name="user" placeholder="Username"> 
					<input type="password" name="pass" placeholder="Password"> 
					<input type="submit" name="login" class="login loginmodal-submit" value="Login">
					<input type="submit" name="login" class="login loginmodal-submit" value="Login" id="login-button">
				</form>

				<div class="login-help">
					<a href="#">Register</a> - <a href="#">Forgot Password</a>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
