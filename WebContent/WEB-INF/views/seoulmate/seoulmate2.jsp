<%@page import="com.seoul.dto.GuideBoardAttach"%>
<%@page import="com.seoul.dto.Guide"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>서울 투어 가이드</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/seoul/css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/seoul/css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/seoul/css/grid.css" type="text/css" media="screen">  
    <link rel="stylesheet" href="/seoul/css/guide2.css" type="text/css" media="screen">  
    <script src="js/jquery-1.6.2.min.js" type="text/javascript"></script> 
    <script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
   <script src="js/jquery.galleriffic.js" type="text/javascript"></script>
    <script src="js/jquery.opacityrollover.js" type="text/javascript"></script> 
    	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    <script type="text/javascript">
		$(function() {
		$('#btnCreate').on('click', function(event) {
			location.href = 'write.action';
		});
		});
		$(function() {
			$('#writee').on('click', function(event) {
				location.href = 'writee.action';
			});
			
			
			});
 		$(function() {
			$('button#search').on('click', function(event) {
				location.href = 'search.action'; //writeform을 서버로 전송처리
			});
		}); 
		
	

	</script>    

</head>
<body id="page30">

		<jsp:include page="/WEB-INF/views/include/header.jsp" />
    	<jsp:include page="/WEB-INF/views/include/common.jsp" />
    <div class="ic">More Website Templates  @ TemplateMonster.com - August22nd 2011!</div>
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
                                            <div class="grid_12">
                                            	<div class="indent-left p2">

				
		<main id="container" class="qna">

			<header id="pageheader">
				<div class="holder">
				<h3>가이드 신청 및 가이드북 다운로드</h3>
				</div>
		</header>
		<div class="holder">

	<!-- content -->

		<div id="writee" class="guidebook_app_btn"><a href="#">무료 가이드북 &amp;지도<br><strong>우편 신청하기</strong></a></div>
</div>
<div class="box-tabcontent">
			<div id="tab-cont-header2">
				<div class="set-button">
					<a href="#none" class="button middle blue bold" id="btnCreate">
						가이드 신청하기
					</a>
					
				</div>
			</div>
		</div>

		<div class="box-faqitem">
			<% List<Guide> guides = (List<Guide>)request.getAttribute("guides"); %>
			
			<% for (Guide guide : guides) { %>
				<div class="cnt-faqitem qna">
					<div class="header">
						<p class="date fc-bold fc-grey3">
						글번호 : <span class="fc-black2"><%= guide.getGub_BoardNo() %></span>&nbsp;&nbsp;
						작성일 : <span class="fc-black2"><%= guide.getGub_RegDate() %></span>&nbsp;&nbsp;
						조회수 : <span class="fc-black2"><%= guide.getGub_ReadCount() %></span>&nbsp;&nbsp;
						작성자 : <span class="fc-black2"><%= guide.getGub_Writer() %></span>
						
						<h4 class="heading2 regular fc-blue">
						<a href="detail.action?gub_boardno=<%= guide.getGub_BoardNo() %>&pageno=<%= request.getAttribute("pageno") %>"
						 class="regular fc-blue"><%= guide.getGub_Title() %></a></h4>
						<span class="button-mail">
						<img src="../images/ico-mail.png" alt="이메일 보내기" /></span>
						
					</div>
				</div>
			<% } %>
			<div>
			</div>
			<br><br>
		<%= request.getAttribute("pager").toString() %>&nbsp;&nbsp;&nbsp;
		
		
		
		
		<select style="height=20px;">
		<option value="gub_writer">작성자 ID</option>
		<option value="gub_title">제목</option>
		<option value="gub_intro">내용</option>
		</select>
		<input type="text" placeholder="  Search" autocomplete="off" tabindex="1" class="txtinput" style="background-color:#bfb282;">
		<button id="guidesearch">[검색]</button>	 
		</div>   	
			
			
 		<div class='aside_menu'>
 		 <form name='searchform' method='get' action="search.action">
  		  <aside style='float: right;'>
     		<select name='col'> 검색 컬럼
      		 <option value='gub_writer'>작성자 ID</OPTION>
      		 <option value='gub_title'>제목</OPTION>
       		 <option value='gub_content'>내용</OPTION>
      		</select>
      		
      		
      		
      <input type='text' name='word' placeholder="특수문자는 사용할수 없습니다.">
      <button id='search'>검색</button>    
    </aside> 
  </form>
  <div class='menu_line' style='clear: both;'></DIV>
</div> 

			
				
				
				
				
				
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
			
				
				
				
				
					
			</section>
     
          <main id="container" class="qna">
        <div class="bg-bot">
        	<div class="main">
            	<div class="container_12">
                	<div class="wrapper">
                	<header id="pageheader">
	<div class="holder">
		<h4>가이드북 ＆ 서울 관광 지도 다운로드</h3>
		</div>
</header>
                	
                	<div class="indent-right2">
                                	                            <div class="box-travel-guidebook">
					<div class="item">
							<span class="img" style="background-image:url(../images/book02.jpg)"> </span>
							<span class="txt ellipsis fc-black fc-bold" style="text-align: center;">서울 관광 지도</span>
							<div class="set-button" title="PDF 다운로드">
								<a style="margin-left:0;" href="filedownload.action?file_no=20" 
								class="pdfview button middle bold borderred">PDF View <span class="small regular">(27 MB)</span></a>
									</div>
						</div>
					<div class="item">
							<span class="img" style="background-image:url(../images/book03.jpg)"> </span>
							<span class="txt ellipsis fc-black fc-bold" style="text-align: center;">한류관광 가이드북</span>
							<div class="set-button" title="PDF 다운로드">
								<a style="margin-left:0;" href="filedownload.action?file_no=21" 
								class="pdfview button middle bold borderred">PDF View <span class="small regular">(6 MB)</span></a>
									</div>
						</div>
					<div class="item">
							<span class="img" style="background-image:url(../images/book08.jpg)"> </span>
							<span class="txt ellipsis fc-black fc-bold" style="text-align: center;">서울 골목길 명소</span>
							<div class="set-button" title="PDF 다운로드">
								<a style="margin-left:0;" href="filedownload.action?file_no=22" 
								class="pdfview button middle bold borderred">PDF View <span class="small regular">(19 MB)</span></a>
									</div>
						</div>
					<div class="item">
							<span class="img" style="background-image:url(../images/book07.jpg)"> </span>
							<span class="txt ellipsis fc-black fc-bold" style="text-align: center;">서울 속 세계여행 이야기</span>
							<div class="set-button" title="PDF 다운로드">
								<a style="margin-left:0;" href="filedownload.action?file_no=23" 
								class="pdfview button middle bold borderred">PDF View <span class="small regular">(10 MB)</span></a>
									</div>
						</div>
					</div>
                                	
                                	
                                	
                                	
                              
                                    
                                </div>
                            </div>
                        </article>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    		 <jsp:include page="/WEB-INF/views/include/footer.jsp" />

</body>
</html>
