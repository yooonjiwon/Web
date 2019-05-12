﻿<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="kr">
	<head>
		<title>Home</title>
		<meta charset="utf-8">
		<meta name="format-detection" content="telephone=no" />
		<link rel="icon" href="images/favicon.ico" />
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="/dieat/resources/styles/main.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/countdown.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/style_common.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/style4.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/camera.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/style.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/mypage.css" />
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
		<script src="/dieat/resources/js/jquery.js"></script>
		<script src="/dieat/resources/js/jquery-migrate-1.2.1.js"></script>
		<script src="/dieat/resources/js/script.js"></script>
		<script src="/dieat/resources/js/superfish.js"></script>
		<script src="/dieat/resources/js/jquery.ui.totop.js"></script>
		<script src="/dieat/resources/js/jquery.equalheights.js"></script>
		<script src="/dieat/resources/js/jquery.mobilemenu.js"></script>
		<script src="/dieat/resources/js/camera.js"></script>
		<!--[if (gt IE 9)|!(IE)]><!-->
		<script src="/dieat/resources/js/jquery.mobile.customized.min.js"></script>
		<!--<![endif]-->
			<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript">
	$(function() {
		$('#loginconfirmbtn').on('click', function(event) {
			
			
			$('form#loginconfirmform').submit();
			event.preventDefault();// <a>의 기본 기능 수행 막는 명령
			}
		);
	});
	</script>

	</head>
	<body class="page1" id="top">
		<div class="main" style="text-align:center">
	
	<jsp:include page="/WEB-INF/views/include/header.jsp" flush="true">
    <jsp:param name="bg-color" value="palegreen" />
    </jsp:include>
<!--==============================Content=================================-->
					
				
			
    <div id="contentWrapper">
        <div id="contentWrap">
            
            <div id="content">
				<div id="reconfirmPasswd" class="mypage SMP-table">
					<div class="reconfirm SMP-container">
						<h2 class="reconfirm-tit">비밀번호 <span class="fc_red">재확인</span></h2>
						<p class="txt">저희 쇼핑몰에서는 회원님의 소중한 개인정보를 안전하게 보호하고<br />개인정보 도용으로 인한 피해를 예방하기 위하여 비밀번호를 확인합니다.<br />비밀번호는 타인에게 노출되지 않도록 주의해주세요.</p><br>
						<form id="loginconfirmform" action="loginconfirmform.action" method="post">
<input type="hidden" name="page_mode" value="PC">
<input type="hidden" name="id" value="${ loginuser.id }" id="id">
<input type="hidden" name="msecure_key"     value="">
<input type="hidden" name="formname"        value="form_pw" />
<input type="hidden" name="ssl"             value="Y" />
<input type="hidden" name="ssl2"            value="" />
<input type="hidden" name="sslid"           value="pp0523535">
<input type="hidden" name="sslip"           value="www.realcoco.com">
<input type="hidden" name="sendfunc"        value="">							
  
								<fieldset>
								<legend></legend>
								
								<div class="frm">
									<ul>
										<li>
										
											<span class="lab">아이디</span>
											<strong>${ loginuser.id }</strong>
										</li><br>
										<li>
											<span class="lab">비밀번호</span>
											<label><input type="password" id="passwd" name="passwd" class="txt-input" onkeyup="javascript:check_key(event);"></label>
										</li>
									</ul>
								</div><!-- .frm -->
								<div class="btns">
									<a href="#" id="loginconfirmbtn" class="loginconfirmbtn" alt="확인" title="확인"><span class="confirm-pwd">확인</span></a>
									<a href="/dieat/home.action" alt="취소" title="취소"><span class="reject-pwd">취소</span></a>
								</div><!-- .btns -->
							</fieldset><br><br> 
						</form>					</div><!-- .reconfirm -->
				</div><!-- #reconfirmPasswd -->
			</div><!-- #content -->
        </div><!-- #contentWrap -->
    </div><!-- #contentWrapper-->
</div>					
					
					
		
<br><br><br>
<!--==============================Content=================================-->
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="true">
        <jsp:param name="bg-color" value="palegreen" />
        </jsp:include>
		<!-- end of footer -->
	</body>
</html>

