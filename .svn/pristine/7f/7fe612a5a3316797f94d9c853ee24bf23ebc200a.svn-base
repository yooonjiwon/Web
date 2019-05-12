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
		$('#write').on('click', function(event) {
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
                                                	<h3 class="p0">Latest Income</h3>				
                                                	<form action="file.action" method="post" enctype="multipart/form-data">
													<input type="file" name="pdf"><input type="submit" value="등록"> <input type="reset" value="취소">
													</form> 
													
                                                </div>
                                                
                                                
                <section id="content"> 
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
					
			</section>
                  
                    
                    
                    
                    
                    
                    
                    
                    
                    
                 <!-- ///////////////////////////////////////////////////////////////////////////// -->      
                    
                    
                    
                                                    
     	<div id="pageContainer">
		<div style="padding-top:25px;text-align:center">

			<input id="write" type="button" value="가이드 신청하기" 
				style="width:300px;height:25px" />
			<input id="writee" type="button" value="관광지도 신청하기" 
				style="width:300px;height:25px" />
			<br /><br />
		 
			<% List<Guide> guides = (List<Guide>)request.getAttribute("guides"); %>
			
			<table id="guidelist" style="border:1px; margin: 0 auto;">
				<tr style="background-color:beige;height:25px">
					<th style="width:50px">번호</th>
					<th style="width:300px">제목</th>
					<th style="width:150px">작성자</th>
					<th style="width:120px">작성일</th>
					<th style="width:120px">조회수</th>
				</tr>
				<% for (Guide guide : guides) { %>
                    <tr style="height:25px">
					<td style='text-align:center'><%= guide.getGub_BoardNo() %></td>
					<td style='text-align:left; padding:5px;'>
					<% for (int i = 0; i < guide.getGub_Depth(); i++) { %>
					&nbsp;&nbsp;
					<% } %>
					<% if (guide.getGub_Depth() > 0) { %>
					<img src="/seoul/images/re.gif">
					<% } %>
					<%-- <% if (guide.isGub_Deleted()) { //삭제된 글인 경우%>
						<span id="deteled-message">[삭제된 글]</span>
					<% } else { //삭제되지 않은 글인 경우 %>
					
					<!-- 게시글 목록중 하나를 눌렀을때 내용으로 넘어가는 작업 1단계 Rewrite -->
					<!-- 목록보기로 돌아올때 페이지번호 정보를 같이 가지고 넘어올수 있도록 pageno도 추가 --> --%>
						<a href="detail.action?gub_boardno=<%= guide.getGub_BoardNo() %>&pageno=<%= request.getAttribute("pageno") %>" style='text-decoration:none'> 
							<%= guide.getGub_Title() %>
						</a>	
					<%-- <% } %>	 --%>
					</td>
					<td style='text-align:center'><%= guide.getGub_Writer() %></td>
					<td style='text-align:center'><%= guide.getGub_RegDate() %></td>
					<td style='text-align:center'><%= guide.getGub_ReadCount() %></td>
				</tr>
				<% } %>
				</table> 
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
    		 
    <script type="text/javascript">
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
		});
	</script>
</body>
</html>
