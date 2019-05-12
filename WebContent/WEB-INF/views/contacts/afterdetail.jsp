<%@ page import="com.seoul.dto.ContactsComment"%>
<%@ page import="com.seoul.dto.ContactsAttach"%>
<%@ page import="com.seoul.dto.ContactsBoard"%>
<%@ page import="com.seoul.dto.Member" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/seoul/css/default.css" />
	<link rel="stylesheet" href="/seoul/css/cinput.css" />
    <link rel="stylesheet" href="/seoul/css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/seoul/css/cstyle.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/seoul/css/cgrid.css" type="text/css" media="screen">   
    <link rel="Stylesheet" href="/seoul/css/tabledesign.css" />
	<link rel="stylesheet" href="/seoul/css/style4.css" type="text/css" media="screen">
	<script src="/seoul/js/jquery.galleriffic.js" type="text/javascript"></script>
    <script src="/seoul/js/jquery.opacityrollover.js" type="text/javascript"></script>
    <script src="js/jquery-1.6.2.min.js" type="text/javascript"></script>     
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript">
	
	$(function() {
		$('a#delete').on('click', function(event) {
			var boardNo = $(this).attr('data-boardno');
			var ok = confirm(boardNo + '번 글을 삭제할까요?');
			if (ok) {
				location.href = "afterdelete.action?boardno=" + boardNo;
			}
			event.preventDefault();// <a>의 기본 동작 중단
		});
	});
	

	$(function() {
		
		function toggleCommentStatus(commentNo, edit) { 
			$('#commentview' + commentNo).css('display', edit ? 'none' : 'block');
			$('#commentedit' + commentNo).css('display', edit ? 'block' : 'none');
		}
		
		// 댓글등록 이벤트 처리
		$('#writecomment').on('click', function(event) {
			var content = $('textarea#comment_content').val();
			if (content.length == 0) {
				alert('댓글 내용을 입력하세요');
				$('#comment_content').focus();
			} else {
				$('#commentform').submit();
			}
			event.preventDefault();
		});
		
		//$('#edit')
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
					'commentdelete.action?commentno=' + commentNo + 
							'&boardno=' + boardNo + '&pageno=' + pageNo;
			}
			event.preventDefault();
		});
		$('a[id=modify]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno');
			$('#commenteditform' + commentNo).submit();
			event.preventDefault();
		});

		$('a[id=cancel]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno');
			toggleCommentStatus(commentNo, false);
			event.preventDefault();
		});
	});
	</script>
</head>
<body id="page5">
	
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<div class="ic">More Website Templates  @ TemplateMonster.com - August22nd 2011!</div>
    
