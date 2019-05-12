<%@page import="com.seoul.dto.GuideBoardAttach"%>
<%@page import="com.seoul.dto.Guide"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
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

				
					<!-- content -->
	<main id="container" class="qna">
		<h2 class="hd-element">페이지 별 콘텐츠 내용 시작</h2>

		<header id="pageheader">
	<div class="holder">
		<h3>질문 & 답변</h3>
		</div>
</header><div class="holder">

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
		<%= request.getAttribute("pager").toString() %>
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
     
          
        <div class="bg-bot">
        	<div class="main">
            	<div class="container_12">
                	<div class="wrapper">
                	
                	
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
    		 
<!--     <script type="text/javascript">
			$(window).load(function() {
			// We only want these styles applied when javascript is enabled
			$('div.navigation').css({'width' : '320px', 'float' : 'right'});
			$('div.content').css('display', 'block');
	
			// Initially set opacity on thumbs and add
			// additional styling for hover effect on thumbs
			var onMouseOutOpacity = 0.5;
			$('#thumbs ul.thumbs li span').opacityrollover({
				mouseOutOpacity:   onMouseOutOpacity,
				mouseOverOpacity:  0.0,
				fadeSpeed:         'fast',
				exemptionSelector: '.selected'
			});
			
			// Initialize Advanced Galleriffic Gallery
			var gallery = $('#thumbs').galleriffic({
				delay:                     7000,
				numThumbs:                 12,
				preloadAhead:              6,
				enableTopPager:            false,
				enableBottomPager:         false,
				imageContainerSel:         '#slideshow',
				controlsContainerSel:      '',
				captionContainerSel:       '',
				loadingContainerSel:       '',
				renderSSControls:          true,
				renderNavControls:         true,
				playLinkText:              'Play Slideshow',
				pauseLinkText:             'Pause Slideshow',
				prevLinkText:              'Prev',
				nextLinkText:              'Next',
				nextPageLinkText:          'Next',
				prevPageLinkText:          'Prev',
				enableHistory:             true,
				autoStart:                 7000,
				syncTransitions:           true,
				defaultTransitionDuration: 900,
				onSlideChange:             function(prevIndex, nextIndex) {
					// 'this' refers to the gallery, which is an extension of $('#thumbs')
					this.find('ul.thumbs li span')
						.css({opacity:0.5})
				},
				onPageTransitionOut:       function(callback) {
					this.find('ul.thumbs li span').css({display:'block'});
				},
				onPageTransitionIn:        function() {
					this.find('ul.thumbs li span').css({display:'none'});
				}
			});
		}); -->
	</script>
</body>
</html>
