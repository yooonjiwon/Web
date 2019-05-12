
<%@page import="com.seoul.dto.GuideBoardComment"%>
<%@page import="com.seoul.dto.Guide"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
<head>

	<meta charset="utf-8" />
	<title>글쓰기</title>
	    <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">   
    <script src="js/jquery-1.6.2.min.js" type="text/javascript"></script> 
    <script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
    <script src="js/jcarousellite_1.0.1.js" type="text/javascript"></script>
    <script src="js/jquery.galleriffic.js" type="text/javascript"></script>
    <script src="js/jquery.opacityrollover.js" type="text/javascript"></script> 
    	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript">
		$(function() {
			$('a#delete').on('click', function(event) {
				var gub_boardNo = $(this).attr('data-boardno');
				var ok = confirm(gub_boardNo + '번 글을 삭제할까요?');
				if (ok) {
					location.href = "delete.action?gub_boardno=" + gub_boardNo; 
				}
				event.preventDefault();
			});
		});	
			
			
		

	
	</script>
	
	
	<!-- 댓글 달기 기능 구현을 위한 자바스크립트 -->
		<script type="text/javascript">
	$(function() {
		
		function toggleCommentStatus(guc_CommentNo, edit) {		
			$('#commentview' + guc_CommentNo).css('display', edit ? 'none' : 'block'); //edit이 true이면 none, false이면 block
			$('#commentedit' + guc_CommentNo).css('display', edit ? 'block' : 'none'); //하나가 보이면 하나가 안보이는 기능
		} 
		
		//댓글등록 이벤트 처리
		
		
		
		$('#writecomment').on('click', function(event) {
			//댓글 내용이 없을때 경고창 뜨는 브라우저 단계에서의 검사
			var content = $('textarea#comment_content').val();
			if (content.length == 0) { //댓글이 없다면 alert창 띄움
				alert('댓글 내용을 입력하세요.');
				$('#comment_content').focus();
			} else { //댓글길이가 0이 아니라면, 즉 댓글 내용이 있다면 submit작업
				$('#commentform').submit();
			}
			event.preventDefault();
		});

		
 		$('a[id=edit]').on('click', function(event) {
			var guc_CommentNo = $(this).attr('data-commentno'); //data- : 사용자 정의 속성
			toggleCommentStatus(guc_CommentNo, true); //바로 위쪽의 toggleCommentStatus 함수 호출
			event.preventDefault();
		});
		
		$('a[id=deletecomment]').on('click', function(event) { //밑에 deletecomment에 있는 세가지 속성을 가져옴
			var guc_CommentNo = $(this).attr('data-commentno'); //삭제요청이 이뤄지면 delete서블릿이 필요하다
			var guc_BoardNo = $(this).attr('data-boardno');
			var pageNo = $(this).attr('data-pageno');
			var yes = confirm(guc_CommentNo + "번 답글을 삭제할까요?");
			if (yes) {
				location.href =
					'deletecomment.action?guc_commentno=' + guc_CommentNo + 
							'&guc_boardno=' + guc_BoardNo + '&pageno=' + pageNo;
			}
			event.preventDefault();
		});
		$('a[id=modify]').on('click', function(event) {
			var guc_CommentNo = $(this).attr('data-commentno');
			$('#commenteditform' + guc_CommentNo).submit();
			event.preventDefault();
		});
		
		$('a[id=cancel]').on('click', function(event) {
			var guc_CommentNo = $(this).attr('data-commentno');
			toggleCommentStatus(guc_CommentNo, false);
			event.preventDefault();
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
		        <div class="inputsubtitle">게시판 글 내용</div>
		          <% Guide guide = (Guide)request.getAttribute("guide"); %> 
		        
		        <table>
		            <tr>
		                <th>제목</th>
		                <%-- <td><%= board.getTitle() %></td> --%>
		                <%-- <td>${ requestScope.guide.gub_title }</td> <!-- requestScope는 안써도 잘찾음 --> --%>
		                <td><%= guide.getGub_Title() %></td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		               <%--  <td><%= board.getWriter() %></td> --%>
		                <%-- <td>${ guide.gub_writer }</td>  --%>
		               <td><%= guide.getGub_Writer() %></td> 
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <%-- <td><%= board.getRegDate() %></td> --%>
		                <%-- <td>${ guide.gub_regDate }</td> --%>
		                <td><%= guide.getGub_RegDate() %></td>
		            </tr>
					<tr>
		                <th>조회수</th>
		               <%--  <td><%= board.getReadCount() %></td> --%>
		               <%-- <td>${ guide.gub_readCount }</td> --%>
		               <td><%= guide.getGub_ReadCount() %></td>
		            </tr>
		            <tr>
		                <th>첨부파일</th>
		                <td>
		                
		                </td>
		            </tr>
		            
		            <tr>
		                <th>내용</th>
		                <td style="height:200px;vertical-align:top"><%= guide.getGub_Intro() %></td>
		                	<!-- replace를 이용해서 엔터기능 할 수 있도록 수정 -->   
		                	<!-- c:set은 변수를 만드는기능, 여기선 역슬래쉬를 인식하지 못하기때문에 실제 엔터로 적용함 -->                 
		                    <%-- <%= board.getContent().replace("\r\n", "<br>") %> 원래 있던 구문 --%> 
		                    
		                     <%-- <c:set var="newLine" value="
" /> 
		                    ${ fn:replace(guide.gub_intro, newLine, "<br>" )} --%>
		                    
 		                    
		            </tr>
		        </table>
		        
		        
		        
		        
		        
		        
		        
		           <!-- 원래 실행문 ↓ -->
		        
		       <div class="buttons">
		        <%--  <% Member member = (Member)session.getAttribute("loginuser"); %> --%>
		         
		        <!-- 아래 if문을 대신하는 JSTL -->
		        <%-- <c:if test="${ board.writer eq loginuser.memberId }" >
		        	[&nbsp;<a id="delete" href='#' data-boardno="${ board.boardNo }">삭제</a>&nbsp;]
		         	[&nbsp;<a href='update.action?boardno=${ board.boardNo }&pageno=${pageno}'>수정</a>&nbsp;]
		        </c:if>
		         	[&nbsp;<a href='reply.action?boardno=${ board.boardNo }'>댓글쓰기</a>&nbsp;]
		        	[&nbsp;<a href='list.action?pageno=${ pageno }'>목록보기</a>&nbsp;]   --%> 
		        	
		       	
		        
		       		<%--  아래 문장을 JSTL을 이용해서 위처럼 수정 
		       		<% if (member.getMemberId().equals(board.getWriter())) { %> <!-- 로그인한 사용자와 작성한 사용자가 같다면 --> --%>
		       		
		        	[&nbsp;<a id="delete" href='#' data-boardno="<%= guide.getGub_BoardNo() %>">삭제</a>&nbsp;]
		         	[&nbsp;<a href='update.action?gub_boardno=<%= guide.getGub_BoardNo() %>&pageno=<%= request.getAttribute("pageno") %>'>수정</a>&nbsp;]
		         	<%-- <% } %> --%>
		         	
		        	[&nbsp;<a href='list.action?pageno=<%= request.getAttribute("pageno") %>'>목록보기</a>&nbsp;] 
		        	<%-- <% } %> --%>		
		        				
		        	
		        	
		        </div>
		    </div>
		</div>
		
		
        
        <br /><br /><br /><br /><br /><br />
	
	</div>
	</div>
	
			<!-- comment 쓰기 영역 -->
			<!-- detail화면에서 댓글다는 영역을 만드는 코드 -->
			<!-- hidden방식으로 boardno, pageno넘어가고 content정보가 서블릿으로 넘어간다-->
		<br /><br />
				
		<%-- <% if (session.getAttribute("loginuser") != null) { %> --%>
		<form id="commentform" 
			action="writecomment.action" method="post">
			<input type="hidden" name="guc_boardno" value="<%= guide.getGub_BoardNo() %>" />
			<input type="hidden" name="pageno" value='<%= request.getAttribute("pageno") %>' />
			<input type="hidden" name="guc_writer" value="<%= guide.getGub_Writer() %>" />
			<table style="width:600px;border:solid 1px;margin:0 auto">
	            <tr>
	                <td style="width:550px">	                	
	                    <textarea name="guc_content" id="comment_content"
	                    	style="width:550px" rows="3"></textarea>	                    
	                </td>
	                <td style="width:50px;vertical-align:middle">
	                	<a id="writecomment" href="#" style="text-decoration:none">
	                		등록
	                	</a>
	                </td>
	            </tr>                    
	        </table>
        </form>
        <%-- <% } %> --%>
        
        <hr align="center" style="width:600px;" />
        
        
        <!-- ---------------------------------------------------------------------------------- -->

		<!-- comment 표시영역 -->

<%-- 		    <% if (guide.getGub_Comments().size() == 0) { %> <!-- 댓글이 없다면 -->
			<h3 id="nodata" style="text-align:center">
			 작성된 댓글이 없습니다. 
			</h3>
			
		<% } else { %> <!-- 댓글이 있으면 -->--%>
  		    <table style="width:600px;border:solid 0px;margin:0 auto"> 
			<% for (GuideBoardComment bcomment : guide.getGub_Comments()) { %> <!-- 데이터가 입력될때마다 tr하나씩-->
			<tr>
				<td style="text-align:left;margin:5px;border-bottom: solid 1px">
	        		<div id='commentview<%= bcomment.getGuc_CommentNo() %>'> <!-- 편집을 눌렀을떄 -->
	                    <%= bcomment.getGuc_Writer() %> &nbsp;&nbsp;
	                    <br /><br />
	                    <span>
							<%= bcomment.getGuc_Content().replace("\r\n", "<br>") %>
	                    </span>
	                    <br /><br />
	                    <!-- ↓작성자가 사용자가 맞으면 -->
	                     <div style='display: <%= guide.getGub_Writer().equals(bcomment.getGuc_Writer()) ? "block" : "none" %>'> 
	                    
	                    	<a id="edit" data-commentno='<%= bcomment.getGuc_CommentNo() %>' href="#">편집</a>
	                    	&nbsp;
	                    	<a id="deletecomment" href="#" data-commentno='<%= bcomment.getGuc_CommentNo() %>'
													data-boardno='<%= guide.getGub_BoardNo() %>'
													data-pageno='<%= request.getAttribute("pageno") %>'>삭제</a>
								
							</div>	
	                  </div>	
	                
	                   <div id='commentedit<%= bcomment.getGuc_CommentNo() %>' style="display: none"> <!-- 삭제를 눌렀을때 -->
						<%= bcomment.getGuc_Writer() %>&nbsp;&nbsp; 
						[<%= bcomment.getGuc_RegDate() %>] 
						<br /><br />
						<form id="commenteditform<%= bcomment.getGuc_CommentNo() %>" action="updatecomment.action" method="post">
						<input type="hidden" name="guc_boardno" value="<%= guide.getGub_BoardNo() %>" />
						<input type="hidden" name="pageno" value='<%= request.getAttribute("pageno") %>' />
						<input type="hidden" name="guc_commentno" value="<%= bcomment.getGuc_CommentNo() %>" />
						<textarea name="guc_content" style="width: 600px" rows="3" maxlength="200"><%= bcomment.getGuc_Content() %></textarea>
						</form>
						<br />
						<div>
							<!-- bcomment.getCommentNo 를 이용해서 커맨트 넘버를 같이 저장하면서 돌수있게 만듬 -->
							<a id="modify" data-commentno='<%= bcomment.getGuc_CommentNo() %>' href="#">수정</a> 
							&nbsp; 
							<a id="cancel" data-commentno='<%= bcomment.getGuc_CommentNo() %>' href="#">취소</a>
						</div>
					</div> 
		<% } %>	
					<%-- </td>
	        	</tr>
	        
			<% } %>
	        </table> --%>
		 <%-- <% } %>  --%>
		<!-- comment 표시 영역 -->
		
<br><br><br><br><br><br><br><br><br>

</body>
</html>