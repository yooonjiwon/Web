<%@ page language="java"  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<html>
<head>
<title>로그인 팝업</title>
  <meta charset="utf-8">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="/dieat/resources/styles/login-modal.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript">
 	$(function() {
		$('#loginbtn').on('click', function(event) {
			
			var id;
			id = $('#idtext').val();
			$('form#loginform').submit();
			event.preventDefault();// <a>의 기본 기능 수행 막는 명령
			}
		);
	}); 
	
	
	
	</script>
	
			
			
	<script type="text/javascript">		
	//enter키 입력시 아이디 체크장으로 이동
	function jf_form_check2() {
		if (event.keyCode == 13) {
			jf_form_check();
			return;
		}

	}

	//아이디 체크창으로 이동
	function jf_form_check() {
		if (document.mem_form.id.value == "") {
			alert('아이디를 입력하세요..');
			document.mem_form.id.focus();
			return false;
		}

		if (document.mem_form.pwd.value == "") {
			alert('패스워드는 4자 이상의 알파벳이나 숫자로 구성되어야 합니다');
			document.mem_form.pwd.focus();
			return false;
		}

		document.mem_form.action = "/servlet/wizard.servlet.contents.login.myloginMainServlet";

		document.mem_form.command.value = "pop_login";
		document.mem_form.submit();

	}
	//가입 팝업
	function jf_join() {
		var file_name = "/servlet/wizard.servlet.contents.login.myloginMainServlet";
		file_name += "?client_id=main&command=join&target=popup";
		window.open(file_name, 'user_modify', 'width=600,height=280');
	}

	function jf_findPass() {
		var file_name = "/servlet/wizard.servlet.contents.login.myloginMainServlet";
		file_name += "?client_id=main&command=find_pass";
		window.open(file_name, 'find_pass', 'width=400,height=360');
	}
	function jf_join_reload(id, pwd) {
		opener.location.href = '/servlet/wizard.servlet.contents.login.myloginMainServlet?client_id=main&command=login&id='
				+ id + '&pwd=' + pwd;
		window.close();
	}
</script>
</head>




<script language="javascript">
	document.domain = "kornu.ac.kr";
</script>
<noscript></noscript>


<body>
	<form id="loginform" action="login.action" method="post">
		<input type="hidden" name="command" value="" /> <input type=hidden
			name=client_id value="main"> <input type=hidden
			name="return_url"
			value="wizipsi.kornu.ac.kr/user/main/e_knu/e_knu01.html"> <input
			type=hidden name="work" value="">
		<table width="450" height="350" border="0" cellpadding="5"
			cellspacing="1" bgcolor="#b7b6b6" summary="로그인 테이블1">
			<tr>
				<td bgcolor="#FFFFFF"><table width="100%" border="0"
						cellpadding="10" cellspacing="1" bgcolor="#b7b6b6" height="300"
						summary="로그인 테이블2">
						<tr>
							<td bgcolor="#FFFFFF"><table width="100%" border="0"
									cellspacing="0" cellpadding="0" summary="로그인 테이블3">

									<tr>
										<td height="30"><img src="/dieat/resources/images/log_title.gif"
											width="150" height="20" style="padding-left: 10px"
											alt="로그인 제목" longdesc=""></td>
									</tr>

									<tr>
										<td align="left"><img
											src="/dieat/resources/images/log_gradline.gif" width="208" height="8"
											alt="줄 이미지" longdesc=""></td>
									</tr>
									<tr>
										<td height="80"><table width="220" style="padding-left: 10px" border="0"
												align="left" cellpadding="1" cellspacing="0"
												summary="로그인 입력 테이블">
												<tr>
													<td
														style='font-family: "Verdana", "돋움"; font-size: 12px; color: 4e4e4e; letter-spacing: -0.5px; vertical-align: -13px;'>아이디</td>
													<td><input id="idtext" name="id" size=10 maxlength=20 type="text"
														style='width: 90px; height: 20px;'></td>
													<td rowspan="2" align="right"><img
														src="/dieat/resources/images/log_btn_login.gif" id="loginbtn" name="loginbtn" width="55"
														height="45" onclick="javascript:jf_form_check()"
														onkeypress="if(event.keycode==13)jf_form_check();"
														alt="로그인 버튼" longdesc="" style="cursor: hand"></td>
												</tr>
												<tr>
													<td
														style='font-family: "Verdana", "돋움"; font-size: 12px; color: 4e4e4e; letter-spacing: -0.5px; vertical-align: -13px;'>패스워드</td>
													<td><input type="password" name="passwd" size=10 class=frm
														maxlength=20 onkeyup="javascript:jf_form_check2()"
														style='width: 90px; height: 20px;'></td>
												</tr>
											</table>
											<br><br><br>
											<table width="190" height="30" border="0" align="left"
												cellpadding="3" cellspacing="0" summary="로그인 버튼 테이블">
												<tr>

													<td width="54"><img
														src="/dieat/resources/images/log_btn_join.gif" width="53"
														height="20" onClick="jf_join();"
														onkeypress="if(event.keycode==13)jf_join();"
														alt="회원 가입 버튼" longdesc="" style="cursor: hand; padding-left: 15px"></td>
												
													<td width="124"><img
														src="/dieat/resources/images/log_btn_searchpass.gif" width="108"
														height="20" onClick="javascript:jf_findPass();"
														onkeypress="if(event.keycode==13)jf_findPass();"
														alt="비밀번호 검색 버튼" longdesc="" style="cursor: hand"></td>

												</tr>
											</table></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
</body>
</html>
