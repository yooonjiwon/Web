<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="kr">
	<head>
		<title>Home</title>
		<jsp:include page="/WEB-INF/views/include/css-script.jsp"></jsp:include>
		
	</head>
	<body class="page1" id="top">
		<div class="main">
	
	<jsp:include page="/WEB-INF/views/include/header.jsp" flush="true">
    <jsp:param name="bg-color" value="palegreen" />
    </jsp:include>
<!--==============================Content=================================-->
					
				
			
					
					<div class="container_12">
					<div style="text-align:center; height:500px;">
						<h2>MY PAGE</h2><br><br>
						<a href="loginconfirm.action">
						<img src="/dieat/resources/images/Mypage_Membership.jpg"></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="myboard.action">
						<img src="/dieat/resources/images/Mypage_Myboard.jpg"></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="register.action">
						<img src="/dieat/resources/images/FoodMenu/img_foodlist"></a>&nbsp;&nbsp;&nbsp;&nbsp;
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

