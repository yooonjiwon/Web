<%-- <%@page import="com.seoul.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  	<title>가이드북 및 지도 신청</title>
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
		$('a#submit').on('click', function(event) {
			$('form#submitform').submit(); //writeform을 서버로 전송처리
			alert('신청이 완료되었습니다.');
			event.preventDefault();
		});
		});
	

	</script>    

</head>
<body id="page3">

		<jsp:include page="/WEB-INF/views/include/header.jsp" />
    	 <jsp:include page="/WEB-INF/views/include/common.jsp" />
    <div class="ic">More Website Templates  @ TemplateMonster.com - August22nd 2011!</div>
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
                                            <div class="grid_12">
                                            	<div class="indent-left p2">
                                                	<h3 class="p0">서울 관광 가이드북 ＆ 관광 지도 신청</h3><br>
                                                	
              
			<!-- content -->
			<section id="content">
						<div class="guidebook_app" >
						<form id="submitform" action="submit.action" method="post"><fieldset>
								<legend>가이드북 신청</legend>
								<p class="info-box">
									<b>1인당 가이드북3권, 지도3권(총6부)까지 무료신청 가능, 배송은 평일 기준 약 5일 소요<br>
									(일반우편 배송이므로 우체국 사정에 따라 달라질 수 있음)</b><br><br>
									- 6부 이하 홍보물을 직접 방문하여 수령하길 원하는 경우, 해당 관광안내소로 방문하시기 바랍니다. <br>
									<button type="button" class="button mt5 mb5 blue" onclick="window.open('http://korean.visitseoul.net/essential-Info-article/서울-관광안내소_/395')" target="_blank">서울 관광안내소 찾기</button><br>
									- 외국어판 홍보물 신청 및 7부 이상 홍보물 신청을 원하시는 경우, 홈페이지 하단에 &lt;홍보물 대량신청 및 기타언어권 소량신청 방법&gt;에 따라 신청하시기 바랍니다.<br>

								</p>
								<ul class="table">
									<li>
									
										<div class="guidebook_img" style="background-image:url(../images/book01.jpg); background-size:cover; background-position:center center;"></div>
										<div>
											<label for="guidebook_type1"><span class="hd-element">서울 관광 가이드북을 신청하세요.</span></label>
											<select name="sub_copies1" id="guidebook_type1">
												<option value="">신청</option>
												<option value="1권">1권</option>
												<option value="2권">2권</option>
												<option value="3권">3권</option>
											</select>
											<span class="heading4">서울 관광 가이드북</span>
											</div>
									</li>
									<li>
										<div class="guidebook_img" style="background-image:url(../images/book02.jpg); background-size:cover; background-position:center center;"></div>
										<div>
											<label for="guidebook_type2"><span class="hd-element">서울 관광 지도를 신청하세요.</span></label>
											<select name="sub_copies2" id="guidebook_type2">
												<option value="">신청</option>
												<option value="1권">1권</option>
												<option value="2권">2권</option>
												<option value="3권">3권</option>
											</select>
											<span class="heading4">서울 관광 지도</span>
											</div>
									</li>
								</ul>
								<% Member member = (Member)session.getAttribute("loginuser"); %>
								<dl class="table">
									<dt><label for="name" class="mt40 heading4">작성자 ID<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%; max-width:100px;"><input id="name" name="sub_writer" type="text" value="<%= member.getMemberId() %>" maxlength="200"/></div>
									</dd>
								</dl>
								<dl class="table">
									<dt><label for="name" class="mt40 heading4">신청자 성명<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%; max-width:100px;"><input id="name" name="sub_writer" type="text" value="" maxlength="200"/></div>
									</dd>
								</dl>
								<dl class="table">
									<dt><label for="email" class="mt40 heading4">e-mail<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%; max-width:200px;"><input id="email" name="sub_email" type="text" value="" size="40" maxlength="200"/></div></dd>
								</dl>
								<dl class="table">
									<dt><label for="telno" class="mt40 heading4">전화번호<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%; max-width:200px;"><input id="telno" name="sub_phone" type="text" value="" size="40" maxlength="200"/></div></dd>
								</dl>
								<dl class="table">
									<dt><label for="adres1" class="mt40 heading4">기본주소<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%;"><input id="adres1" name="sub_addr1" type="text" value="" maxlength="200"/></div></dd>
								</dl>
								<dl class="table">
									<dt><label for="adres2" class="mt40 heading4">상세주소<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%;"><input id="adres2" name="sub_addr2" type="text" value="" maxlength="200"/></div></dd>
								</dl>
								<dl class="table">
									<dt><label for="adres2" class="mt40 heading4">신청이유<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%;"><input id="adres2" name="sub_cause" type="text" value="" maxlength="200"/></div></dd>
								</dl>
								
								<!-- button -->
								<div class="mt40 textcenter">
									<button id="submit" type="submit" class="button fontsize1 bold blue pl-20 pr-20">신청하기</button>
									&nbsp;&nbsp;
									<button type="button" class="button fontsize1 bold grey pl-20 pr-20" id="btnCancel" onclick="location.href='/seoul/seoulmate/list.action' ">목록보기</button>
								</div> 
								
								</fieldset>
								</form>
								

								<div class="info-box-gray mt40">
								<h5>홍보물 대량신청 및 기타 언어권 소량신청 방법</h5>
								<p class="fc-blue mt20">홍보물 7부 이상 대량신청 및 국문 외 기타 언어권 소량신청은 다음 신청서를 작성해주시기 바랍니다.</p>
								<ol class="mt20">
									<li>인터넷 게시 홍보물 다운로드 받은 후 출력하기
									</li>
									<li>신청서 작성 및 신청자 성명란에 직접 날인하기</li>
									<li>날인된 신청서를 메일 또는 팩스로 회신하기<br>E-mail : <a href="seoulmate@helloseoul.com">seoulmate@helloseoul.com</a> / 팩스: 02-3788-0899(팩스로 회신 시, 확인 전화 필수)</li>
								</ol>
								<p class="fc-blue mt20">※ 배송안내
								<ol class="mt20">
									<li style="list-style-type: disc;">대량신청 배송은 주 1회 수요일 오후5시까지 취합하여 목요일 오전에 발송됩니다.</li>
									<li style="list-style-type: disc;">보통은 발송 다음날인 금요일, 내주 초 쯤에 받아볼 수 있으며, 택배이동이 많은 기간에는 배송이 지연됩니다.</li>
									<li style="list-style-type: disc;">배송비용: 6부 이하 외국어버전 홍보물 소량신청인 경우, 무료배송</li>
									<li style="list-style-type: disc;">7부 이상 신청할 경우, 홍보물 1box(200부) 기준 평균 5,000원 착불이며 카드결제 가능</li>
									<li style="list-style-type: disc;">기타 세부사항은 신청서 유의사항 참조</li>
									<li style="list-style-type: none;"><span class="fc-blue">문의전화: 02-3788-0845</span></li>
								</ol>
							</div>


							

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
        </div>

    
    		 <jsp:include page="/WEB-INF/views/include/footer.jsp" />
                
                                                
              
