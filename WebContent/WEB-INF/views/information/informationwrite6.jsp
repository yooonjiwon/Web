<%@page import="com.seoul.dto.Information"%>
<%@page import="com.seoul.dto.Member"%>
<%@page import="com.seoul.dto.Guide"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="utf-8">
<link rel="Stylesheet" href="/seoul/css/default.css" />
<link rel="Stylesheet" href="/seoul/css/input2.css" />
<style type="text/css">
a {
	text-decoration: none
} /* 언더스코어를 없애는 작업 */
</style>

<jsp:include page="/WEB-INF/views/include/common.jsp" />

<script type="text/javascript"
	src="/seoul/navereditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type='text/javascript'>
	$(function() {
		//전역변수선언
		var editor_object = [];

		nhn.husky.EZCreator.createInIFrame({
			oAppRef : editor_object,
			elPlaceHolder : "smarteditor",
			sSkinURI : "/seoul/navereditor/SmartEditor2Skin.html",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});

		$('a#write').on(
				'click',
				function(event) {
					editor_object.getById["smarteditor"].exec(
							"UPDATE_CONTENTS_FIELD", []);
					$('form#writeform').submit(); //writeform을 서버로 전송처리
					event.preventDefault(); //<a>의 기본기능(화면 리프레시) 수행을 막는 명령
				});
	});
