<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.dieat.dto.Workout"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="kr">

	<head>
		<title>Home</title>
		<meta charset="utf-8">
		<meta name="format-detection" content="telephone=no" />

		<jsp:include page="/WEB-INF/views/include/css-script.jsp" />

		<link rel="stylesheet" href="/dieat/resources/styles/buttons.css">
	   
	   	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
		<script type="text/javascript">
			$(function() { //jQuery's main function
				$('#write').on('click', function(event) {
					location.href = 'workout/workoutwrite.action';
				});
			});
		</script>

</head>
		<body>
		
			<jsp:include page="/WEB-INF/views/include/header.jsp" />

			<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - April 21, 2014!</div>
				<div class="container_12">
					<div class="grid_2">
						<h3>Body Part</h3>
						<ul class="list1 color1">
							<li><a href="#">등</a></li> <hr class="style1">
                            <li><a href="#">가슴</a></li> <hr class="style1">
							<li><a href="#">어깨</a></li> <hr class="style1">
							<li><a href="#">이두</a></li> <hr class="style1">
							<li><a href="#">삼두</a></li> <hr class="style1">
							<li><a href="#">허리</a></li> <hr class="style1">
                            <li><a href="#">복근</a></li> <hr class="style1">
							<li><a href="#">허벅지</a></li> <hr class="style1">
							<li><a href="#">종아리</a></li> <hr class="style1">
						</ul>
						
					</div>
					<div class="grid_8">
                        <br>
                        <button class="button" style="vertical-align:middle; float:right"><span>부위별</span></button>
                        <button class="button" style="vertical-align:middle; float:right"><span>체형별</span></button>
                        <button class="button" style="vertical-align:middle; float:right"><span>분할법</span></button>
                        
                        <input type="text" name="search" placeholder="Search..">
<br>
<br>
						<button class="button" id="write" style="background-color:rgb(116, 105, 87)">
						<a href="/dieat/workout/workoutwrite.action">
						글쓰기</a></button>
						<%-- <% List<Workout> workouts = (List<Workout>)request.getAttribute("workouts"); %>		 --%> 
						
						<%-- <% for(Workout workout : workouts) { %> --%>
						<div class="posts">
                        <a class = "post" href = "workoutdetail.action">
                            <div class="post-thumbnail">
                                <img src="images/page2_img1">
                            </div>
                            <div class="post-info">
                            	<td stlye="visibility: hidden">
                            	<%-- <%= workout.getBoardNo() %> --%>
                            	</td>
                            	<%-- <% for (int i = 0; i < workout.getDepth(); i++) { %>
                            	<% } %> --%>
                                <div class="title">
	                           <%--  <%= workout.getTitle() %> --%>
                                </div>
                                <div class="date-and-count">
                                <%-- <%= workout.getRegDate() %> | <%= workout.getReadCount() %> --%>
                                </div>
                                <div class="description">
                                <%-- <%= workout.getContent() %> --%>
                                </div>
                            </div>
                        </a>
                    </div>
						<%-- <% } %> --%>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>

		<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="true">
		
        <jsp:param name="bg-color" value="palegreen" />
        </jsp:include>
		<!-- end of footer -->
	</body>
</html>

