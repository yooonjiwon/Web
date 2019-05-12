<%@ page language="java" 
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
		<script>

		</script>

	</head>
	<body class="page1" id="top">
		<div class="main">
	
	<jsp:include page="/WEB-INF/views/include/header.jsp" flush="true">
    <jsp:param name="bg-color" value="palegreen" />
    </jsp:include>
<!--==============================Content=================================-->




	<form id="loginform" action="login.action" method="post">


		<div id="contentWrapper">
			<div id="contentWrap">

				<div id="content">
					<div id="loginWrap">
						<div class="SMP-container">

							<div class="page-body Login_Bg">
								
								<div class="login_form_wrap">
									<h2 class="tit_logo">
										<img src="/dieat/resources/images/login_title.png">
									</h2>
									<!-- 로그인정보 입력 Form -->
									<div class="mlog-sign">
										<div class="mlog">
											<form action="/shop/member.html" method="post" name="form1"
												autocomplete="off">
												<input type="hidden" name="type" value="login" /> <input
													type="hidden" name="code" value="" /> <input type="hidden"
													name="mcode" value="" /> <input type="hidden" name="scode"
													value="" /> <input type="hidden" name="xtype" value="" />
												<input type="hidden" name="startdate" value="" /> <input
													type="hidden" name="auctionnum" value="" /> <input
													type="hidden" name="auction_uid" value=""> <input
													type="hidden" name="gongcode" value="" /> <input
													type="hidden" name="brandcode" value="" /> <input
													type="hidden" name="branduid" value="" /> <input
													type="hidden" name="sslid" value="pp0523535" /> <input
													type="hidden" name="sslip" value="www.realcoco.com" /> <input
													type="hidden" name="msecure_key" /> <input type="hidden"
													name="returnurl"
													value="http://www.realcoco.com/shop/idinfo.html" />
												<fieldset>
													<legend>member login</legend>
													<ul class="frm-list cb_clear">
														<li class="id">
															<dl class="id">
																<dt>ID</dt>
																<dd>
																	<input type="text" name="id" maxlength="20"
																		onblur="document.form1.passwd.focus();"
																		placeholder="아이디 입력" class="MS_login_id">
																</dd>
															</dl>
														</li>
														<li class="pwd">
															<dl class="pwd">
																<dt>PASSWORD</dt>
																<dd>
																	<input type="password" name="passwd" maxlength="20"
																		onkeydown="CheckKey(event);" placeholder="비밀번호 입력"
																		class="MS_login_pw">
																</dd>
															</dl>
														</li>
														<li class="login_submit"><a
															href="javascript:check();"><span class="login_btn">LOGIN</span></a>
														</li>
													</ul>
													<p class="se-log">
														<label><input type="checkbox" name="ssl" value="Y"
															class="MS_security_checkbox" checked="checked" /> 보안접속</label>
													</p>
												</fieldset>
											</form>
										</div>

										<div class="sign">
											<h3 class="blind">sign up</h3>
											<div class="btns">
												<dl>
													<dt>
														<span>주문조회를 원하시나요?</span>
													</dt>
													<dd>
														<a href="/shop/confirm_login.html?type=myorder"><span
															class="">ORDER CHECK</span></a>
													</dd>
												</dl>
											</div>
											<div class="btns">
												<dl>
													<dt>
														<span>회원가입을 하시면 더 많은 혜택을 받으실 수 있습니다.</span>
													</dt>
													<dd>
														<a href="/shop/idinfo.html?type=new&first="><span
															class="join_btn">JOIN</span></a>
													</dd>
												</dl>
											</div>
											<div class="btns">
												<dl>
													<dt>
														<span>아이디 / 비밀번호를 잊으셨나요?</span>
													</dt>
													<dd>
														<a href="/shop/lostpass.html"><span class="find_btn">FIND
																ID / PW</span></a>
													</dd>
												</dl>
											</div>
										</div>
									</div>
									<!--// 로그인정보 입력 Form : 끝 //-->
									<div id="simpleLogin">
										<div class="sns-login">
											<p>
												<img src="/design/pp0523535/smartpc/img/sns_login_title.png">
											</p>
											<div>
												<a href="javascript:sns_login_log('facebook');"><img
													src="/images/d3/modern_simple/btn/h34_sns_facebook.gif"
													alt="페이스북으로 로그인" /></a> <a
													href="javascript:sns_login_log('naver');"><img
													src="/images/d3/modern_simple/btn/h34_sns_naver.gif"
													alt="네이버로 로그인" /></a> <a
													href="javascript:sns_login_log('kakao');"><img
													src="/images/d3/modern_simple/btn/h34_sns_kakaotalk.gif"
													alt="카카오톡으로 로그인" /></a>
											</div>
										</div>
										<!-- .sns-login -->
									</div>
									<!-- #simpleLogin -->

								</div>
								<!-- .login_form_wrap -->



							</div>
							<!-- .page-body -->

						</div>
						<!-- .SMP-container -->

					</div>
					<!-- #loginWrap -->
				</div>
				<!-- #content -->
			</div>
			<!-- #contentWrap -->
		</div>
		<!-- #contentWrapper-->
		<hr />





	</form>
</body>
</html>
