﻿<%@page import="com.seoul.dto.Member"%>
<%@page import="com.seoul.dto.Information"%>
<%@page import="com.seoul.dto.Guide"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>

<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="utf-8">
<!-- <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">
    <script src="js/jquery-1.6.2.min.js"></script> -->
<jsp:include page="/WEB-INF/views/include/common.jsp" />
<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() { //jQuery's main function
		$('#write').on('click', function(event) {
			location.href = '/seoul/information/write32.action';
		});
	});
</script>

<!--[if lt IE 7]>
        <div style=' clear: both; text-align:center; position: relative;'>
            <a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0"  alt="" /></a>
        </div>
	<![endif]-->
<!--[if lt IE 9]>
   		<script type="text/javascript" src="js/html5.js"></script>
        <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen">
	<![endif]-->
</head>
<body id="page2">

	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<jsp:include page="/WEB-INF/views/include/common.jsp" />
	<!-- content -->
	<section id="content">
		<div class="bg-top">
			<div class="bg-top-2">
				<div class="bg">
					<div class="bg-top-shadow">
						<div class="main">
							<div class="box p3" style="width: 1000px">
								<div class="padding">
									<div class="container_12">
										<div class="wrapper">
											<div class="grid_12">
												<div class="wrapper">
													<article class="grid_4 alpha">
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
														<span style=" font-weight: bold; font-size: 1.5em; line-height: 0.8em; color: gray; font-family: arial ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[동대문, 중랑, 성동, 광진]<br><br></span>
														
														<% List<Information> informations = (List<Information>) request.getAttribute("boards"); %>
														<table class="type07" style="margin: 0 auto;">
															<thead align="center">
																<tr>
																	<th scope="cols">AREA</th>
																	<th scope="cols">TITLE</th>
																	<th scope="cols">ID</th>
																	<!-- <th scope="cols">ADDRESS</th>
															        <th scope="cols">TELEPHONE</th>
															        <th scope="cols">REGDATE</th> -->
																	<th scope="cols">VIEWS</th>
																</tr>
															</thead>
															<tbody>
																<%
																	for (Information information : informations) {
																%>
																<!-- 빠른포문 -->
																<tr>
																	<th scope="row" align="center"><%=information.getIn_Area()%></th>
																	<td style='text-align: center'>
																		<%-- <c:otherwise>
																		<a href='lock3.action?boardno=${ board.boardNo }&pageno=${ pageno }' style='text-decoration: none'>
				  											    			${ board.title }
																		</a><img src="/seoul/images/lock.gif"/>
																		</c:otherwise> --%> 
				<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ삭제 글일경우ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->
																		<% if (information.isDeleted()) { //삭제된 글인 경우 %> 
																		<span id="deleted-message">[ 삭제된 글 ]</span> 
																		<% } else { //삭제되지 않은 글 %>
																		<a href="detail32.action?boardno=<%=information.getIn_No()%>&pageno=<%=request.getAttribute("pageno")%>"
																			style='text-decoration: none'> <%=information.getIn_Title()%>
																		</a> 
																		<% } %>
																	</td>
																	<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->
																	<td style='text-align: center'><%=information.getM_MemberId()%></td>
																	<%-- <td class="td2" style='text-align:center'><%= information.getIn_Address() %></td>
																	<td style='text-align:center'><%= information.getIn_Telephone() %></td>
																	<td style='text-align:center'><%= information.getRegDate() %></td> --%>
																	<td class="td3" style='text-align: center'><%=information.getReadCount()%></td>
																	<% } %>
																</tr>
															</tbody>
														</table>
														<br>
														<br>
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=request.getAttribute("pager").toString()%><br>
														<br>
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

														<%-- <% Member member = (Member)session.getAttribute("loginuser"); %>
		     										    <% if ( member.getMemberId() == "admin" ) { %> --%>
														<input id="write" type="button" value="글쮸긔"
															style="width: 100px; height: 25px" />
														<%--  <% } %> --%>
												</div>
											</div>

											<br>
											<br>
											<br>
											<br>
											<br>
											<br>
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
							<span class="text-1">It was established on March 15, 2005
								by Seoul Metropolitan Goverment to raise the quality of life
								through culture and arts and to enhance Seoul's urban
								competitiveness. <br>
							</span>
						</article>
						<article class="grid_4">
							<h3 class="color-1 p2">Culture</h3>
							<span class="text-1">Major projects include the creation
								of cultural arts creation environment, the expansion of cultural
								services with citizens, the enhancement of Seoul's cultural
								competitiveness. </span>
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
									<img src="" alt="" />
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
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>
