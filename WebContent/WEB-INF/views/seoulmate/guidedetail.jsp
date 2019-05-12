<%@page import="com.seoul.dto.GuideBoardComment"%>
<%@page import="com.seoul.dto.Guide"%>
<%@page import="com.seoul.dto.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<!DOCTYPE html>

<html>
<head>
  <meta charset="utf-8" />
  <title>가이드 신청</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="author">
  <link rel="shortcut icon" href="http://static02.hongkiat.com/logo/hkdc/favicon.ico">
  <link rel="icon" href="http://static02.hongkiat.com/logo/hkdc/favicon.ico">
  <link rel="stylesheet" href="/seoul/css/reset.css" type="text/css" media="screen">
  <link rel="stylesheet" href="/seoul/css/style.css" type="text/css" media="screen">
  <link rel="stylesheet" href="/seoul/css/grid.css" type="text/css" media="screen">  
  <link rel="stylesheet" href="/seoul/css/guide2.css" type="text/css" media="screen">  
  <script src="js/jquery-1.6.2.min.js" type="text/javascript"></script> 
  <script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
  <script src="js/jcarousellite_1.0.1.js" type="text/javascript"></script>
  <script src="js/jquery.galleriffic.js" type="text/javascript"></script>
  <script src="js/jquery.opacityrollover.js" type="text/javascript"></script> 
  

  <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
 		<script type="text/javascript">
	$(function() {
		
		function toggleCommentStatus(guc_CommentNo, edit) {		
			$('#commentview' + guc_CommentNo).css('display', edit ? 'none' : 'block'); //edit이 true이면 none, false이면 block
			$('#commentedit' + guc_CommentNo).css('display', edit ? 'block' : 'none'); //하나가 보이면 하나가 안보이는 기능
		} 
		
		
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
	
	
	
	function openWin(){  
	    window.open("/seoul/seoulmate/sendmail.action", "메일 보내기", "width=600, height=400, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
	}  

	 
	</script>
</head>
<body id="page30">
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
    <jsp:include page="/WEB-INF/views/include/common.jsp" />
    
        <div class="bg-top-2">
        <div class="bg">
        <div class="bg-top-shadow">
        <div class="main">
        <div class="box">
        <div class="padding">
        <div class="container_12">
        <div class="wrapper">
        <div class="grid_12">
		<h2 class="hd-element">페이지 별 콘텐츠 내용 시작</h2>
			<div class="holder">
				<p class="scrum">
					<h3>가이드 신청 내용</h3>
	
<input type="hidden" name="curPage" value="1"/>
	<section id="content">
		<div class="cnt-faqitem view">
			<div class="header">
				<p class="date fc-bold fc-grey3"><h2 style="font-weight:bold;">
					작성일 :&nbsp; <span class="fc-black2">${ guide.gub_RegDate }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					조회수 :&nbsp; <span class="fc-black2">${ guide.gub_ReadCount }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					작성자 ID :&nbsp; <span class="fc-black2">${ guide.gub_Writer }</span><br><br>
					이메일 :&nbsp; <span class="fc-black2">${ guide.gub_Email }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					연락처 :&nbsp; <span class="fc-black2">${ guide.gub_Phone }</span><br><br>
					가이드 희망 대상 :&nbsp; <span class="fc-black2">${ guide.gub_Target }</span><br><br>
					가이드 희망 분야 :&nbsp; <span class="fc-black2">${ guide.gub_HopeArea }</span><br><br>
					작성자 이름 :&nbsp; <span class="fc-black2">${ guide.gub_Name }</span><br><br><br>
					-&nbsp; <span class="fc-black2" style="font-size:28px;">${ guide.gub_Title }</span><br><br>
					</h2>
				<h4 class="heading2 regular fc-blue" style="font-size:24px;">${ guide.gub_Intro }</h4><br><br>
			</div>
		<div class="buttons">
		<c:if test="${ guide.gub_Writer eq loginuser.memberId }" >
					[&nbsp;<a id="delete" href='#' data-boardno="${ guide.gub_BoardNo }">삭제</a>&nbsp;]
		         	[&nbsp;<a href='update.action?gub_boardno=${ guide.gub_BoardNo }&pageno=<%= request.getAttribute("pageno") %>'>수정</a>&nbsp;]
		  
		</c:if> 
					[&nbsp;<a href='#'  onClick="javascript:openWin();">메일 보내기</a>&nbsp;]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		         	[&nbsp;<a href='list.action?pageno=${ pageno }'>목록보기</a>&nbsp;] <br>
		</div>
			

			
						<!-- comment 쓰기 영역 -->
			<!-- detail화면에서 댓글다는 영역을 만드는 코드 -->
			<!-- hidden방식으로 boardno, pageno넘어가고 content정보가 서블릿으로 넘어간다-->
		<br /><br />
				
		 <%-- <% if (session.getAttribute("loginuser") != null) { %>  --%>
		 <c:if test="${ loginuser ne null }">
		 <form id="commentform" action="writecomment.action" method="post">
			<input type="hidden" name="guc_boardno" value="${ guide.gub_BoardNo }" />
			<input type="hidden" name="pageno" value='${ pageno }' />
			<input type="hidden" name="guc_writer" value="${ guide.gub_Writer }" />
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
        <%--  <% } %>  --%>
        </c:if>
        
        <hr align="center" style="width:600px;" />
        
        
        <!-- ---------------------------------------------------------------------------------- -->

		<!-- comment 표시영역 -->


			 <%-- <% for (GuideBoardComment bcomment : guide.getGub_Comments()) { %> <!-- 데이터가 입력될때마다 tr하나씩--> --%> 
			<c:forEach var="bcomment" items="${ guide.gub_Comments }"> 
			<div class="cnt-faqitem reply">
			<div class="header">	
				<p class="label fc-bold">답변</p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ fn:replace(bcomment.guc_Content, newLine, "<br>") }
				<p class="date fc-bold fc-grey3">
					작성일 : <span class="fc-black2">&nbsp;${ bcomment.guc_RegDate }</span>&nbsp;&nbsp;&nbsp;&nbsp;
					작성자 : <span class="fc-black2">&nbsp;${ bcomment.guc_Writer }</span>
					<div style='display: ${ loginuser.memberId eq bcomment.guc_Writer ? "block" : "none" }'>
	                    	<a id="edit" data-commentno='${ bcomment.guc_CommentNo }' href="#">편집</a>&nbsp;
	                    	<a id="deletecomment" href="#" data-commentno='${ bcomment.guc_CommentNo }'
													data-boardno='${ guide.gub_BoardNo }'
													data-pageno='${ pageno }'>삭제</a>
					</div>
					
			</div>
		</div>
			
		
	                
	                   <div id='commentedit${ bcomment.guc_CommentNo }' style="display: none"> <!-- 삭제를 눌렀을때 -->
						${ bcomment.guc_Writer }&nbsp;&nbsp; 
						[${ bcomment.guc_RegDate }] 
						<br /><br />
						<form id="commenteditform${ bcomment.guc_CommentNo }" action="updatecomment.action" method="post">
						<input type="hidden" name="guc_boardno" value="${ guide.gub_BoardNo }" />
						<input type="hidden" name="pageno" value='${ pageno }' />
						<input type="hidden" name="guc_commentno" value="${ bcomment.guc_CommentNo }" />
						<textarea name="guc_content" style="width: 600px" rows="3" maxlength="200">${ bcomment.guc_Content }</textarea>
						</form>
						<div>
							<a id="modify" data-commentno='${ bcomment.guc_CommentNo }' href="#">수정</a> 
							&nbsp; 
							<a id="cancel" data-commentno='${ bcomment.guc_CommentNo }' href="#">취소</a>
						</div>
					</div> 
		 </c:forEach> 
		<%-- <% } %> --%>
		
<br><br><br>
</div>
</section>
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

    
    
    		 <jsp:include page="/WEB-INF/views/include/footer.jsp" />
    
    
</body>
</html>






