<%@page import="com.seoul.dto.ContactsBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/seoul/css/default.css" />
	<link rel="stylesheet" href="/seoul/css/input.css" />
    <link rel="stylesheet" href="/seoul/css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/seoul/css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/seoul/css/grid.css" type="text/css" media="screen">
    <link rel="Stylesheet" href="/seoul/css/tabledesign.css" />
	<link rel="stylesheet" href="/seoul/css/style4.css" type="text/css" media="screen">
	<script src="/seoul/js/jquery.galleriffic.js" type="text/javascript"></script>
    <script src="/seoul/js/jquery.opacityrollover.js" type="text/javascript"></script>   
    <script src="js/jquery-1.6.2.min.js" type="text/javascript"></script>     
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript">
	$(function() { // jQuery's main function // html에 하드코딩하는 방식이 좋지 않기때문에 javascript를 분리해서 수행
		$('input#write').on('click', function(event) {
			location.href= 'quewrite.action';
		});
	});
	
	$(function() {
		$('button#search').on('click', function(event){
			var search1 = $('select#search1').val();
			var search2 = $('input#search2').val();
			location.href= 'quesearch.action?pageno=1&search1=' + search1 + '&search2=' + search2;
		});
		
	});
	</script>
</head>
<body id="page5">
	
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<div class="ic">More Website Templates  @ TemplateMonster.com - August22nd 2011!</div>
    
<!-- content -->
    <section id="content">
        <div class="bg-top">
        	<div class="bg-top-2">
                <div class="bg">
                    <div class="bg-top-shadow">
                        <div class="main">
                            <div class="box">
                                <div class="padding">
                                    <div class="container_12">
                                        <div class="wrapper">
                                            <article class="grid_4 alpha">
												<div class="indent">  
													<h3 class="prev-indent-bot2">Contacts</h3>
                                               	    <ul class="list-2">
                                                   		<li><a href="contactslist.action">공지사항</a></li>
                                                    	<li><a href="eventlist.action">이벤트</a></li>
                                                    	<li><a href="quelist.action">문의사항</a></li>
                                                    	<li class="last-item"><a href="afterlist.action">후기</a></li>
                                                	</ul>
                                            	</div>
                                            </article>
                                            <article class="grid_8 omega">
												<div style="padding-top:25px;text-align:center">
													<!-- location.href= -->
													<table border="1" align="center">
														<tr style="background-color:beige;height:25px">
															<th style="width:50px">번호</th>
															<th style="width:300px">제목</th>
															<th style="width:150px">작성자</th>
															<th style="width:120px">작성일</th>
															<th style="width:80px">조회수</th>
														</tr>
														<%-- <% for (ContactsBoard board : boards) { --%>
														<c:forEach var="board" items="${ boards }">
														<tr style="height:25px">
															<td style='text-align:center'>${ board.boardNo }
															<td style='text-align:left; padding:5px;'>
															<c:if test="${ board.depth gt 0 }">
															<c:forEach begin="0" end="${ board.depth - 1 }" step="1">
															<%-- <% for (int i = 0; i < board.getDepth(); i++) { --%>
															&nbsp;&nbsp;
															<%-- <% }
															<% if (board.getDepth() > 0) { %> --%>
															<img src="/seoul/images/re.gif">
															<%-- <% } --%>
															</c:forEach>
															</c:if>
															
															<c:choose>
															<%-- <% if (board.isDeleted()) { // 삭제된 글인 경우 --%>
															<c:when test="${ board.deleted }">
																<span id="deleted-message">[삭제된 글]</span>
															</c:when>
															<%-- <% } else if (board.getPassword() == null) { --%>
															<c:when test="${ empty board.password or loginuser.memberId eq 'admin'}">
															<!--  게시글 목록중 하나를 눌렀을 때 내용으로 넘어가는 작업 1단계 Rewrite -->
																<a href='quedetail.action?boardno=${ board.boardNo }&pageno=${ pageno }' style='text-decoration: none'>
																	${ board.title }
																</a>
															<%-- <% } else { --%>
															</c:when>
															<c:otherwise>
																<a href='lock.action?boardno=${ board.boardNo }&pageno=${ pageno }' style='text-decoration: none'>
																	${ board.title }
																</a><img src="/seoul/images/lock.gif"/>
															<%-- <% } --%>
															</c:otherwise>
															</c:choose>
															</td>
															<td style='text-align:center'>${ board.writer }</td>
															<td style='text-align:center'>${ board.regDate }</td>
															<td style='text-align:center'>${ board.readCount }</td>
														</tr>
														<%-- <% } --%>
														</c:forEach>
													</table>
													<br/><br/>
													<%-- <%= request.getAttribute("pager2").toString() --%>
													${ pager2 }
													<br/><br/>
													<div>
														<input id="write" type="button" value="글쓰기" 
														style="width:300px;height:25px" />
													</div>
													<div>
														<select id="search1" name="search1" style="width:50px">
															<!-- value 속성의 값은 서버로 전송되는 값-->
															<option value="title">제목</option>
															<option value="content">내용</option>
															<option value="id">아이디</option>
														</select>
														<input type="text" name="search2" id="search2" style="width:200px" />
														<button id="search">검색</button>	
													</div>
												</div>
                                            </article>
                                        </div>
                                    </div>
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
                    	<article class="grid_3">
                        	<h3 class="prev-indent-bot">Our Address</h3>
                            <dl>
                                <dt class="indent-bot">서울특별시 강남구 테헤란로 123<br>여삼빌딩 15층</dt>
                                <dd><span>Telephone:</span>  02-6255-8002</dd>
                                <dd><span>FAX:</span> 02-569-8069</dd>
                                <dd><strong>E-mail:</strong> <a href="#">info@itwill.co.kr</a></dd>
                            </dl>
                        </article>
                        <article class="grid_9">
                        	<h3 class="prev-indent-bot">HelloSeoul Info</h3>
                            <img src="/seoul/images/contactsinfo1.jpg">
                            <img src="/seoul/images/contactsinfo2.jpg">
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