<!-- content -->
    <section id="content">
        <div class="bg-top">
        	<div class="bg-top-2">
                <div class="bg">
                    <div class="bg-top-shadow">
                        <div class="main">
                            <div class="box">
                                <div class="padding">
                                    <div class="container_12">
                                        <div class="wrapper">
                                            <article class="grid_4 alpha">
												<div class="indent">  
													<h3 class="prev-indent-bot2">Contacts</h3>
                                               	    <ul class="list-2">
                                                   		<li><a href="contactslist.action">공지사항</a></li>
                                                    	<li><a href="eventlist.action">이벤트</a></li>
                                                    	<li><a href="quelist.action">문의사항</a></li>
                                                    	<li class="last-item"><a href="afterlist.action">후기</a></li>
                                                	</ul>
                                            	</div>
                                            </article>
                                            <article class="grid_8 omega">
												<div style="padding-top:25px;text-align:center">
													<div id="inputcontent">
													    <div id="inputmain">
													        <div class="inputsubtitle">게시판 글 내용</div>
													        <%-- <% Board board = (Board)request.getAttribute("board"); %> --%>
													        <table>
													            <tr>
													                <th>제목</th>
													                <%-- <td><%= board.getTitle() %></td> --%>
													                <td>${ requestScope.board.title }</td>
													            </tr>
													            <tr>
													                <th>작성자</th>
													                <%-- <td><%= board.getWriter() %></td> --%>
													                <td>${ requestScope.board.writer }</td>
													            </tr>
													            <tr>
													                <th>작성일</th>
													                <%-- <td><%= board.getRegDate() %></td> --%>
													                <td>${ board.regDate }</td>
													            </tr>
																<tr>
													                <th>조회수</th>
													                <%-- <td><%= board.getReadCount() %></td> --%>
													                <td>${ board.readCount }</td>
													            </tr>
													            <tr>
													                <th>첨부파일</th>
													                <td>
													                <%-- <% Board board = (Board)request.getAttribute("board"); %> --%>
													                <c:forEach var="attachment" items="${ board.attachments }">
													                	[ <a href="downloads.action?attachno=${ attachment.attachNo }">
													                	${ attachment.userFileName }
													                	</a> ]
													                	<br>
													                </c:forEach>	
													                
													                <%-- <% Board board = (Board)request.getAttribute("board"); %>
													                <% for (BoardAttach attachment : board.getAttachments()) { %>
													                	[ <a href="download.action?attachno=<%= attachment.getAttachNo() %>">
													                	<%= attachment.getUserFileName() %>
													                	</a> ]
													                	<br>
													                <% } %> --%>               
													                </td>
													            </tr>
													            <tr>
													                <th>내용</th>
													                <td style="height:200px;vertical-align:top">		                    
													                   <%-- <%= board.getContent().replace("\r\n", "<br>") %>
													                   <% String newLine = "\r\n"; request.setAttribute("newLine", newLine); %> --%>
													                   <c:set var="newLine" value="
											" />
													                   ${ fn:replace(board.content, newLine, "<br>") }
													                  <%-- ${ board.content.replace("\r\n", "<br>") } --%>
													                </td>
													            </tr>
													        </table>
													        <div class="buttons">
													        <%-- <% Member member = (Member)session.getAttribute("loginuser"); %> --%>
													        <%-- <% if (member.getMemberId().equals(board.getWriter())) { %> --%>
													        <c:if test="${ board.writer eq loginuser.memberId or loginuser.memberId eq 'admin' }">
													        	[&nbsp;<a id="delete" href='#' data-boardno="${ board.boardNo }">삭제</a>&nbsp;]
													        	[&nbsp;<a href='afteredit.action?boardno=${ board.boardNo }&pageno=${ pageno }'>수정</a>&nbsp;]      
													        </c:if>	
													        	[&nbsp;<a href='afterreply.action?boardno=${ board.boardNo }'>답글쓰기</a>&nbsp;]
													        	[&nbsp;<a href="afterlist.action">목록보기</a>&nbsp;]	
													        <%-- <% Member member = (Member)session.getAttribute("loginuser"); %>
													        <% if (member.getMemberId().equals(board.getWriter())) { %>
													        	[&nbsp;<a id="delete" href='#' data-boardno="<%= board.getBoardNo() %>">삭제</a>&nbsp;]
													        	[&nbsp;<a href='update.action?boardno=<%= board.getBoardNo() %>&pageno=<%= request.getAttribute("pageno") %>'>수정</a>&nbsp;]
													        <% } %>		
													        	[&nbsp;<a href='reply.action?boardno=<%= board.getBoardNo() %>'>댓글쓰기</a>&nbsp;]
													        	[&nbsp;<a href='list.action?pageno=<%= request.getAttribute("pageno") %>'>목록보기</a>&nbsp;] --%>
													        </div>
													    </div>
													</div>
													
													<!-- comment 쓰기 영역 -->
													<br /><br />
													
													<%-- <% if (session.getAttribute("loginuser") != null) { %> --%>
													<c:if test="${ loginuser.memberId ne null }">		
													<form id="commentform" 
														action="commentwrite.action" method="post">
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
											        <%-- <% } %> --%>
											        <hr align="center" style="width:600px;" />
													
													<%-- <% if (board.getComments().size() == 0) { %> --%>
													<c:choose>
													<c:when test="${ empty board.comments }">
														<h3 id="nodata" style="text-align:center">
														 작성된 댓글이 없습니다.
														</h3>
													</c:when>
													<%-- <% } else { %> --%>
													<c:otherwise>
													    <table style="width:600px;border:solid 1px;margin:0 auto">
														<%-- <% for (BoardComment bcomment : board.getComments()) { %> --%>
														<c:forEach var="bcomment" items="${ board.comments }">
														<tr>
															<td style="text-align:left;margin:5px;border-bottom: solid 1px">
												        		<div id='commentview${ bcomment.commentNo }'>
												                    ${ bcomment.writer } &nbsp;&nbsp;
												                    [ ${ bcomment.regDate } ]
												                    <br /><br />
												                    <span>
																		${ fn:replace(bcomment.content, newLine, "<br>") }
												                    </span>
												                    <br /><br />
												                    <%-- <div style='display: <%= member.getMemberId().equals(bcomment.getWriter()) ? "block" : "none" %>'> --%>
												                    <div style='display: ${ loginuser.memberId eq bcomment.writer ? "block" : "none" }'>
												                    	<a id="edit" data-commentno='${ bcomment.commentNo }' href="#">편집</a>
												                    	&nbsp;
												                    	<a id="deletecomment" href="#" data-commentno='${ bcomment.commentNo }'
																									   data-boardno='${ board.boardNo }'
																								       data-pageno='${ pageno }'>삭제</a>
												                    </div>
												                </div>
												                
												                <div id='commentedit${ bcomment.commentNo }' style="display: none">
																	${ bcomment.writer }&nbsp;&nbsp; 
																	[${ bcomment.regDate }] 
																	<br /><br />
																	<form id="commenteditform${ bcomment.commentNo }" 
																		action="commentedit.action" method="post">
																	<input type="hidden" name="boardno" value="${ board.boardNo }" />
																	<input type="hidden" name="pageno" value='${ pageno }' />
																	<input type="hidden" name="commentno" value="${ bcomment.commentNo }" />
																	<textarea name="content" style="width: 600px" rows="3" maxlength="200">${ bcomment.content }</textarea>
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
														<%-- <% } %> --%>
														</c:forEach>
												        </table>
													<%-- <% } %> --%>
													</c:otherwise>
													</c:choose>
													<!-- comment 표시 영역 -->
											
													
													
											        
											        <br /><br /><br /><br /><br /><br />
												
												</div>
                                            </article>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>	
        </div>
        <div class="bg-bot">
        	<div class="main">
            	<div class="container_12">
                	<div class="wrapper">
                    	<article class="grid_3">
                        	<h3 class="prev-indent-bot">Our Address</h3>
                            <dl>
                                <dt class="indent-bot">서울특별시 강남구 테헤란로 123<br>여삼빌딩 15층</dt>
                                <dd><span>Telephone:</span>  02-6255-8002</dd>
                                <dd><span>FAX:</span> 02-569-8069</dd>
                                <dd><strong>E-mail:</strong> <a href="#">info@itwill.co.kr</a></dd>
                            </dl>
                        </article>
                        <article class="grid_9">
                        	<h3 class="prev-indent-bot">HelloSeoul Info</h3>
                            <img src="/seoul/images/contactsinfo1.jpg">
                            <img src="/seoul/images/contactsinfo2.jpg">
                        </article>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
	<!--==============================footer=================================-->
     		 <jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>
