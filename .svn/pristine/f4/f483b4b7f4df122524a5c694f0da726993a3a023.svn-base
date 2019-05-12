<%@page import="com.seoul.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8" />
<title>메일보내기</title>
<link rel="Stylesheet" href="/demoweb/styles/default.css" />
<link rel="Stylesheet" href="/demoweb/styles/input2.css" />
  <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
 		<script type="text/javascript">
 		
 		$(function closeWin() {  
 			$('a#closewindow').on('click', function(event) {
 				self.close();  
 			}); 
 		});
 		</script>
 		


</head>
<body>

	<div id="pageContainer">


		<center>
			<h1>신청가이드에게 메일보내기</h1>
			<form method="post" action="sendmail.action">
			
				<table>
					<tr>
						<td>받는이</td>
						<td><input type="text" name="to" placeholder="문의할 가이드의 Email을 입력해주세요." style="width:300px;"></td>
					</tr>
					<tr>
						<td>연락처</td>
						<td><input type="text" name="to" placeholder="가이드에게 연락받을 연락처를 입력해주세요." style="width:300px;"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="subject" placeholder="제목을 입력해주세요." style="width:300px;"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="content" rows=10 cols=30 placeholder="문의할 사항을 입력해주세요." style="width:300px;"></textarea>
						</td>
					</tr>
				</table>
					<div class="buttons">
								<a href="javascript:document.forms[0].submit();">보내기</a>
								&nbsp;&nbsp; <a href="#" id="closewindow">취소</a>
					</div>
			</form>
	</div>

</body>
</html>