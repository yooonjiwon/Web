<%@page import="com.seoul.dto.TureBoardComment"%>
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

	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	
	<style>
.probtn {
    border: none;
    color: white;
    padding: 14px 28px;
    font-size: 16px;
    cursor: pointer;
    
}

.prosuccess {background-color: #4CAF50;} /* Green */
.prosuccess:hover {background-color: #46a049;}

.proinfo {background-color: #2196F3;} /* Blue */
.proinfo:hover {background: #0b7dda;}

.prowarning {background-color: #ff9800;} /* Orange */
.prowarning:hover {background: #e68a00;}

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

</style>
	
	
	
	<script type="text/javascript">
	
	<% if (request.getAttribute("delete") !=null) {%>
	window.close()
	<%}%>
	
	
	$(function() {
		$('a#delete').on('click', function(e) {		
			var boardNo = $(this).attr('data-boardno');
			var ok = confirm(boardNo+'번 글을 삭제할까요?');
			if(ok){
				location.href = "turedelete.action?boardno="+boardNo;
			}
			
			event.preventDefault();//<a>의 기본동작 중단
			//window.close();
		});
		
	});
	
	</script>
	
	<script type="text/javascript">
	$(function() {
		
		function toggleCommentStatus(commentNo, edit) {		
			$('#commentview' + commentNo).css('display', edit ? 'none' : 'block');
			$('#commentedit' + commentNo).css('display', edit ? 'block' : 'none');
		}
		
		$('#writecomment').on('click', function(event) {
			event.preventDefault();
			if ( ${commentcount.count} >= 3){
				alert('댓글한도초과입니다.');
				return;
			}
			
			var content = $('textarea#comment_content').val();
			
			if (content.length == 0){
				alert('댓글내용을 입력하세요');
				$('#comment_content').focus();
			} else {
				$('#commentform').submit();
			//	${ commentcount.count } = ${ commentcount.count } + 1 
			}
			
		});
		
		$('a[id=edit]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno');
			toggleCommentStatus(commentNo, true);
			event.preventDefault();
		});
		
		$('a[id=deletecomment]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno');
			var boardNo = $(this).attr('data-boardno');
			var pageNo = $(this).attr('data-pageno');
			var yes = confirm(commentNo + "번 답글을 삭제할까요?");
			if (yes) {
				location.href =
					'turedeletecomment.action?commentno=' + commentNo +//confirm에서 yes면 deletecomment.action으로 이동 
							'&boardno=' + boardNo + '&pageno=' + pageNo;
			}
			event.preventDefault();
		});
		$('a[id=modify]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno');
			$('#commenteditform' + commentNo).submit();
			event.preventDefault();
		});
		
		$('a[id=cancel]').on('click', function(event) {//속성으로 검색a[id=cancel]
			var commentNo = $(this).attr('data-commentno');
			toggleCommentStatus(commentNo, false);
			event.preventDefault();
		});
		
		$('a[id*="guideprofile"]').on('click', function(event){
			event.preventDefault()
			var guideid = $(this).attr('data-guideid');
			var listid = $(this).attr('data-listid')
			window.open('tureguideprofile.action?guideid='+guideid+'&listid='+listid,'a','width=850, height=1000', 'left=800', 'top=400');
			
		});
	
		
		
	});
	
	</script>
	