</body>
</html>
 --%>








<%@page import="com.seoul.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  	<title>가이드북 및 지도 신청</title>
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
		$('a#submit').on('click', function(event) {
			$('form#submitform').submit(); //writeform을 서버로 전송처리
			alert('신청이 완료되었습니다.');
			event.preventDefault();
		});
		});
	

	</script>    

</head>
<body id="page3">

		<jsp:include page="/WEB-INF/views/include/header.jsp" />
    	 <jsp:include page="/WEB-INF/views/include/common.jsp" />
    <div class="ic">More Website Templates  @ TemplateMonster.com - August22nd 2011!</div>
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
                                            <div class="grid_12">
                                            	<div class="indent-left p2">
                                                	<h3 class="p0">서울 관광 가이드북 ＆ 관광 지도 신청</h3><br>
                          
			<section id="content">
						<div class="guidebook_app" >
						<form id="submitform" action="submit.action" method="post"><fieldset>
								<legend>가이드북 신청</legend>
								<p class="info-box">
									<b>1인당 가이드북3권, 지도3권(총6부)까지 무료신청 가능, 배송은 평일 기준 약 5일 소요<br>
									(일반우편 배송이므로 우체국 사정에 따라 달라질 수 있음)</b><br><br>
									- 6부 이하 홍보물을 직접 방문하여 수령하길 원하는 경우, 해당 관광안내소로 방문하시기 바랍니다. <br>
									<button type="button" class="button mt5 mb5 blue" onclick="window.open('http://korean.visitseoul.net/essential-Info-article/서울-관광안내소_/395')" target="_blank">서울 관광안내소 찾기</button><br>
									- 외국어판 홍보물 신청 및 7부 이상 홍보물 신청을 원하시는 경우, 홈페이지 하단에 &lt;홍보물 대량신청 및 기타언어권 소량신청 방법&gt;에 따라 신청하시기 바랍니다.<br>

								</p>
								<ul class="table">
									<li>
									
										<div class="guidebook_img" style="background-image:url(../images/book01.jpg); background-size:cover; background-position:center center;"></div>
										<div>
											<label for="guidebook_type1"><span class="hd-element">서울 관광 가이드북을 신청하세요.</span></label>
											<select name="sub_copies1" id="guidebook_type1">
												<option value="">신청</option>
												<option value="1권">1권</option>
												<option value="2권">2권</option>
												<option value="3권">3권</option>
											</select>
											<span class="heading4">서울 관광 가이드북</span>
											</div>
									</li>
									<li>
										<div class="guidebook_img" style="background-image:url(../images/book02.jpg); background-size:cover; background-position:center center;"></div>
										<div>
											<label for="guidebook_type2"><span class="hd-element">서울 관광 지도를 신청하세요.</span></label>
											<select name="sub_copies2" id="guidebook_type2">
												<option value="">신청</option>
												<option value="1권">1권</option>
												<option value="2권">2권</option>
												<option value="3권">3권</option>
											</select>
											<span class="heading4">서울 관광 지도</span>
											</div>
									</li>
								</ul>
								<dl class="table">
									<dt><label for="name" class="mt40 heading4">작성자 ID<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%; max-width:100px;"><input id="name" name="sub_writer" type="text" value="${ loginuser.memberId }" maxlength="200"/></div>
									</dd>
								</dl>
								<dl class="table">
									<dt><label for="name" class="mt40 heading4">신청자 성명<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%; max-width:100px;"><input id="name" name="sub_writer" type="text" value="" maxlength="200"/></div>
									</dd>
								</dl>
								<dl class="table">
									<dt><label for="email" class="mt40 heading4">e-mail<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%; max-width:200px;"><input id="email" name="sub_email" type="text" value="" size="40" maxlength="200"/></div></dd>
								</dl>
								<dl class="table">
									<dt><label for="telno" class="mt40 heading4">전화번호<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%; max-width:200px;"><input id="telno" name="sub_phone" type="text" value="" size="40" maxlength="200"/></div></dd>
								</dl>
								<dl class="table">
									<dt><label for="adres1" class="mt40 heading4">기본주소<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%;"><input id="adres1" name="sub_addr1" type="text" value="" maxlength="200"/></div></dd>
								</dl>
								<dl class="table">
									<dt><label for="adres2" class="mt40 heading4">상세주소<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%;"><input id="adres2" name="sub_addr2" type="text" value="" maxlength="200"/></div></dd>
								</dl>
								<dl class="table">
									<dt><label for="adres2" class="mt40 heading4">신청이유<span class="fc-red">*</span></label></dt>
									<dd><div class="inbox" style="width:95%;"><input id="adres2" name="sub_cause" type="text" value="" maxlength="200"/></div></dd>
								</dl>
								
								<!-- button -->
								<div class="mt40 textcenter">
									<button id="submit" type="submit" class="button fontsize1 bold blue pl-20 pr-20">신청하기</button>
									&nbsp;&nbsp;
									<button type="button" class="button fontsize1 bold grey pl-20 pr-20" id="btnCancel" onclick="location.href='/seoul/seoulmate/list.action' ">목록보기</button>
								</div> 
								
								</fieldset>
								</form>
								

								<div class="info-box-gray mt40">
								<h5>홍보물 대량신청 및 기타 언어권 소량신청 방법</h5>
								<p class="fc-blue mt20">홍보물 7부 이상 대량신청 및 국문 외 기타 언어권 소량신청은 다음 신청서를 작성해주시기 바랍니다.</p>
								<ol class="mt20">
									<li>인터넷 게시 홍보물 다운로드 받은 후 출력하기
									</li>
									<li>신청서 작성 및 신청자 성명란에 직접 날인하기</li>
									<li>날인된 신청서를 메일 또는 팩스로 회신하기<br>E-mail : <a href="seoulmate@helloseoul.com">seoulmate@helloseoul.com</a> / 팩스: 02-3788-0899(팩스로 회신 시, 확인 전화 필수)</li>
								</ol>
								<p class="fc-blue mt20">※ 배송안내
								<ol class="mt20">
									<li style="list-style-type: disc;">대량신청 배송은 주 1회 수요일 오후5시까지 취합하여 목요일 오전에 발송됩니다.</li>
									<li style="list-style-type: disc;">보통은 발송 다음날인 금요일, 내주 초 쯤에 받아볼 수 있으며, 택배이동이 많은 기간에는 배송이 지연됩니다.</li>
									<li style="list-style-type: disc;">배송비용: 6부 이하 외국어버전 홍보물 소량신청인 경우, 무료배송</li>
									<li style="list-style-type: disc;">7부 이상 신청할 경우, 홍보물 1box(200부) 기준 평균 5,000원 착불이며 카드결제 가능</li>
									<li style="list-style-type: disc;">기타 세부사항은 신청서 유의사항 참조</li>
									<li style="list-style-type: none;"><span class="fc-blue">문의전화: 02-3788-0845</span></li>
								</ol>
							</div>


							

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
        </div>

    
    		 <jsp:include page="/WEB-INF/views/include/footer.jsp" />
                
                                                
              
</body>
</html>