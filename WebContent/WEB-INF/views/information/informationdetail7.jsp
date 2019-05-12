<%@page import="com.seoul.dto.Member"%>
<%@page import="com.seoul.dto.Information"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>글쓰기</title>
<link rel="Stylesheet" href="/seoul/css/default.css" />
<link rel="Stylesheet" href="/seoul/css/input2.css" />
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	//삭제할까요? 묻는 기능
	$(function() {
		$('a#delete').on('click', function(event) {
			var boardNo = $(this).attr('data-boardno');
			var ok = confirm(boardNo + '번 글을 삭제할까요?');
			if (ok) {
				location.href = "delete37.action?boardno=" + boardNo;
			}
			event.preventDefault(); //<a>의 기본동작 중단하는 작업
		});

		$('a[id=edit]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno');
			toggleCommentStatus(commentNo, true);
			event.preventDefault();
		});

		$('a[id=modify]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno');
			$('#commenteditform' + commentNo).submit();
			event.preventDefault();
		});

		$('a[id=cancle]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno');
			toggleCommentStatus(commentNo, false);
			event.preventDefault();
		});
	});
</script>

</head>
<body id="page2">

	<div id="pageContainer">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<jsp:include page="/WEB-INF/views/include/common.jsp" />
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
																		<div id="inputmain">
																			<div class="inputsubtitle">게시판 글 내용</div>
																			<%
																				Information information = (Information) request.getAttribute("information");
																			%>
																			<table style="width: 600px">
																				<tr>
																					<th>제목</th>
																					<td><%=information.getIn_Title()%></td>
																				</tr>
																				<tr>
																					<th>작성자</th>
																					<td><%=information.getM_MemberId()%></td>
																				</tr>
																				<tr>
																					<th>주소</th>
																					<td><%=information.getIn_Address()%></td>
																				</tr>
																				<tr>
																					<th>전화번호</th>
																					<td><%=information.getIn_Telephone()%></td>
																					<!-- style='text-align:left' -->
																				</tr>
																				<tr>
																					<th>내용</th>
																					<td><%=information.getIn_Content().replace("\r\n", "<br>")%>
																						<!-- style="height:200px;vertical-align:top" --></td>
																				</tr>
																			</table>
																			<div class="buttons">

																				<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ로그인유저ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->
																				<% Member member = (Member) session.getAttribute("loginuser"); %> 
																				<%-- <c:if test="${ member.memberId eq loginuser.memberId }" > --%>
																				<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->

																				<%-- <% if ( member.getMemberId().equals( information.getM_MemberId())) { %> --%>
																			
																			<% if (member == null)  { %>
																					[<a href='list37.action?pageno=<%=request.getAttribute("pageno")%>'>목록보기</a>]
																						<% } else if (member.getMemberId().equals("admin")) { %>
																						[<a id="delete" href='#'	data-boardno="<%=information.getIn_No()%>">삭제</a>]
																						[<a href='update37.action?boardno=<%=information.getIn_No()%>&pageno=<%=request.getAttribute("pageno")%>'>수정</a>]
																						[<a href='list37.action?pageno=<%=request.getAttribute("pageno")%>'>목록보기</a>]
																							<%} else { %>
																							[<a href='list37.action?pageno=<%=request.getAttribute("pageno")%>'>목록보기</a>]
																							<% }	%>

																			</div>
																		</div>
																	</div>

																	<br />
																	<br />
																	<br />
																	<br />
																	<br />
																	<br />

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
												creation of cultural arts creation environment, the
												expansion of cultural services with citizens, the
												enhancement of Seoul's cultural competitiveness. </span>
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
