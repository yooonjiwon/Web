<%@page import="com.dieat.dto.GymDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>
		 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Home</title>
		<meta charset="utf-8">
		<meta name="format-detection" content="telephone=no" />
		<link rel="icon" href="images/favicon.ico" />
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="/dieat/resources/styles/main.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/countdown.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/style_common.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/style4.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/camera.css" />
		<link rel="stylesheet" href="/dieat/resources/styles/style.css" />
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
		<script src="/dieat/resources/js/jquery.js"></script>
		<script src="/dieat/resources/js/jquery-migrate-1.2.1.js"></script>
		<script src="/dieat/resources/js/script.js"></script>
		<script src="/dieat/resources/js/superfish.js"></script>
		<script src="/dieat/resources/js/jquery.ui.totop.js"></script>
		<script src="/dieat/resources/js/jquery.equalheights.js"></script>
		<script src="/dieat/resources/js/jquery.mobilemenu.js"></script>
		<script src="/dieat/resources/js/camera.js"></script>
		<!--[if (gt IE 9)|!(IE)]><!-->
		<script src="/dieat/resources/js/jquery.mobile.customized.min.js"></script>
		<!--<![endif]-->
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
					
					<div class="container_12">
						<a href="gym.action">전국 헬스장</a>&nbsp;&nbsp;&nbsp;<a href="gym.action">후기</a>									
					</div>	
			
					
					<div class="container_12">
					<div class="grid_12">
						<h3>전국 헬스장</h3>
						<img src="images/page1_img4.jpg" alt="" class="img_inner fleft">
						<div class="extra_wrapper">
						<p>Follow the link to learn more about this <span class="color1"><a>free theme</a></span> produced by TemplateMonster. </p>
						<p>More <span class="color1"><a>themes of this kind</a></span> are to be found at TemplateMonster’s website</p>
						Vivamus at magna non nunc tristique rhoncuseri tym.
						</div>
						<div class="clear sep__1"></div>
						Gamus at magna non nunc tristique rhoncuseri tym.
					</div>
					
					<div class="grid_12">
						<div class="hor_separator"></div>
					</div>
				
					<c:forEach var="gym" items="${ gymlist }">
				            <div class="grid_4">
				               <div class="box">
				                  <p class="date fc-bold fc-grey3">
				                 <div class="box_title">${ gym.picture }</div>
				                  <!--  <h4 class="heading2 regular fc-blue">
				                     <a href="detail.action?gub_boardno=${ guide.gub_BoardNo }&pageno=${ pageno }"
				                      class="regular fc-blue">${ guide.gub_Title }</a></h4>
				                  <span class="button-mail">
				                     <img src="../images/ico-mail.png" alt="이메일 보내기" />
				                  </span>
				                  -->
				               </div>
				            </div>
         			</c:forEach>
         			
				<div class="grid_12">
					<div class="hor_separator"></div>
				</div>
					
				</div>
			</div>
				
				
				
				

<!--==============================Content=================================-->
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="true">
        <jsp:param name="bg-color" value="palegreen" />
        </jsp:include>
		<!-- end of footer -->
	</body>
</html>

