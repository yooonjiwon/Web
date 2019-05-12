<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="kr">
	<head>
		<title>Home</title>
		<meta charset="utf-8">
		<meta name="format-detection" content="telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="Stylesheet" href="/dieat/resources/styles/default.css" />
		<link rel="Stylesheet" href="/dieat/resources/styles/input2.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/main.css">
		<link rel="stylesheet" href="/dieat/resources/styles/exercise.css">
		<link rel="stylesheet" href="/dieat/resources/styles/style_common.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/style4.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/camera.css">
		<link rel="stylesheet" href="/dieat/resources/styles/style.css">
		<script src="/dieat/resources/js/jquery.js"></script>
		<script src="/dieat/resources/js/jquery-migrate-1.2.1.js"></script>
		<script src="/dieat/resources/js/script.js"></script>
		<script src="/dieat/resources/js/superfish.js"></script>
		<script src="/dieat/resources/js/jquery.ui.totop.js"></script>
		<script src="/dieat/resources/js/jquery.equalheights.js"></script>
		<script src="/dieat/resources/js/jquery.mobilemenu.js"></script>
		<script src="/dieat/resources/js/camera.js"></script>		
		<script src="/dieat/resources/js/jquery.mobile.customized.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.js"></script>		
		<script type="text/javascript">
			$(document).ready(function(){
				jQuery('#camera_wrap').camera({
					loader: false,
					pagination: false ,
					minHeight: '444',
					thumbnails: false,
					height: '27.86458333333333%',
					caption: true,
					navigation: true,
					fx: 'simpleFade'
				});
				$().UItoTop({ easingType: 'easeOutQuart' });
			});
			
			//글쓰기 클릭 링크이벤트
			$(function() {
				$('a#write').on('click', function(event) {
					$('form#writeform').submit();
					event.preventDefault();
				});
			});
		</script>		
	</head>
	
	<body class="page1" id="top">
		<div class="main">
			
	    <jsp:include page="/WEB-INF/views/include/header.jsp" flush="true">
     		<jsp:param name="bg-color" value="palegreen" />
        </jsp:include>
<!--==============================Content=================================-->
		<div class="slider_wrapper">
				
		<!-- write틀 만들기 -->		
		<div id="pageContainer">		
			<div style="padding-top:25px;text-align:center">
			<div id="inputcontent">
			    <div id="inputmain">
			        <div class="inputsubtitle">게시판 글 쓰기</div>
			        <form id="writeform" action="write.action" method="post">
			        <table>
						<tr>
							<th>운동명</th>
							<td>
								<input type="text" name="name" style="width:150px" />
							</td>
						</tr>
						<tr>
							<th>운동부위</th>
							<td>
								<input type="text" name="type" style="width:100px" />
							</td>
						</tr>
						<tr>
							<th>칼로리</th>
							<td>
								<input type="text" name="cal" style="width:50px" />
							</td>
						</tr>
						<tr>
							<th>운동방법</th>
							<td>
								<textarea name="content" cols="76" rows="15" ></textarea>
							</td>
						</tr>
					</table>
			        <div class="buttons">
			        	<!-- <form>의 submit 수행 -->	        	
			        	<a id="write" href="#">글쓰기</a>
			        	&nbsp;&nbsp;
			        	<a href="/dieat/exercise/weight-list.action">목록</a>
			        </div>
			        </form>
			    </div>
			</div>		
			</div>
		</div>
		
		</div>
			<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - April 21, 2014!</div>
				<div class="container_12">
					<div class="grid_12">
						<h2 class="center">The Next Marathon</h2>						
					</div>
					<div class="clear"></div>
					<div class="grid_4">
						<div class="box">
							<div class="box_title">Calendar</div>
							<div class="box_bot">
								<div class="maxheight">
									<img src="images/page1_img1.jpg" alt=""><a href="#">More</a>
								</div>
							</div>
						</div>
					</div>
					<div class="grid_4">
						<div class="box">
							<div class="box_title">Members</div>
							<div class="box_bot">
								<div class="maxheight">
									<img src="images/page1_img2.jpg" alt=""><a href="#">More</a>
								</div>
							</div>
						</div>
					</div>
					<div class="grid_4">
						<div class="box">
							<div class="box_title">Results</div>
							<div class="box_bot">
								<div class="maxheight">
									<img src="images/page1_img3.jpg" alt=""><a href="#">More</a>
								</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					<div class="grid_7">
						<h3>Welcome to Our Club</h3>
						<img src="images/page1_img4.jpg" alt="" class="img_inner fleft">
						<div class="extra_wrapper">
							<p>Follow the link to learn more about this <span class="color1"><a href="http://blog.templatemonster.com/free-website-templates/" rel="nofollow">free theme</a></span> produced by TemplateMonster. </p>
							<p>More <span class="color1"><a href="http://www.templatemonster.com/properties/topic/society-people/" rel="nofollow">themes of this kind</a></span> are to be found at TemplateMonster’s website</p>
							Vivamus at magna non nunc tristique rhoncuseri tym.
						</div>
						<div class="clear sep__1"></div>
						Gamus at magna non nunc tristique rhoncuseri tym. Aliquam nibh ante, egestas id dictum aterert commodo re luctus libero. Praesent faucibus malesuada cibuste. Donec laoreet metus id laoreet malesuada. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consectetur orci sed Curabitur vel lorem sit amet nulla ullamcorper fermentum. In vitae varius augue, eu consectetur ligula. Etiam dui eros, laoreet sit amet est vel, commodo venenatis eros.
					</div>
					<div class="grid_4 prefix_1">
						<h3>Latest News</h3>
						<div class="news">
							<time datetime="2014-01-01">14<span>MAR</span></time>
							<div class="extra_wrapper">
								<p class="color1"><a href="#">Magna non nunc tristique rhoncuseri </a></p>
								Aliquam nibh ante, egestas id dictum a, commodo re luctus liberaesenucibus malesuada cibuste.
							</div>
						</div>
						<div class="news">
							<time datetime="2014-01-01">28<span>MAR</span></time>
							<div class="extra_wrapper">
								<p class="color1"><a href="#">Tagna non nunc tristique rhoncuserr </a></p>
								Boliquam nibh ante, egestas id dictum a, commodo re luctus liberaesenucibus malesuada cibustew.
							</div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>		
<!--===============================Footer=================================-->
		<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="true">
        	<jsp:param name="bg-color" value="palegreen" />
        </jsp:include>
<!--=============================End of Footer==============================-->
	</body>
</html>

