<%@ page import="com.seoul.dto.Member"%>
<%@ page import="com.seoul.dto.ContactsBoard"%>
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
    <style type="text/css">
	a { text-decoration: none }
	</style> 
    <script src="js/jquery-1.6.2.min.js" type="text/javascript"></script>     
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="/seoul/navereditor/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript">
	$(function(){
	    //전역변수선언
	    var editor_object = [];
	    
	    $('#smarteditor').val('${ board.content }');
	     
	    nhn.husky.EZCreator.createInIFrame({
	        oAppRef: editor_object,
	        elPlaceHolder: "smarteditor",
	        sSkinURI: "/seoul/navereditor/SmartEditor2Skin.html", 
	        htParams : {
	            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
	            bUseToolbar : true,             
	            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
	            bUseVerticalResizer : true,     
	            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
	            bUseModeChanger : true, 
	        }
	    });
		$('a#update').on('click', function(event) {
			editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
			$('form#updateform').submit(); // 서버로 전송처리
			event.preventDefault(); // <a>의 기본 기능 수행 막는 명령
		});
	});
	
	$(function() {
		$('a#cancel').on('click', function(event) {
			history.back();
			event.preventDefault();
		})
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
													        <div class="inputsubtitle">게시판 글 수정</div>
													        <form id="updateform" action="queedit.action" method="post">
													        <table>
													        	<input type="hidden" name="boardno" value="${ board.boardNo }">
													            <tr>
													                <th>제목</th>
													                <td>
													                    <input type="text" name="title" style="width:280px"
													                    	value="${ board.title }" />
													                </td>
													            </tr>
													            <tr>
													                <th>작성자</th>
													                <td>
		                												${ loginuser.memberId }
		                												<input type="hidden" name="writer" value="${ loginuser.memberId }">
													                </td>
													            </tr>
													            <tr>
													                <th>내용</th>
													                <td>		                    
													                    <textarea name="content" id="smarteditor" rows="10" cols="100" style="width:766px;
													                     height:412px;"></textarea> <!-- textarea : <textarea>와 </textarea>사이에 enter 금지 -->
													                </td>
													            </tr>
													            <tr>
														            <th>비밀번호</th>
														            <td>		                    
														                <input type="password" name="password" style="width:280px" />
														            </td>
														        </tr>
													        </table>
													        </form>
													        <div class="buttons">
													        	<!--  <form>의 submit 수행 -->
													        	<a id="update" href="#">글수정</a>
													        	&nbsp;&nbsp;
													        	<a id="cancel" href='#'>취소</a>
													        	<!-- <a href="javascript:/demoweb/board/list.action"> : html에 javascript를 하드코딩하는 방식이 좋지 않기때문에 분리해서 수행 -->
													        </div>
													    </div>
													</div>   	
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
