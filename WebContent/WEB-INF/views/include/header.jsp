<%@page import="com.seoul.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

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
                                <li><a href="/seoul/index.jsp">About Us</a></li>
                                <li><a href="/seoul/information/home3.action">Information</a></li>
                                <li><a href="/seoul/seoulmate/list.action">Seoul mate</a></li>
                                <li><a href="/seoul/turelist.action">TourList</a></li>
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
                            <a class="logo" href="/seoul/index.action">hello<strong>♡</strong>seoul</a>
                           
                        </h1>
                    </div>
                    <div class="grid_3">
 
                     </div>

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
                             <a href="/seoul/account/login.action" class="dropbtn">Login</a>
                             <a href="/seoul/account/signup.action" class="dropbtn">Signup</a>
                     		<% } else { %>
                     		<div class="dropdown">
                     		<button class="dropbtn" onclick="myFunction()">
                     		Hello, <%= member.getName() %>님 ♥</button>
                     		<div class="dropdown-content" id="myDropdown">
						      <a href="/seoul/account/memberupdate.action">프로필수정</a>
						      <a href="#">나의 신청</a>
						      <a href="#">봉사시간조회</a>
						      <a href="#">쿠폰</a>
						      <a href="#">후기</a>
						      <a href="#">문의</a>
						      <a href="/seoul/account/logout.action">로그아웃</a>
					  		</div>
                     	    <% } %>
                  			</div>
                  		</div>
                    </div>
                </div>
             </div>
                <div class="clear"></div>
         </div>
      

    </header>
    		
		
		
		
		