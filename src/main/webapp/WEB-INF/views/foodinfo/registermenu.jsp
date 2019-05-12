﻿<%@page import="java.util.List"%>
<%@page import="com.dieat.dto.FoodInfo"%>
<%@page import="com.dieat.dao.FoodInfoDao"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

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
						<h3>식품 정보 등록</h3>
						<div class="text1">저희 DB에 없는 식품의 영양 정보를 등록해주세요.</div>
						<p>이것은 당신에겐 작은 도움이지만 인류에게 큰 발전이 됩니다.<br><br>
                        왼쪽에 양식이 있습니다!</p>						
						The Company Name Inc. <br>
						9870 St Vincent Place, <br>
						Glasgow, DC 45 Fr 45. <br>
						Telephone: +1 800 603 6035 <br>
						FAX: +1 800 889 9898 <br>
						E-mail: <span class="color1"><a href="#">mail@demolink.org</a></span>
					</div>
					<div class="grid_6 prefix_1">
						<h3>식단 등록 양식</h3>
						<form id="registermenuform" action="registermenu.action" method="post">
							<div class="success_wrapper">
								<div class="success-message">Contact form submitted</div>
							</div>
                            
							<input type="text" id="memberid" name="memberid" placeholder="작성자" data-constraints="@Required"/>
							<span class="empty-message">*This field is required.</span><br>
							<%
							FoodInfoDao dao = new FoodInfoDao();
							List<FoodInfo> foods = null;
							foods = dao.selectFoodNameList();
							%>
							<select name="foodSelect" id="foodname">
							<option value="">식품 선택
							<%
								for (int i = 0; i < foods.size(); i++) {
									FoodInfo food = (FoodInfo) foods.get(i);
							%>
							
							<option name="<%=food.getFoodName()%>" value="<%=food.getFoodName()%>"><%=food.getFoodName()%>
								<%
									}
								%>
							
						</select>
							<input type="text" id="gram" name="gram" placeholder="양" data-constraints="@Required"/>
							<span class="empty-message">*This field is required.</span><br>
							<input type="text" id="meal" name="meal" placeholder="식사 구분" data-constraints="@Required"/>
							<span class="empty-message">*This field is required.</span><br>
							<div>
								<div class="clear"></div>
								<div class="btns">
									<a href="#" id="clear" name="clear" data-type="reset" class="btn">Clear</a>
									<a href="#" id="submit" name="submit" data-type="submit" class="btn">Submit</a>
								</div>
							</div>
						</form>
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