</head>
<body>
<% if (request.getAttribute("delete") ==null) {%>
	

	<div id="pageContainer" style="height:1800px">
	
	 <% TureBoard board = 
				(TureBoard)request.getAttribute("board"); %>	
		<div style="padding-top:50px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		  
		       <h1>BoardDetail</h1>
		       <br>
		       <hr>
		       <div id="detailwriter" style="width:300px; height:60px; float:left;font-size:20pt;padding-top:10px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UserId : ${ requestScope.board.writer }</div>
		      	<div style="float:left; padding-left:40px">
		        <button class="probtn prosuccess" style="padding-top:10px">${ board.location }</button>
		       	<button class="probtn proinfo">${ board.time } Hr</button>
				<button class="probtn prowarning">${ board.day }</button>
		        </div>
		        <br><br><br><br>
		        <table class="type10" style="margin:0 auto; font-size:15pt">
		            <tr>
		                <th>제목</th>
		                <td>
		                   ${ board.title }
		                </td>
		            </tr>
		            <tr>
		                <th>여권번호</th>
		               <% Member member = (Member)session.getAttribute("loginuser"); %>
		                <td>
		                	<%= member.getPassNo() %>
		                </td>
		            </tr>
		             <tr>
		                <th>작성일</th>
		                <td>		                    
		                   ${ board.regDate }
		                </td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td>		                    
		                    <div id="detailtext" style="width:400px; height:300px; float:left;">	
		                	<c:set var = "newLine" value="
"></c:set>              <!-- \n\r을 인식못함 -->
		                    ${ fn:replace(board.content, newLine, "<br>") }
		                    <!-- 자바의 enter를 html 의 br로 변경  -->
		                    </div>
		                </td>
		            </tr>
		            
		        </table>
		       
		       
		       
		       
		       
		       
		       <hr>
		        <div class="buttons">
		        	<!-- boardno를 가지고감 -->

		        	
		        	<c:if test="${board.writer eq loginuser.memberId }">
		        	
		        		[&nbsp;<a href='tureupdate.action?boardno=${ board.boardNo }&pageno=${ pageno }'>수정</a>&nbsp;]
		        		[&nbsp;<a id="delete" href='#' data-boardno = '${ board.boardNo }'>삭제</a>&nbsp;]
		        	
		        	</c:if>
		        	
		        		<!-- [&nbsp;<a href='reply.action?boardno=${ board.boardNo }'>댓글쓰기</a>&nbsp;]  -->
		        	
		        </div>
		        
		        
		        
		      
		    </div>
		    
		      <!-- comment 쓰기 영역 -->
		      <% TureCommenteCount count = (TureCommenteCount)session.getAttribute("commentcount"); %>
		      <div id="count">"${commentcount.count}"</div>
		      
		<br /><br />
		<c:if test = "${ loginuser ne null }">
		<form id="commentform" 
			action="turewritecomment.action" method="post">
			<input type="hidden" name="boardno" value="${ board.boardNo }" />
			<input type="hidden" name="pageno" value='${ pageno }' />
			<table style="width:600px;border:solid 1px;margin:0 auto">
	            <tr>
	                <td style="width:550px">	                	
	                    <textarea id="comment_content" name="content" 
	                    	style="width:550px" rows="3"></textarea>	                    
	                </td>
	                <td style="width:50px;vertical-align:middle">
	                	<a id="writecomment" href="#" style="text-decoration:none">
	                		댓글<br />등록
	                	</a>
	                </td>
	            </tr>                    
	        </table>
        </form>
        </c:if>
   
        
        <hr align="center" style="width:600px;" />
        
         
         <c:choose>
         <c:when test="${ empty board.comments }">
         	<h3 id="nodata" style="text-align:center">
			 작성된 댓글이 없습니다.
			</h3>
         </c:when>
		 <c:otherwise>
		    <table style="width:600px;border:solid 1px;margin:0 auto">
			
		<c:forEach var ="bcomment" items="${ board.comments }">
		
		
			<tr>
				<td style="text-align:left;margin:5px;border-bottom: solid 1px">
	        		<div id='commentview${bcomment.commentNo}'>
	                    <a id="guideprofile" href="#" data-guideid='${bcomment.writer}' data-listid='${ requestScope.board.writer }'>${bcomment.writer}</a> &nbsp;&nbsp;
	                    [ ${bcomment.regDate} ]
	                    <br /><br />
	                    <span>
	                    ${ fn:replace(bcomment.content, newLine, "<br>") }
					
	                    </span>
	                    <br /><br />
	                    <div style='display: ${loginuser.memberId eq bcomment.writer ? "block" : "none"} '>
	                    	<a id="edit" data-commentno='${ bcomment.commentNo }' href="#">편집</a>
	                    	&nbsp;
	                    	<a id="deletecomment" href="#" data-commentno='${ bcomment.commentNo}'
													data-boardno='${ bcomment.boardNo}'
													data-pageno='${ pageno }'>삭제</a>
	                    </div>
	                </div>
	                
	                <div id='commentedit${ bcomment.commentNo }' style="display: none">
						${ bcomment.writer }&nbsp;&nbsp; 
						[${ bcomment.regDate }] 
						<br /><br />
						<form id="commenteditform${ bcomment.commentNo }" action="tureupdatecomment.action" method="post">
						<input type="hidden" name="boardno" value="${  board.boardNo}" />
						<input type="hidden" name="pageno" value='${ pageno }' />
						<input type="hidden" name="commentno" value="${ bcomment.commentNo }" />
						<textarea name="content" style="width: 600px" rows="3" maxlength="200">${ bcomment.content}</textarea>
						</form>
						<br />
						<div>
							<a id="modify" data-commentno='${ bcomment.commentNo }' href="#">수정</a> 
							&nbsp; 
							<a id="cancel" data-commentno='${ bcomment.commentNo }' href="#">취소</a>
						</div>
					</div>
		
					</td>
	        	</tr>
			</c:forEach>
	        </table>

		</c:otherwise>
		</c:choose>
		<br><br><br>
		<!-- comment 표시 영역 -->
        <div id="photo" style="width:80%; margin:0 auto; background-color:bisque;">
			
			<% if(board.getAttachments().size() > 0) { %>			
			<img style="width:100%; height:500px; margin:0 auto;"src="/seoul/files/<%= board.getAttachments().get(0).getSavedFileName() %>">
			<% } else { %>
			<img src="/seoul/files/noimage.jpg">
			<% } %>
			

			<% if(board.getAttachments().size() > 0) { %>			
			<img style="width:100%; height:500px; margin:0 auto;"src="/seoul/files/<%= board.getAttachments().get(1).getSavedFileName() %>">
			<% } else { %>
			<img src="/seoul/files/noimage.jpg">
			<% } %>
			</div> 
        
        
        
        
        
		    
		</div>
		
		
        
        <br /><br /><br /><br /><br /><br />
	
	</div>
	</div>
<% }%>
</body>
</html>