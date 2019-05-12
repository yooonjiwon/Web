<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>아이디중복검사</title>

<style>
* {
	text-align: center;
}

html, body {
	width: 300px;
	height: 60px;
	margin: 0;
	padding: 0;
}

body {
	color: #000;
}


h1 {
	border-bottom: 1px solid none;
	line-height: 40px;
}

fieldset {
  max-width: 300px;
  height: 1px;
  margin: 0px auto;
  padding: 5px 30px;
  position: absolute;
  z-index: 2;
  border: none;
} 

input {
	margin: 15px 0;
	border: 1px solid #000;
	width: 60px;
	vertical-align: middle;
	height: 100px;
}

input[type="button"], input[type="submit"] {
	background-color: #7ABBDD;
	font-size: 13px;
	text-align: center;
	font-style: normal;
	border-radius: 5px;
	width: 100px;
	height: 40px;
	border: 0px solid;
	border-width: 1px 1px 1px;
	box-shadow: 0 -1px 0 rgba(255, 255, 255, 0.4) inset;
	margin-bottom: 2px;
	font-size: 12px;
	padding: 0px;
	border: 0px #7ABBDD;
}

input[type=text] {
  background: rgba(255,255,255,0.1);
  border: none;
  font-size: 10px;
  height: 10px;
  margin: 0;
  outline: 0;
  padding: 15px;
  border-radius: 3px;
  width: 180px;
  background-color: #e8eeef;
  color: #8a97a0;
  box-shadow: 0 1px 0 rgba(0,0,0,0.05) inset;
  margin-bottom: 10px;
  font-family: 나눔고딕;}

input[type=button]:hover, input[type="submit"]:hover {
	opacity: 0.8;
}

input[type=button]:active, input[type="submit"]:active {
	opacity: 0.6;
}

h1 {
	margin: 10px 0 10px 0;
	text-align: center;
	font-family: 나눔고딕;
	font-size: 15px;
}
</style>
<script src= "http://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">



	$(function() {

		if (${rst == 0}) {
			$('input#use').css('display', '')
		} else {
			$('input#use').css('display', 'none')
		}
		window.resizeTo(400,400); 
		
		$('input#use').on('click', function(event) {
			event.preventDefault();
			var validId = $('#validid').attr('data-id');
			window.opener.setValidId(validId);
			window.close();
		});
		
	});
	
</script>
</head>
<body>
	<%
		if ((int) request.getAttribute("rst") > 0) {
	%>
	<h1 style='width: 370px;'>이미 사용중인 아이디입니다.</h1>
	<%
		} else {
	%>
	<h1 style='width: 370px;'>사용 가능한 아이디입니다.</h1>
	<%
		}
	%>

	<form action="/seoul/account/idcheck.action" method="post">
		<fieldset>
			<p class="blind" style='font-weight: bold;'>아이디중복확인</p>
			<input type="text" name="memberId"
				value='<%=request.getAttribute("memberId")%>' /><br>
			
				아이디( <span id='validid' data-id='${memberId}'>${ memberId }</span>


				)를 사용하시겠습니까?
			
			<input type="submit" value="중복확인" /> 
			<input type="button" id="use" value="사용하기" />

		</fieldset>
	</form>

</body>
</html>
