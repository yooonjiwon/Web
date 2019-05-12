<%@page import="com.seoul.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!------------------------------- 로그인 후의 my page header ---------------------------------->

<script>
	/* When the user clicks on the button, 
	 toggle between hiding and showing the dropdown content */
	function myFunction() {
		document.getElementById("myDropdown").classList.toggle("show");
	}

	// Close the dropdown if the user clicks outside of it
	window.onclick = function(e) {
		if (!e.target.matches('.dropbtn')) {
			var myDropdown = document.getElementById("myDropdown");
			if (myDropdown.classList.contains('show')) {
				myDropdown.classList.remove('show');
			}
		}
	}
</script>



<header>
	<div class="row-1">
		<div class="main">
			<div class="container_12">
				<div class="grid_12">
					<nav>
						<ul class="menu">
							<li><a href="index.jsp">About Us</a></li>
							<li><a href="/seoul/information/home3.action">Information</a></li>
							<li><a href="/seoul/seoulmate/list.action">Seoul mate</a></li>
							<li><a href="turelist.action">TureList</a></li>
							<li><a href="/seoul/contacts/contactslist.action">Contacts</a></li>
						</ul>
					</nav>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>


	<div class="row-2">
		<div class="main">
			<div class="container_12">
				<div class="grid_9">
					<h1>
						<a class="logo" href="/seoul/index.action">hello<strong>♡</strong>seoul
						</a>

					</h1>
				</div>
				<div class="grid_3"></div>

			</div>
			<div class="clear"></div>
		</div>
	</div>



	<div class="row-3">
		<div class="main">
			<div class="container_12">
				<div class="grid_12">
					<div class="container">

						<% Member member = (Member)session.getAttribute("loginuser"); %>
						<% if (member == null) { %>

						<% } else { %>
						<a href="/seoul/account/logout.action">로그아웃</a> 
						<a href="#" class="dropbtn">문의</a> 
						<a href="#" class="dropbtn">후기</a> 
						<a href="#" class="dropbtn">봉사시간조회</a> 
						<a href="#" class="dropbtn">나의신청</a>
						<a id="memberedit" href="/memberupdate.action" class="active">프로필수정</a>
						<div class="dropdown">

							<% } %>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>


</header>




