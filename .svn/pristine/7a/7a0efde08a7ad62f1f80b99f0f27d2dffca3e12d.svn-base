<%@page import="com.seoul.dto.Member"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>
 
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<!--  -->
	<link rel="stylesheet" href="/SRC2/rangecalendar/css/normalize.css">
	
	<!--  -->
	<style type="text/css">
/******************************************* Dropdown Button ******************************************************/
.handropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.handropdown {
    position: relative;
    display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.handropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

/* Links inside the dropdown */
.handropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* Change color of dropdown links on hover */
.handropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.handropdown:hover .handropdown-content {
    display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.handropdown:hover .handropbtn {
    background-color: #3e8e41;
}
	
/**************************************************************인풋타입*/	
	
	.success {
    background-color: #ddffdd;
    border-left: 6px solid #4CAF50;
}

/**************************************************************인풋타입*/	
	
	
	/*테이블*/
	table.type10 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    margin: 20px 10px;
}
table.type10 thead th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background: #e7708d;
    margin: 20px 10px;
}
table.type10 tbody th {
    width: 150px;
    padding: 10px;
}
table.type10 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
}
table.type10 .even {
    background: #fdf3f5;
}
	/*테이블*/
	
	/************************************달력*******************************************************/
	
	/**************************************달력**********************************************************/
	</style>
	<title>글쓰기</title>
	<jsp:include page="/WEB-INF/views/include/common.jsp" />
	<link rel="stylesheet" href="/seoul/css/han.css" type="text/css" media="screen">
	<script type="text/javascript">
	$(function() { //jQuery's main function
		
		
		$('a#write').on('click', function(event) {
			event.preventDefault();// <a>의 기본 기능 수행 막는 명령
			var mainimg = $('#mainimg').val();
			var subimg = $('#subimg').val();
			
			if( mainimg.length == 0 ){
				alert('메인이미지를 넣어주세요');
				
			}else if (subimg.length == 0){
				
				alert('서브이미지를 넣어주세요');
				
			}else{
				
				$('form#writeform').submit();
			}
			
			});
	
	
		$('a#a').on('click', function (event) {
			
			$('#scriptimg').attr('src','/seoul/images/a.jpg');
			$('#scripttext').text('동대문에 관한 설명입니다')
			$('#location').attr('value','동대문')
		});
		
		$('a#b').on('click', function (event) {
			
			$('#scriptimg').attr('src','/seoul/images/b.jpg');
			$('#scripttext').text('선정릉에 관한 설명입니다')
			$('#location').attr('value','강남/선정릉')
		});
		
		$('a#cc').on('click', function (event) {
			
			$('#scriptimg').attr('src','/seoul/images/c.jpg');
			$('#scripttext').text('명동에 관한 설명입니다')
			$('#location').attr('value','명동')
		});
		
		$('a#d').on('click', function (event) {
			
			$('#scriptimg').attr('src','/seoul/images/d.JPG');
			$('#scripttext').text('경복궁에 관한 설명입니다')
			$('#location').attr('value','경복궁')
		});
		
		$('a#e').on('click', function (event) {
			
			$('#scriptimg').attr('src','/seoul/images/e.jpg');
			$('#scripttext').text('광화문에 관한 설명입니다')
			$('#location').attr('value','광화문')
		});
		$('a#f').on('click', function (event) {
			
			$('#scriptimg').attr('src','/seoul/images/f.jpg');
			$('#scripttext').text('국립중앙박물관에 관한 설명입니다')
			$('#location').attr('value','국립중앙박물관')
		});
		
		$('a#1hr').on('click', function (event) {
			
			
			$('#time').attr('value','1')
		});
		
		$('a#2hr').on('click', function (event) {
			
			
			$('#time').attr('value','2')
		});
		
		$('a#3hr').on('click', function (event) {
	
	
			$('#time').attr('value','3')
		});

		$('a#4hr').on('click', function (event) {
	
	
			$('#time').attr('value','4')
		});
		
		
		//////////////////////////////////////////////////////////달력
	
		
		//////////////////달력/////////////////////////////////////
		
		
	});
	

	
	
	
	
	</script>	
	
	<!-- ------------------------달력------------------------------------- -->
	
	
	<!-- ------------------------달력---------------------------- -->
	
</head>

