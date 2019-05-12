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
	$(function() {
		$('button#confirm').on('click', function(event){
			$('form#password').submit();
			event.preventDefault();
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
															<td style="width:50px">비밀번호 : </td>
															<td>
															<form id="password" action="lock2.action" method="post">
															<input type="password" name="password1" id="password1" style="width:300px" />
															<input type="hidden" name="boardno" id="boardno" value=${ board.boardNo }>
															<input type="hidden" name="pageno" id="pageno" value=${ pageno }>
															</form>
															</td>
															<td>
															<button id="confirm">확인</button>
															</td>
														</tr>
													</table>
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
