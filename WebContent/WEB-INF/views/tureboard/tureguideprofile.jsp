\<%@page import="com.seoul.dto.TureBoardComment"%>
<%@page import="com.seoul.dto.TureBoardAttach"%>
<%@page import="com.seoul.dto.Member"%>
<%@page import="com.seoul.dto.TureCommenteCount"%>
<%@page import="com.seoul.dto.TureBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- jstl core사용 -->    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><!-- jstl function사용구문 -->

<!DOCTYPE html>

<html>
<head>

	<meta charset="utf-8" />
	<title>글쓰기</title>

	<style>

	.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.container {
  padding: 0 16px;
}

.container::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
  font-size: 18px;
}

button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}



	</style>
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript">
	
	<% if (request.getAttribute("connect") !=null) {%>
	window.close()
	<%}%>
	
	$(function() {
	
		$('a#contact').on('click', function(event) {
			event.preventDefault();// <a>의 기본 기능 수행 막는 명령
				alert("등록되었습니다.")
				$('form').submit();
				
		});
	})
	</script>
	
</head>
<body>
<% if (request.getAttribute("connect") ==null) {%>
<br><br><br><br>
<div class="card">
<% Member guideProfile = (Member)request.getAttribute("guideId"); %>
<% String listId = (String)request.getAttribute("listId"); %>
<div class="container">
	<c:set var="gender" value="<%= guideProfile.getGender() %>"/>
	<c:if test="${ gender eq 'male' }">
  	<img src="./images/man.png" style="width:100%">
  	</c:if>
  	<c:if test="${ gender eq 'female' }">
  	<img src="./images/women.png" style="width:100%">
  	</c:if>
    <h1><%= guideProfile.getMemberId() %></h1>
    <p class="title"><%= guideProfile.getPhone() %></p>
    <p><%= guideProfile.getGender() %></p>
    <p><%= guideProfile.getEmail() %></p>
   	<button>Contact</a></button>
   	
	<form action="tureguideconnection.action" method="post">
		<input name="guideid" value="<%= guideProfile.getMemberId() %>" />
		<input name="tourlistid" value="${ listid }"/>
		
		<a id="contact" href="#">contact</a>
    </form>
  </div>
</div>
	
		<% }%>         
</body>
</html>