<body>






	
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		
		
		
		

		
		
		<div id="pageContainer" style="background-color:black;">
			<div class="bg-top-2">
                <div class="bg">
                    <div class="bg-top-shadow">
                       <div class="main">
                            <div style="margin: 0 auto; width:100%;height:1700px; background-color:white;">
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
		<br><br><br>
		
		<h3>1.Select Location/Time</h3>
		<div style="padding-top:25px;text-align:center">
		
		<div id="inputcontent">
		
		
		    <div id="inputmain">
		    <!--------------------------------------- 드롭다운버튼-------------------------  -->
	<div id="ddp" style="float:left; width:300px"> 
	
		<div class="handropdown" style="padding:30px 70px 10px 60px">
  		<button class="handropbtn">SelectLocation</button>
 	 	<div class="handropdown-content">
    <a id="a" href="#">동대문</a>
    <a id="b" href="#">강남/선정릉</a>
    <a id="cc" href="#">명동</a>
    <a id="d" href="#">경복궁</a>
    <a id="e" href="#">광화문</a>
    <a id="f" href="#">국립중앙박물관</a>
    
  		</div>
  		
		</div>
		    <!-- ---------------------------------------드롭다운버튼---------------------------------------- -->
		    <br><br><br><br><br><br><br><br><br><br><br><br><br>
		        <!--------------------------------------- 드롭다운버튼time-------------------------  -->
		<div class="handropdown" style=" padding:30px 50px 10px 60px">
  		<button class="handropbtn">SelectTime</button>
  		<div class="handropdown-content">
    <a id="1hr" href="#">1 hr</a>
    <a id="2hr" href="#">2 hr</a>
    <a id="3hr" href="#">3 hr</a>
    <a id="4hr" href="#">4 hr</a>

  		</div>
		</div>
		</div> 
		    <!-- ---------------------------------------드롭다운버튼---------------------------------------- -->
		    
				<div id="scriptaa" style="width:500px; height:500px; float:left;" >
				
				<img id="scriptimg" style="width:100%; height:300px; " src=""></img>
		   		<div id="scripttext" style="width:100%; height:200px;background-color:azure"></div>
		   		
		   		</div>
		   		
		   		
		   		
		        <div class="inputsubtitle"></div>
		        <form id="writeform" action="turewrite.action" method="post" enctype="multipart/form-data">
		        
		
		        
		     <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		    
		   
		     	<div style="float:left;padding:10px 10px 10px 200px">        
		        <input id="location" name="location" class="handropbtn" value="Location" style="text-align:center; width:200px; height:30px; "/>
		        </div>     
		        <div style="float:left; padding:10px 10px 10px 150px">
		        <input id="time" name="time" class="handropbtn" value="Time" style="text-align:center; width:100px; height:30px; "/>
		        </div>
	
		 		
		 		
		 		
	
		        <br><br><br><br><br><br><br>
<!-- 달력----------------------------------------------------------- -->	        
	

<!-- 달력----------------------------------------------------------- -->
		        <h3>2.Write text</h3>
		        <hr>
		        <br><br><br>
		        <table class="type10" style="margin:0 auto; font-size:15pt">
		            <tr>
		                <th>제목</th>
		                <td>
		                    <input type="text" name="title" style="width:280px; height:30px" />
		                </td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>
		                	<% Member member = (Member)session.getAttribute("loginuser"); %>
		                	<%= member.getMemberId() %>
		                	<!-- input type="hidden" : 서버로 전송하지만 브라우저에 표시되지 않는 요소 -->
		                	<input type="hidden" name="writer" value="<%= member.getMemberId() %>" >
		                </td>
		            </tr>
		            <tr>
		                <th>여권번호</th>
		                <td>
		                	<%= member.getPassNo() %>
		                	<!-- input type="hidden" : 서버로 전송하지만 브라우저에 표시되지 않는 요소 -->
		                	<input type="hidden" name="passno" value="<%= member.getPassNo() %>" >
		                </td>
		            </tr>
		             <tr>
		                <th>메인사진</th>
		                <td>		                    
		                    <input id="mainimg" type="file" 
		                    	name="attach">
		                </td>
		            </tr>
		            <tr>
		                <th>서브사진</th>
		                <td>		                    
		                    <input id="subimg" type="file" 
		                    	name="attach">
		                </td>
		            </tr>
		            <tr>
		                <th>날짜</th>
		                <td>		                    
		                    <input type="text" name="day" style="width:280px; height:30px" />
		                </td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td>		                    
		                    <textarea id="contenttext"
		                    	name="content" cols="76" rows="15"></textarea>
		                </td>
		            </tr>
		        </table>
		        
		        <br><br><br><br>
		        <div style="width:500px; margin:0 auto">
		        	<!-- <form>의 submit 수행 -->	        	
		        	<a class="handropbtn" id="write" href="#">글쓰기</a>
		        	&nbsp;&nbsp;
		        	<a class="handropbtn" href="turelist.action">목록보기</a>
		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	
</body>
</html>