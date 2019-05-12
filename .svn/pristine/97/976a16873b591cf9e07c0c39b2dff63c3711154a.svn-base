<%@page import="com.seoul.dto.TureBoard"%>
<%@page import="com.seoul.dto.Member"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>
 
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>글쓰기</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/styles/input2.css" />
	<style type="text/css">
	a { text-decoration: none }
	</style>
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript">
	$(function() { //jQuery's main function
		$('a#update').on('click', function(event) {
			$('form#updateform').submit();
			
			event.preventDefault();// <a>의 기본 기능 수행 막는 명령
		});
	});
	</script>	
</head>
<body>

	<div id="pageContainer">
	
		
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시판 글 수정</div>
		        <form id="updateform" action="tureupdate.action" method="post">
		        <% TureBoard board = (TureBoard)request.getAttribute("board"); %>
		        <table>
		        	<tr>
		                <th>글번호</th>
		                <td><% board.getBoardNo(); %>
		                    <input type="hidden" name="boardno"  value = "<%= board.getBoardNo() %>"/>
		                </td>
		            </tr>
		            <tr>
		                <th>제목</th>
		                <td>
		                    <input type="text" name="title" style="width:280px"  value = "<%= board.getTitle() %>"/>
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
		                <th>내용</th>
		                <td>		                    
		                    <textarea 
		                    	name="content" cols="76" rows="15"><%= board.getContent() %></textarea>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	<!-- <form>의 submit 수행 -->	        	
		        	<a id="update" href="#">글수정</a>
		        	
		        	&nbsp;&nbsp;
		        	<a href="/seoul/turedetail.action?boardno=<%= board.getBoardNo()%>&pageno=<%=request.getAttribute("pageno")%>">취소</a>
		        											<!-- boardno도 가져가는 이유:일단 수정으로 갔다가 다시 디테일로 온 뒤 목록보기로 넘어가려면 계속 pageno를 가지고 있어야함 -->
		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>
	</div>

</body>
</html>