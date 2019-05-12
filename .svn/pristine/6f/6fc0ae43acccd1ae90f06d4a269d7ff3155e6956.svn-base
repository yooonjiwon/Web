<%@page import="com.seoul.dto.Guide"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
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
	$(function() {
		$('a#reply').on('click', function(event) {
			$('form#replyform').submit(); //writeform을 서버로 전송처리
			event.preventDefault(); //<a>의 기본기능(화면 리프레시) 수행을 막는 명령
		});
	});
	
	</script>
</head>
<body>

	<div id="pageContainer">
	
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시판 글 쓰기</div>
		        <form id="replyform" action="reply.action" method="post">
		        <%-- 대상 글의 글번호를 hidden 형식으로 저장 --%>
		        <input type="hidden" name="gub_boardno" value='<%= request.getAttribute("gub_boardno") %>'>
		        <% Guide guide = (Guide)request.getAttribute("guide"); %> 
		        <table>
		            <tr>
		                <th>제목</th>
		                <td>
		                    <input type="text" name="gub_title" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>
<%-- 		                	<% Member member = (Member)session.getAttribute("loginuser"); %>
		                	<%= member.getMemberId() %> --%>
		                	<!-- hidden : 서버로 전송하지만 브라우저에 표시되지 않는 요소 -->
		                	<input type="text" name="gub_writer" value="<%= guide.getGub_Writer() %>">
		                </td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td>		                    
		                    <textarea 
		                    	name="gub_intro" cols="76" rows="15"></textarea>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	<!-- <form>의 submit수행 -->	        	
		        	<a id="reply" href="#">댓글쓰기</a>
		        	&nbsp;&nbsp;
		        	<a href='/seoul/seoulmate/detail.action?gub_boardno=<%= request.getAttribute("gub_boardno") %>'>취소</a>
		        	&nbsp;&nbsp;
		        	<a href="/seoul/list.action">목록보기</a>
		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>
	</div>

</body>
</html>