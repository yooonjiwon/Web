<%@page import="com.seoul.dto.Information"%>
<%@page import="com.seoul.dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
			   contentType="text/html; charset=utf-8"
    		   pageEncoding="utf-8"%>
 
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>글쓰기</title>
	<link rel="Stylesheet" href="/seoul/css/default.css" />
	<link rel="Stylesheet" href="/seoul/css/input2.css" />
	<style type="text/css">
	a { text-decoration: none } /* 언더스코어를 없애는 작업 */
	</style>
	<script type="text/javascript" src="/seoul/navereditor/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
  	<script type="text/javascript">
  	$(function() { //jQuery's main function
  		$('a#update').on('click', function(event) {
  			$('form#updateform').submit();
  			event.preventDefault();// <a>의 기본 기능 수행 막는 명령
  		});
  	
  	
  	
  		$(function() {
  			//전역변수선언
  			var editor_object = [];

  			nhn.husky.EZCreator.createInIFrame({
  				oAppRef : editor_object,
  				elPlaceHolder : "smarteditor",
  				sSkinURI : "/seoul/navereditor/SmartEditor2Skin.html",
  				htParams : {
  					// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
  					bUseToolbar : true,
  					// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
  					bUseVerticalResizer : true,
  					// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
  					bUseModeChanger : true,
  				}
  			});

  			$('a#write').on(
  					'click',
  					function(event) {
  						editor_object.getById["smarteditor"].exec(
  								"UPDATE_CONTENTS_FIELD", []);
  						$('form#writeform').submit(); //writeform을 서버로 전송처리
  						event.preventDefault(); //<a>의 기본기능(화면 리프레시) 수행을 막는 명령
  					});
  	});
	</script>
</head>
<body>

	<div id="pageContainer">

		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<jsp:include page="/WEB-INF/views/include/common.jsp" />

		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시판 글 쓰기</div>
		        <form id="updateform" action="update38.action" method="post">
		        <% Information board = (Information)request.getAttribute("board"); %>		        
		        <table>
		            <tr>
		                <th>제목</th>
		                <td>
		                 	<input type="hidden" name="boardno"
		                     	value="<%= board.getIn_No() %>" />
		                    <input type="text" name="title" style="width:280px"
		                     	value="<%= board.getIn_Title() %>" />
		                </td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>
		                	<% Member member = (Member)session.getAttribute("loginuser"); %> <!-- 게시판에 로그인한 사용자의 아이디가 출력 -->
		                	 <input type="text" name="memberid" style="width:280px"
		                     	value="<%= member.getMemberId() %>" />
		                </td>
		            </tr>
		            <tr>
		                <th>주소</th>
		                <td>
		                    <input type="text" name="address" style="width:280px"
		                     	value="<%= board.getIn_Address() %>" />
		                </td>
		            </tr>
		            <tr>
		                <th>전화번호</th>
		                <td>
		                    <input type="text" name="telephone" style="width:280px"
		                     	value="<%= board.getIn_Telephone() %>" />
		                </td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td>
		                    <%-- <textarea name="content" cols="76"	rows="15"><%= board.getIn_Content() %></textarea> --%>
		                    <textarea name="content" id="smarteditor" rows="150" cols="100" style="width: 280px; height: 212px;"></textarea>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	<!-- <form>의 submit 수행 -->
		        	<a id="update" href="#">글수정</a>
		        	&nbsp;&nbsp;
		        	<a href='/seoul/information/detail38.action?boardno=<%= board.getIn_No() %>&pageno=<%= request.getAttribute("pageno") %>'>취소</a>
		        	&nbsp;&nbsp;

		        </div>
		        </form>
		    </div>
		</div>   	

	</div>
	</div>
</body>
</html>