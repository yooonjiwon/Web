<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String idok = (String) request.getParameter("idok");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="/dieat/resources/styles/style2.css">
<link href='http://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
</head>

<script type="text/javascript">
	/******************** 정규표현식 *********************/

	function setValidId(validId) {
		$('input#memberId').val(validId);
	}

	$(function() {

		$('button#idcheck').on('click', function(event) {
			event.preventDefault();

			var id = $('input#id').val();
			var url = "/dieat/account/idcheck.action?id=" + id;
			window.open(url, "get", "height = 180px, width: 300px");
			window.close();
			return false;
		});

		$('button#signup').on('click', function(event) {
			event.preventDefault();

			var id = $('input#id').val();
			var idExpr = /^[A-Za-z0-9_-]{4,12}$/; // 정규표현식 -> /표현식/
			var result = idExpr.test(id);
			if (!result) {
				alert('아이디는 4~12의 영어 소문자, 숫자, _가능');
				$('input#id').focus();
				return;
			}

			var passwd = $('input#passwd').val();
			var pwdExpr = /^[a-zA-Z0-9]{8,20}$/; // 정규표현식 -> /표현식/
			result = pwdExpr.test(passwd);
			if (!result) {
				alert('비밀번호는 8~20의 영문자 숫자 조합');
				$('input#passwd').focus();
				return;
			}

			/* 			var confirm = $('input#confirm').val();
			 if (passwd != confirm) {
			 alert("패스워드가 일치하지 않습니다.");
			 passwd = "";
			 confirm = "";
			 return;
			 } */

			var name = $('input#name').val();
			if (name == "") {
				alert("이름을 입력하세요.");
				$('input#name').focus();
				return;
			}

			var phone = $('input#phone').val();
			if (phone == "") {
				alert("연락처를 입력하세요.");
				$('input#phone').focus();
				return;
			}

			var birth = $('input#birth').val();
			if (birth == "") {
				alert("생년월일을 입력하세요.");
				$('input#birth').focus();
				return;
			}

			if (!$(':input:radio[name=gender]:checked').val()) {
				alert("성별을 선택하세요.");
				return;
			}

			var email = $('input#email').val();
			var emailExpr = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			result = emailExpr.test(email);
			if (!result) {
				alert('이메일 형식 오류');
				$('#email').focus();
				return;
			}

			$('form#registerform').submit();
		});
	});
</script>


<body>

	<div class="header">
		<a href="/dieat/home.action">
			<div>
				Di<span>Eat</span>
			</div>
		</a> <br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br> <br>
		<br>
		<br>
		<br>
	</div>

	<form id="registerform" action="register.action" method="post">


		<h2>회원가입</h2>


		<fieldset>
			<legend>
				<span class="number">기본정보</span>
			</legend>

			<label for="id">아이디(ID):</label>
			<div class="tooltip">
				<input type="text" id="id" name="id" style="width: 210px"> <span
					class="tooltiptext">4~12의 영어 소문자, 숫자, _가능</span>
			</div>

			<button id="idcheck" type="submit"
				style="width: 100px; height: 30px; font-size: 11px; padding: 0px; background-color: #f88379; border: 0px #f88379">아이디
				중복검사</button>


			<label for="passwd">비밀번호(Password):</label>
			<div class="tooltip">
				<input type="password" id="passwd" name="passwd"> <span
					class="tooltiptext">비밀번호는 8~20의 영문자 숫자 조합</span>
			</div>

			<label for="name">이름(Name):</label>
			<div class="tooltip">
				<input type="text" id="name" name="name"> <span
					class="tooltiptext">ex)John Snow / 윤지원</span>
			</div>

			<label for="email">이메일(Email):</label>
			<div class="tooltip">
				<input type="email" id="email" name="email"> <span
					class="tooltiptext">ex)abc@gmail.com</span>
			</div>

			<label for="birthday">생년월일(Birthday):</label> <input type="date"
				id="birth" name="birth"> <label for="phone">연락처(phone):</label>
			<input type="text" id="phone" name="phone"> <label
				for="phone">주소1</label> <input type="text" id="addr1" name="addr1">

			<label for="phone">주소2</label> <input type="text" id="addr2"
				name="addr2"> <label>성별(Gender):</label> <input type="radio"
				id="male" value="male" name="gender"><label for="male"
				class="light">Male</label><br> <input type="radio" id="female"
				value="female" name="gender"><label for="female"
				class="light">Female</label><br>
			<br>


		</fieldset>

		<button id="signup">Sign Up</button>


	</form>

</body>
</html>



