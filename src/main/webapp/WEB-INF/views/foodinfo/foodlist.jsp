<%@page import="java.util.List"%>
<%@page import="com.dieat.dto.FoodInfo"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
	<head>
		<title>FoondInfoRegister</title>
		<meta charset="utf-8">
		<meta name="format-detection" content="telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="/dieat/resources/styles/form.css">
		<link rel="stylesheet" href="/dieat/resources/styles/style.css">
		<script src="/dieat/resources/js/jquery.js"></script>
		<script src="/dieat/resources/js/jquery-migrate-1.2.1.js"></script>
		<script src="/dieat/resources/js/cript.js"></script>
		<script src="/dieat/resources/js/superfish.js"></script>
		<script src="/dieat/resources/js/jquery.ui.totop.js"></script>
		<script src="/dieat/resources/js/jquery.equalheights.js"></script>
		<script src="/dieat/resources/js/jquery.mobilemenu.js"></script>
		<script src="/dieat/resources/js/TMForm.js"></script>
		<script>
		  $(document).ready(function(){
			
			});
		  $(function() { //jQuery's main function
				$().UItoTop({ easingType: 'easeOutQuart' });
		  
				$('a#submit').on('click', function(event) {
					$('form#registerform').submit();
					alert("정보 등록이 완료되었습니다.")
					event.preventDefault();// <a>의 기본 기능 수행 막는 명령
				});
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
			<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - April 21, 2014!</div>
				<div class="container_12">
					<div class="grid_12">
						<h3> </h3>
					</div>
					<div class="clear"></div>
					<div class="grid_5">						
								
						<br>
						<a style="padding-left:50px" href="registerfood.action">
						<img src="/dieat/resources/images/FoodMenu/img_foodlist.JPG"></a>
					
						</div>
						<div class="grid_6 prefix_1">
						<h3>식품 등록 리스트</h3>						
							<div class="success_wrapper">
								<div class="success-message">Contact form submitted</div>
							</div>                            
							<div style="padding-top:25px;text-align:center">										
							<table border="1" align="center">
							<tr style="background-color:beige;height:25px">
								<th style="width:50px">번호</th>
								<th style="width:150px">식품명</th>
								<th style="width:60px">열량</th>
								<th style="width:60px">탄수화물</th>
								<th style="width:60px">단백질</th>
								<th style="width:60px">지방</th>
								<th style="width:60px">당</th>
								<th style="width:60px">나트륨</th>
							</tr>
							<c:forEach var="food" items="${ foods }">
	          				<tr style="height:25px">
	                  		<td style='text-align:center'>${ food.foodNo }</td>
	                  		<td style='text-align:center'>${ food.foodName }</td>
	                  		<td style='text-align:center'>${ food.kcal }Kcal</td>
	                  		<td style='text-align:center'>${ food.carbo }g</td>  
	                  		<td style='text-align:center'>${ food.protein }g</td>  
	                  		<td style='text-align:center'>${ food.fat }g</td>
	                  		<td style='text-align:center'>${ food.sugars }g</td>
	                  		<td style='text-align:center'>${ food.natrium }g</td>  	                  		  			
	                  		</tr>	
	        				</c:forEach>						
							</table>
							<br><br>
							<%= request.getAttribute("pager").toString() %>					
							</div>						
						</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="true">
       <jsp:param name="bg-color" value="palegreen" />
       </jsp:include>
	<!-- end of footer -->
	</body>
</html>

