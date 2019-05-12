<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="kr">
	<head>
		<title>Home</title>
		<jsp:include page="/WEB-INF/views/include/css-script.jsp" />
		
		
		<script>
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
		</script>
		<!--[if lt IE 8]>
			<div style=' clear: both; text-align:center; position: relative;'>
				<a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
					<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
				</a>
			</div>
		<![endif]-->
		<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<link rel="stylesheet" media="screen" href="css/ie.css">
		<![endif]-->
	</head>
	<body class="page1" id="top">
		<div class="main">
	
		<jsp:include page="/WEB-INF/views/include/header.jsp" flush="true">
       <jsp:param name="bg-color" value="palegreen" />
       </jsp:include>
<!--==============================Content=================================-->
			<div class="slider_wrapper">
				<div id="camera_wrap" class="">
					<div data-src="/dieat/resources/images/slide.jpg">
						<div class="caption fadeIn">
							Run for Your Health
						</div>
					</div>
					<div data-src="/dieat/resources/images/slide1.jpg">
						<div class="caption fadeIn">
							Fast as Wind
						</div>
					</div>
					<div data-src="/dieat/resources/images/slide2.jpg">
						<div class="caption fadeIn">
							Never Stop
						</div>
					</div>
				</div>
			</div>
			<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - April 21, 2014!</div>
				<div class="container_12">
					<div class="grid_12">
						<h2 class="center">The Next Marathon</h2>
						<div class="count_wrap">
							<div id="counter"></div>
							<div class="clear"></div>
							<a href="#">Join Us</a>
						</div>
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
					<div class="grid_12">
						<div class="hor_separator"></div>
						<h3 class="head1 center">We Will Never Stop</h3>
					</div>
					<div class="clear"></div>
					<div class="grid_12">
						<div id="grid" class="main">
							
								<img src="images/page1_img10.jpg" />
							</div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="true">
       <jsp:param name="bg-color" value="palegreen" />
       </jsp:include>
	<!-- end of footer -->
	</body>
</html>

