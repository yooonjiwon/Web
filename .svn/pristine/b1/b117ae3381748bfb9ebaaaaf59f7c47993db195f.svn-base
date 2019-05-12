<%@page import="com.seoul.dto.TureBoardAttach"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="com.seoul.dto.TureBoard"%>
<%@ page import="com.seoul.dto.Member" %>
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
	$(function() {
		

	$('button#point').on('click', function(event) {
		event.preventDefault();// <a>의 기본 기능 수행 막는 명령
		alert("봉사시간이 적립되었습니다.")
		var guideid = $(this).attr('data-guideid');
		var guidetime = $(this).attr('data-guidetime')
		/* window.open('tureguideconnection.action?guideid='+guideid+'&guidetime='+guidetime,'a','width=850, height=1000', 'left=800', 'top=400'); */
			
		});
	
	
	});
	
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




	
	<!-- -------------------------------------------------------------------------------- -->
		

			
			<br /><br />
			
			<% TureBoard connections = 
				(TureBoard)request.getAttribute("connections"); %>	
				
			<% Member member = (Member)session.getAttribute("loginuser"); %>
			
		                	
		<div style="width:100%; height:300px; margin:0 auto;padding-top:50px">
			<div style="float:left; width:50%; height:300px; font-size:40pt;margin:0 auto;">tourist : <%= member.getMemberId() %></div>
			
			<div style="float:left; width:50%; height:300px; font-size:40pt;margin:0 auto;">guide : <%= member.getNickName() %></div>
			
			<div style="font-size:30pt">GuideTime : <%= connections.getTime() %> Hr</div>
			
		</div>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<button id="point" data-guideid='<%= member.getNickName() %>' data-guidetime='<%= connections.getTime() %>'>승인</button>
			

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
