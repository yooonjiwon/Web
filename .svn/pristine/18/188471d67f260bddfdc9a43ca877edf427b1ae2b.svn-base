<%@ page language="java" contentType="text/html; charset=utf-8"
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
<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(function() {
	$('#editbtn').on('click', function(event) {
		$('form#editmemberform').submit();
		event.preventDefault();
	});
});

</script>


</head>
<body class="page1" id="top">


	<form id="editmemberform" action="editmember.action" method="post">
	
	<div class="main">

		<jsp:include page="/WEB-INF/views/include/header.jsp" flush="true">
			<jsp:param name="bg-color" value="palegreen" />
		</jsp:include>
		<!--==============================Content=================================-->

		<div id="contentWrapper">
			<div id="contentWrap">
				<div id="content">
					<div id="join" class="mypage SMP-table">
						<div class="SMP-container">
							<h2 class="tit_page">MY INFOMATION</h2>
							<div id="personInfo">
								<ul class="cb_clear" style="padding-right: 100px">

									<li class="txt">
										<table class="person-tb">
											<colgroup>
												<col width="170" />
												<col width="*">
											</colgroup>
											<tr>
												<th>
													<div>
														<span class="fc_brown">*</span> 이름
													</div>
												</th>
												<td>
													<div>
														<input type="text" name="name" id="name"
															value="${ member.name }" class="MS_input_txt w180"
															size="15" maxlength="30" />
													</div>
												</td>
											</tr>
											<tr>
												<th>
													<div>
														<span class="fc_brown">*</span> 아이디
													</div>
												</th>
												<td>
													<div>
														${ loginuser.id } 
														<input type="hidden" name="id" id="id" value="${ loginuser.id }" />
													</div>
												</td>
											</tr>
											<tr>
												<th>
													<div>
														<span class="fc_brown">*</span> 비밀번호
													</div>
												</th>
												<td>
													<div>
														<input type="password" name="passwd" id="passwd"
															class="MS_input_txt w180" value="" size="15"
															maxlength="30" /> <span>
															<span class="fs_11 fc_gray8 margin_l10"><br /> -
																영문 대소문자/숫자/특수문자를 혼용하여 8~16자</span>
														</span>
													</div>
												</td>
											</tr>
											<!-- <tr>
												<th>
													<div>
														<span class="fc_brown">*</span> 비밀번호 확인
													</div>
												</th>
												<td>
													<div>
														<input type="password" name="password2" id="password2"
															class="MS_input_txt w180" value="" size="15"
															maxlength="20"
															onkeyup="check_pwd_length(this, 'repassword');" />
													</div>
												</td>
											</tr> -->
											<tr>
												<th>
													<div>
														<span class="fc_brown">*</span> 생일
													</div>
												</th>
												<td>
													<div class="custom_select cb_clear">
														<input type="date" id="birth" name="birth"
															value="${ member.birth }">
													</div>

												</td>
											</tr>

											<tr>
												<th class="arr_line">
													<div>
														<span class="fc_brown">*</span> 주소
													</div>
												</th>
												<td>
													<div class="arr_line">
														<ul>
															<li><input type="text" name="addr1" id="addr1"
																class="MS_input_txt w600" size='40' maxlength="100"
																value="${ member.addr1 }" /></li>
															<li class="margin_none"><input type="text"
																name="addr2" id="addr2" class="MS_input_txt w600"
																size='40' maxlength="100" value="${ member.addr2 }" /></li>
														</ul>
													</div>
												</td>
											</tr>

											<tr>
												<th>
													<div>
														<span class="fc_brown">*</span> 연락처
														<td><input type="text" name="phone" id="phone"
															value=${ member.phone } class="MS_input_txt w180"
															size="30" maxlength="40" /></td>
													</div>
												</th>
												<td>
													<div></div>
												</td>
											</tr>
											<tr>
												<th>
													<div>

														<span class="fc_brown">*</span> 이메일
													</div>
												</th>
												<td>
													<div>
														<input type="text" name="email" id="email"
															value="${ member.email }" class="MS_input_txt w180"
															size="30" maxlength="40" /> </span>
													</div>
												</td>
											</tr>

										</table>
									</li>
								</ul>
							</div>
							<!-- #personInfo -->




							<div class="btn-area">
								<a href="#"><img id="editbtn" name="editbtn" alt="수정완료"
									src="/dieat/resources/images/join_new_rewrite_btn.gif" /></a> <a
									href="account/mypage.action"><img alt="돌아가기"
									src="/dieat/resources/images/join_new_cancel_btn.gif" /></a> <br>
								<br> <br> <br> <br>
							</div>
						</div>
						<!-- .SMP-container -->
					</div>
					<!-- #join -->
				</div>
				<!-- #content -->
			</div>
			<!-- #contentWrap -->
		</div>
		<!-- #contentWrapper-->
	</div>

	<hr />


</form>

	<br>
	<br>
	<br>
	<!--==============================Content=================================-->
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="true">
		<jsp:param name="bg-color" value="palegreen" />
	</jsp:include>
	<!-- end of footer -->
</body>
</html>

