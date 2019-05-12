﻿<%@page import="com.seoul.dto.TureBoardAttach"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="com.seoul.dto.TureBoard"%>
<%@ page import="com.seoul.dto.TureMember" %>
<%@page import="java.util.List"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>게시물 목록</title>
	<jsp:include page="/WEB-INF/views/include/common.jsp" />
	<style>
.procard {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
  border:soild 1px;
  
  
}

.procontainer {
  padding: 0 16px;
}

.procontainer::after {
  content: "";
  clear: both;
  display: table;
}

.protitle {
  color: grey;
  font-size: 18px;
}

#pro {
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

proa {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

#pro:hover, proa:hover {
  opacity: 0.7;
}
</style>
	<script type="text/javascript">
	$(function() { //jQuery's main function
		$('#write').on('click', function(event) {
			location.href = 'write.action';
		});
	
		$('a[id^=d]').on('click', function(event){
			
			var boardno = $(this).attr('data-boardno');
			var pageno = $(this).attr('data-pageno');
			window.open('turedetail.action?boardno='+boardno+'&pageno='+pageno,'a','width=850, height=1000', 'left=800', 'top=400');
			event.preventDefault()
		});
	});
	///////////////////////////////////////////////////////
	 

	 
	  /////////////////////////////////////////////////


	
	
	</script>
   
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp" />
<link rel="stylesheet" href="/seoul/css/han.css" type="text/css" media="screen">	
       
        
	<div id="pageContainer" style="background-color:black;">
	<div class="bg-top-2">
                <div class="bg">
                    <div class="bg-top-shadow">
                       <div class="main">
                            <div style="margin: 0 auto; width:100%; background-color:white;">
		<div style="text-align:center">
		
				<!----------------------------------------------------------------------------  -->
	
<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'London')" ><a style="font-color:white;text-decoration: none" href="/seoul/turelist.action">RequestBoardList/Write</a></button>
  <button class="tablinks" onclick="openCity(event, 'Paris')" ><a style="font-color:white;text-decoration: none" href="/seoul/turechecklist.action">MyCheckList</a></button>
  <button class="tablinks" onclick="openCity(event, 'Tokyo')"><a style="font-color:white;text-decoration: none" href="/seoul/myconnect.action">Connection</a></button>
</div>



<script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
</script>
	
	<!-- -------------------------------------------------------------------------------- -->
		
			
			
			
			<br /><br />
			
			<% List<TureBoard> boards = 
				(List<TureBoard>)request.getAttribute("boards"); %>	
				
			
			<table style="margin:0 auto;font-family: arial; padding:10px 10px 10px 10px;">
			
			
			<tr style="padding:15px 15px 15px 15px">
			
			<% for (TureBoard board : boards) { %>
			<td class="procard" style="padding:7px 7px 7px 7px;border-radius: 1em ;">
			<div id="contentbox" style="width:300px; height:500px; background-color:azure;border-radius: 1em "><!-- <input type="hidden"><%= board.getBoardNo() %>  -->
			
			<div id="photo" style="width:100%; height:200px; margin:0 auto;">
			<% if (board.getAttachments().size() > 0) { %>			
			<img style="width:100%; height:200px; margin:0 auto;border-top-left-radius: 1em; border-top-right-radius: 1em;"src="/seoul/files/<%= board.getAttachments().get(0).getSavedFileName() %>">
			<% } else { %>
			<img src="/seoul/files/noimage.jpg">
			<% } %>
			</div>
			<% if(board.isDelated()){ %>
			<span id="deleted-message">[삭제된 글]</span>
			<% }else{ %>
			
			<div id=""  style="width:100%; height:35px; margin:0 auto; background-color:floralwhite; "><p style="font-size:20pt;padding-top:5px;"><%= board.getWriter() %></p></div>
			
			<p style="font-size:16pt;padding-top:40px"><%= board.getTitle() %></p><!-- boarno가지고 detail.action으로 이동 --><!-- request = sevlet에서 넘겨주는 변수 읽을때 -->
			<p style="font-size:16pt;padding-top:9px">TureDay : <%= board.getDay() %></p>
			<% } %>
			<div id="" style="width:100%; height:60px; margin:0 auto; font-size:15pt">location : <%= board.getLocation() %>/ Time : <%= board.getTime() %> hr</div>
			
			<button id="pro"><a id="d<%= board.getBoardNo()%>" href="#" data-boardno='<%= board.getBoardNo()%>' data-pageno='<%= request.getAttribute("pageno") %>' style = 'text-decoration:none; vertical-align:middle;'>Contact</a></button>
			<div id="" style="width:100%; height:35px; margin:0 auto; background-color:floralwhite;"><p style="font-size:15pt;padding-top:9px;">등록일 : <%= board.getRegDate() %><p></div>
			
			</div>
			</td>
			<% } %>
			
		
			
			<!-- <script>document.write("</td>");</script>  -->
			<!-- </td>  -->
			
			</tr>
			
			
			
			</table>
			<br><br><br><br>
			<!-- -----------------------------------------------------------------------------------------------------  -->
		</div>
		<br><br><br><br><br>

		</div>
		
		
					  </div>
					  
                  </div>
             </div>
         </div>
         
	</div>
	<br><br>
			

</body>
</html>
