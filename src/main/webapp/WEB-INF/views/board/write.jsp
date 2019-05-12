<%@page import="com.dieat.dto.Member"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>
    	 
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>글쓰기</title>
	<jsp:include page="/WEB-INF/views/include/css-script.jsp" />
		<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
		<script type="text/javascript">
		
	$(function() { //jQuery's main function
		$('a#write').on('click',function(event){
			$('form#writeform').submit();
			event.preventDefault(); //<a>의 기본 기능 수행 막는 명령
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
	<form id="writeform" action="write.action"
		method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" style="widt:280px" />
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<%-- <% Member member = (Member)session.getAttribute("loginuser"); %>
					<%= member.getId() %>
					<input type="hidden" name="writer" value="<%=member.getId() %>"> --%>
					<input type="text" name="writer">
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="attach">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea
						name="content" cols="76" rows="15"></textarea>					
				</td>
			</tr>	
		</table>
		<div class="buttons">
		<!-- <form>의 submit 수행 -->
		<a id="write" href="#">글쓰기</a>
		&nbsp;&nbsp;
		<a href="/dieat/board/list.action">목록보기</a>
		</div>
		</form>
	</div>
</div>
</div>

</div>

</body>
</html>