</script>
</head>
<body id="page2">

	<jsp:include page="/WEB-INF/views/include/header.jsp" />

	<%--    	<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ로그인유저ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->	
					<% Member member = (Member)session.getAttribute("loginuser"); %>
					<c:if test="${ board.m_MemberId eq loginuser.memberId }" ></c:if>
		<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ --> --%>

	<!-- content -->
	<section id="content">
		<div class="bg-top">
			<div class="bg-top-2">
				<div class="bg">
					<div class="bg-top-shadow">
						<div class="main">
							<div class="box p3">
								<div class="padding">
									<div class="container_12">
										<div class="wrapper">
											<div class="grid_12">
												<div class="wrapper">
													<article class="grid_4 alpha" style="width: 200px">
														<div class="indent">
															<h3 class="prev-indent-bot2">Seoul Tour</h3>
															<ul class="list-2">
																<li><a href="/seoul/information/list3.action">도봉,
																		강북, 성북, 노원 </a></li>
																<li><a href="/seoul/information/list32.action">동대문,
																		중랑, 성동, 광진</a></li>
																<li><a href="/seoul/information/list33.action">강동,
																		송파</a></li>
																<li><a href="/seoul/information/list34.action">서초,
																		강남</a></li>
																<li><a href="/seoul/information/list35.action">동작,
																		관악, 금천</a></li>
																<li><a href="/seoul/information/list36.action">강서, 양천, 영등포, 구로</a></li>
																<li><a href="/seoul/information/list37.action">은평, 마포, 서대문</a></li>
																<li><a href="/seoul/information/list38.action">종로, 중구, 용산</a></li>
															</ul>
														</div>
													</article>
													<article class="grid_8 omega">
														<div id="pageContainer">

															<div style="padding-top: 25px; text-align: center">
																<div id="inputcontent">
																	<div id="inputmain" style="width: 900px">
																		<div class="inputsubtitle">게시판 글 쓰기</div>
																		<form id="writeform" action="write36.action"
																			method="post">
																			<table style="width: 600px">
																				<tr style="width: 200px">
																					<th>구역</th>
																					<td><input type="text" name="area"
																						style="width: 280px" /></td>
																				</tr>
																				<tr>
																					<th>제목</th>
																					<td><input type="text" name="title"
																						style="width: 280px" /></td>
																				</tr>
																				<tr>
																					<th>작성자</th>
																					<td>
																						<%
																							Member member = (Member) session.getAttribute("loginuser");
																						%>
																						<!-- 게시판에 로그인한 사용자의 아이디가 출력 --> <%=member.getMemberId()%>
																						<!-- input type="hidden" : 서버로 전송하지만 브라우저에 표시되지 않는 요소 -->
																						<input type="hidden" name="memberid"
																						value="<%=member.getMemberId()%>" />
																					</td>
																				</tr>
																				<tr>
																					<th>주소</th>
																					<td><input type="text" name="address"
																						style="width: 280px" /></td>
																				</tr>
																				<tr>
																					<th>전화번호</th>
																					<td><input type="text" name="telephone"
																						style="width: 280px" /></td>
																				</tr>
																				<tr>
																					<th>내용</th>
																					<td>
																						<!-- <input type="button" id="savebutton" value="서버전송" /> -->
																						<!-- <form action="/seoul/write3.action" method="post" id="frm"> -->
																						<textarea name="content" id="smarteditor"
																							rows="150" cols="100"
																							style="width: 280px; height: 212px;"></textarea>
																						<!-- <input type="text" style="width:767px" name="title" />
																							  <input type="text" style="width:767px" name="writer" />
																						      <input type="button" id="savebutton" value="서버전송" /> -->
																					</td>
																				</tr>
																			</table>
																			<div class="buttons">
																				<!-- <form>의 submit 수행 -->
																				<a id="write" href="#">글쓰기</a> &nbsp;&nbsp; <a
																					href="/seoul/information/list36.action">목록보기</a>
																			</div>
																		</form>
																	</div>
																</div>

																<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->

															</div>
														</div>

													</article>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="container_12">
								<div class="wrapper">
									<article class="grid_4">
										<h3 class="color-1 p2">Seoul Foundation</h3>
										<span class="text-1">It was established on March 15,
											2005 by Seoul Metropolitan Goverment to raise the quality of
											life through culture and arts and to enhance Seoul's urban
											competitiveness. <br>
										</span>
									</article>
									<article class="grid_4">
										<h3 class="color-1 p2">Culture</h3>
										<span class="text-1">Major projects include the
											creation of cultural arts creation environment, the expansion
											of cultural services with citizens, the enhancement of
											Seoul's cultural competitiveness. </span>
									</article>
									<article class="grid_4">
										<h3 class="color-1 indent-bot">Consultation</h3>
										<form id="subscribe-form" method="post"
											enctype="multipart/form-data">
											<fieldset>
												<div class="subscribe-field">
													<input type="text" />
												</div>
												<a class="button" href="#"
													onClick="document.getElementById('subscribe-form').submit()">Subscribe</a>
											</fieldset>
										</form>
									</article>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="bg-bot">
			<div class="main">
				<div class="container_12">
					<div class="wrapper">
						<article class="grid_4">
							<div class="indent-right2">
								<h3 class="prev-indent-bot2">Space Planning</h3>
								<ul class="list-2">
									<li><a href="#">Totam rem aperiam eaque ipsa quae
											abillo</a></li>
									<li><a href="#">Inventore veritatis quasi architecto
											beatae vitae</a></li>
									<li><a href="#">Nemo enim ipsam voluptatem quia</a></li>
									<li><a href="#">Voluptas sit aspernatur aut odit aut
											fugit</a></li>
									<li class="last-item"><a href="#">Sed quia
											consequuntur magni dolores eos</a></li>
								</ul>
							</div>
						</article>
						<article class="grid_8">
							<h3 class="p2">Selection &amp; Installation</h3>
							<div class="wrapper">
								<figure class="img-indent2 frame2">
									<img src="images/page2-img2.jpg" alt="" />
								</figure>
								<div class="extra-wrap">
									<h6 class="p1">At vero eos et accusamus et iusto odio
										dignissimos ducimus qui blanditiis praesentium voluptatum
										deleniti atque corrupti quos dolores et quas molestias.</h6>
									Excepturi sint occaecati cupiditate non provident, similique
									sunt in culpa qui officia deserunt mollitia animi, id est
									laborum et dolorum fuga. Et harum quidem rerum facilis est et
									expedita distinctioam libero tempore cum soluta.
								</div>
							</div>
						</article>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!--==============================footer=================================-->
	<footer>
		<div class="main">
			<div class="container_12">
				<div class="wrapper">
					<div class="grid_4">
						<div>
							주소 &copy; 2011 <a class="link color-3" href="#">Privacy
								Policy</a>
						</div>
						<div>
							<a rel="nofollow" target="_blank"
								href="http://www.templatemonster.com/">Website Template</a> by
							TemplateMonster.com | <a rel="nofollow" target="_blank"
								href="http://www.html5xcss3.com/">html5xcss3.com</a>
						</div>
						<!-- {%FOOTER_LINK} -->
					</div>
					<div class="grid_4">
						<span class="phone-numb"><span>+82(02)</span> 1544-1774</span>
					</div>
					<div class="grid_4">
						<ul class="list-services">
							<li><a href="#"></a></li>
							<li><a class="item-2" href="#"></a></li>
							<li><a class="item-3" href="#"></a></li>
							<li><a class="item-4" href="#"></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>
