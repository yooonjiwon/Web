<%@page import="com.dieat.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    

	<script type="text/javascript">
 	$(function() {
		$('#login-button').on('click', function(event) {			
			event.preventDefault();// <a>의 기본 기능 수행 막는 명령
			
			//1. 화면 갱신 방식 (동기 방식)
			//$('#login-form').submit();
			
			//2. 비동기 방식 (jQuery, Ajax 사용)
			var param = $('#login-form').serialize()
			alert(param);
			
			/* $.ajax({
				url : 'url',
				method : 'post',
				data : param,
				success : function(data, status, xhr) {
					$('#login-modal').modal({
						show : false
					});
					//javascript로 화면요소 변경
				},
				error : function(xhr, status, err) {
					alert('로그인 실패');
				}
			}); */

		});
		
        // 드롭다운 
        function myFunction() {
            document.getElementById("myDropdown").classList.toggle("show");
        }

        // 밖에서 클릭시 Dropdown이 닫힘.
        window.onclick = function(e) {
          if (!e.target.matches('.dropbtn')) {
            var myDropdown = document.getElementById("myDropdown");
              if (myDropdown.classList.contains('show')) {
                myDropdown.classList.remove('show');
              }
          }
        } 
        
	});
 	
	$(function() {
		$('#show-modal').on('click', function(event) {
			$('#login-modal').modal({
				show : true
			});
			event.preventDefault();
		});
	});
	</script>


   <header>    
   
   	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="display: none;">
		<div class="modal-dialog">
			<div class="loginmodal-container">
				<h1>Login to Your Account</h1>
				<br>
				<form id="login-form">
					<input type="text" name="user" placeholder="Username"> 
					<input type="password" name="pass" placeholder="Password"> 
					<input type="submit" name="login" class="login loginmodal-submit" value="Login">
					<input type="submit" name="login" class="login loginmodal-submit" value="Login" id="login-button">
				</form>

				<div class="login-help">
					<a href="#">Register</a> - <a href="#">Forgot Password</a>
				</div>
			</div>
		</div>
	</div>
   
   
   
   
   
   
				<div class="container_12">
					<div class="grid_12">
						<div class="socials">
							<a href="#" class="fa fa-twitter"></a>
							<a href="#" class="fa fa-facebook"></a>
							<a href="#" class="fa fa-google-plus"></a>
							<a href="#" class="fa fa-instagram"></a>
						</div>
						
						<h1>
							<a href="/dieat/home.action">
								<img src="/dieat/resources/images/logo.png" alt="Your Happy Family">								
							</a>
						</h1>	
						
						<div class="menu_block">
							<nav class="horizontal-nav full-width horizontalNav-notprocessed">
								<ul class="sf-menu">
									<li class="current"><a href="home.action">Home</a></li>
									<li><a href="/dieat/foodinfo/menupage.action">식단</a></li>
									<div class="dropdown">
                                    <li class="dropbtn" onclick="myFunction()"><a href="/dieat/workout/workoutlist.action">Workout</a></li>
                                    <div class="dropdown-content" id="myDropdown">
                                      <a href="/dieat/workout/workoutlist.action">운동방법</a>
                                      <a href="#">홈트레이닝</a>
                                    </div>
                  			       </div>
									<li style="margin-left:33px"><a href="#">스케줄러</a></li>										
									<li><a href="/dieat/exercise/weight-list.action">칼로리</a></li>
									<li><a href="/dieat/gym/gym.action">GYM</a></li>
									<li><a href="/dieat/board/list.action">커뮤니티</a></li>	
									
									<c:choose> 
									<c:when test="${ loginuser eq null }">
									<!-- <li id="loginbtn" style="padding:0 0 0 50px; font-size:14px"><a href="/dieat/account/login.action">로그인</a></li> -->
									<li style="padding:0 0 0 40px; font-size:14px">
									<a href="#" data-toggle="modal" data-target="#login-modal">로그인</a></li>
									<li style="font-size:14px">
									<a href="/dieat/account/register.action">회원가입</a></li>
									</c:when>
									<c:otherwise>
									<li id="btn_submit" style="padding:0 0 0 20px; font-size:13px"><a href="/dieat/account/point.action">포인트</a></li>
									<li class="init" style="font-size:13px"><a href="/dieat/account/mypage.action">${ loginuser.id }</a></li>
									<li style="font-size:13px"><a href="/dieat/account/logout.action">로그아웃</a></li>
									</c:otherwise>	
									</c:choose>			
								</ul>
							</nav>
							<div class="clear"></div>
							
						</div>
					</div>
					<div class="clear"></div>
				</div>

			</header>

