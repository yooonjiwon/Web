﻿<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="kr">
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

		</script>

	</head>
	<body class="page1" id="top">
		<div class="main">
	
	<jsp:include page="/WEB-INF/views/include/header.jsp" flush="true">
    <jsp:param name="bg-color" value="palegreen" />
    </jsp:include>
<!--==============================Content=================================-->
					
				
			
					
					<div class="container_12">
					<div style="text-align:center; height:500px;">
						<h2>식단</h2><br><br>
						<a href="loginconfirm.action">
						<img src="/dieat/resources/images/Mypage_Membership.jpg"></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="registermenu.action">
						<img src="/dieat/resources/images/FoodMenu/img_regist_menu.JPG"></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="foodlist.action">
						<img src="/dieat/resources/images/FoodMenu/img_foodlist.JPG"></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="registerfood.action">
						<img src="/dieat/resources/images/FoodMenu/img_foodlist.JPG"></a>&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
					</div>
					</div>
						
					
					
					
		
<br><br><br>
<!--==============================Content=================================-->
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="true">
        <jsp:param name="bg-color" value="palegreen" />
        </jsp:include>
		<!-- end of footer -->
	</body>
</html>

