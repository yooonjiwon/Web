<%@page import="com.seoul.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<!DOCTYPE html>

<html>
<head>
   <meta charset="utf-8" />
   <title>글쓰기</title>
   
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="author">
  <link rel="shortcut icon" href="http://static02.hongkiat.com/logo/hkdc/favicon.ico">
  <link rel="icon" href="http://static02.hongkiat.com/logo/hkdc/favicon.ico">
  <link rel="stylesheet" type="text/css" media="all" href="/seoul/css/responsive1.css">
  <link rel="stylesheet" type="text/css" media="all" href="/seoul/css/responsive.css">

    <script src="js/jquery-1.6.2.min.js" type="text/javascript"></script> 
    <script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
    <script src="js/jcarousellite_1.0.1.js" type="text/javascript"></script>
    <script src="js/jquery.galleriffic.js" type="text/javascript"></script>
    <script src="js/jquery.opacityrollover.js" type="text/javascript"></script> 
  
  
    
   <style type="text/css">
   </style>
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
</head>
<body id="page30">
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
    <jsp:include page="/WEB-INF/views/include/common.jsp" />
    
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
                                                	<h3 class="p0">가이드 신청하기(Guide Apply)</h3>
                                                </div>
                                                
                                                
          
          
	<section id="container">
		<span class="chyron"><a href="/seoul/seoulmate/list.action">&laquo; 돌아가기</a></em></span>
		<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    [Apply for a Seoul Guide]</h2>
		    
		<form name="hongkiat" id="hongkiat-form" action="write.action" method="post">
		
		
		  <table>
		            <tr>
		                <th>제목</th><%-- 
		                 <td><%= board.getTitle() %></td>  --%>
		                <td>${ requestScope.board.title }</td> <!-- requestScope는 안써도 잘찾음 -->
		            </tr>
		            <tr>
		                <th>작성자</th>
		               <%--  <td><%= board.getWriter() %></td> --%>
		               <td>${ board.writer }</td>
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <%-- <td><%= board.getRegDate() %></td> --%>
		                <td>${ board.regDate }</td>
		            </tr>
					<tr>
		                <th>조회수</th>
		               <%--  <td><%= board.getReadCount() %></td> --%>
		               <td>${ board.readCount }</td>
		            </tr>
		            <tr>
		                <th>첨부파일</th>
		                <td>
		                <%-- <% Board board = (Board)request.getAttribute("board"); %> --%>
		                <%-- <% for (BoardAttach attachment : board.getAttachments()) { %> --%>
		                <c:forEach var="attachment" items="${ board.attachments }">
		                [ <a href="download.action?attachno=${ attachment.attachNo() }">
		                ${ attachment.userFileName }
		                	</a> ]
		                	<br>
		                	</c:forEach>
		                </td>
		            </tr>
		            
		            <tr>
		                <th>내용</th>
		                <td style="height:200px;vertical-align:top">		
		                	<!-- replace를 이용해서 엔터기능 할 수 있도록 수정 -->   
		                	<!-- c:set은 변수를 만드는기능, 여기선 역슬래쉬를 인식하지 못하기때문에 실제 엔터로 적용함 -->                 
		                    <%-- <%= board.getContent().replace("\r\n", "<br>") %> 원래 있던 구문 --%> 
		                    
<%-- 		                    <c:set var="newLine" value="
" />
		                    ${ fn:replace(board.content, newLine, "<br>" )} --%>
		                    <%-- <%= board.getContent().replace("\r\n", "<br>") %> --%>
		                    
		                </td>
		            </tr>
		        </table>
		
		
		
		
		
		<div id="wrapping" class="clearfix">
			<section id="aligned">
			
			<% Member member = (Member)session.getAttribute("loginuser"); %>
			<input type="text" name="gub_writer" id="writer"  autocomplete="off" tabindex="1" class="txtinput" value="<%= member.getMemberId() %>">
			
			<input type="text" name="gub_name" id="name" placeholder="Your name" autocomplete="off" tabindex="1" class="txtinput">
		
			<input type="email" name="gub_email" id="email" placeholder="Your e-mail address" autocomplete="off" tabindex="2" class="txtinput">
		
			<input type="text" name="gub_passno" id="pass" placeholder="Passport No(Optional)" autocomplete="off" tabindex="1" class="txtinput">
		
			<input type="tel" name="gub_phone" id="telephone" placeholder="Phone number" tabindex="4" class="txtinput">
			
			<h4>주요 가이드 희망 분야 </h4>
			<select id="hopearea" name="gub_hopearea" tabindex="6" class="selmenu">
  				<option value="">-- select one --</option>
          		<option value="문화 관광">문화 관광</option>
          		<option value="맛집 관광">맛집 관광</option>
          		<option value="의료 관광">의료 관광</option>
          		<option value="쇼핑 관광">쇼핑 관광</option>
          	</select><br><br>
			
			<input type="text" name="gub_title" id="title" placeholder="Title" tabindex="4" class="txtinput">
			
			<textarea name="gub_intro" id="intro" placeholder="Intro" tabindex="5" class="txtblock"></textarea>
			</section>
			
			<section id="aside" class="clearfix">
				<section id="recipientcase">
				<h4>국적(Nationality) </h4><br>
					<select id="nation" name="gub_nation" tabindex="6" class="selmenu">
  		  <option value="">-- select one --</option>
          <option value="afghan">Afghan</option>
          <option value="albanian">Albanian</option>
          <option value="algerian">Algerian</option>
          <option value="american">American</option>
          <option value="andorran">Andorran</option>
          <option value="angolan">Angolan</option>
          <option value="antiguans">Antiguans</option>
          <option value="argentinean">Argentinean</option>
          <option value="armenian">Armenian</option>
          <option value="australian">Australian</option>
          <option value="austrian">Austrian</option>
          <option value="azerbaijani">Azerbaijani</option>
          <option value="bahamian">Bahamian</option>
          <option value="bahraini">Bahraini</option>
          <option value="bangladeshi">Bangladeshi</option>
          <option value="barbadian">Barbadian</option>
          <option value="barbudans">Barbudans</option>
          <option value="batswana">Batswana</option>
          <option value="belarusian">Belarusian</option>
          <option value="belgian">Belgian</option>
          <option value="belizean">Belizean</option>
          <option value="beninese">Beninese</option>
          <option value="bhutanese">Bhutanese</option>
          <option value="bolivian">Bolivian</option>
          <option value="bosnian">Bosnian</option>
          <option value="brazilian">Brazilian</option>
          <option value="british">British</option>
          <option value="bruneian">Bruneian</option>
          <option value="bulgarian">Bulgarian</option>
          <option value="burkinabe">Burkinabe</option>
          <option value="burmese">Burmese</option>
          <option value="burundian">Burundian</option>
          <option value="cambodian">Cambodian</option>
          <option value="cameroonian">Cameroonian</option>
          <option value="canadian">Canadian</option>
          <option value="cape verdean">Cape Verdean</option>
          <option value="central african">Central African</option>
          <option value="chadian">Chadian</option>
          <option value="chilean">Chilean</option>
          <option value="chinese">Chinese</option>
          <option value="colombian">Colombian</option>
          <option value="comoran">Comoran</option>
          <option value="congolese">Congolese</option>
          <option value="costa rican">Costa Rican</option>
          <option value="croatian">Croatian</option>
          <option value="cuban">Cuban</option>
          <option value="cypriot">Cypriot</option>
          <option value="czech">Czech</option>
          <option value="danish">Danish</option>
          <option value="djibouti">Djibouti</option>
          <option value="dominican">Dominican</option>
          <option value="dutch">Dutch</option>
          <option value="east timorese">East Timorese</option>
          <option value="ecuadorean">Ecuadorean</option>
          <option value="egyptian">Egyptian</option>
          <option value="emirian">Emirian</option>
          <option value="equatorial guinean">Equatorial Guinean</option>
          <option value="eritrean">Eritrean</option>
          <option value="estonian">Estonian</option>
          <option value="ethiopian">Ethiopian</option>
          <option value="fijian">Fijian</option>
          <option value="filipino">Filipino</option>
          <option value="finnish">Finnish</option>
          <option value="french">French</option>
          <option value="gabonese">Gabonese</option>
          <option value="gambian">Gambian</option>
          <option value="georgian">Georgian</option>
          <option value="german">German</option>
          <option value="ghanaian">Ghanaian</option>
          <option value="greek">Greek</option>
          <option value="grenadian">Grenadian</option>
          <option value="guatemalan">Guatemalan</option>
          <option value="guinea-bissauan">Guinea-Bissauan</option>
          <option value="guinean">Guinean</option>
          <option value="guyanese">Guyanese</option>
          <option value="haitian">Haitian</option>
          <option value="herzegovinian">Herzegovinian</option>
          <option value="honduran">Honduran</option>
          <option value="hungarian">Hungarian</option>
          <option value="icelander">Icelander</option>
          <option value="indian">Indian</option>
          <option value="indonesian">Indonesian</option>
          <option value="iranian">Iranian</option>
          <option value="iraqi">Iraqi</option>
          <option value="irish">Irish</option>
          <option value="israeli">Israeli</option>
          <option value="italian">Italian</option>
          <option value="ivorian">Ivorian</option>
          <option value="jamaican">Jamaican</option>
          <option value="japanese">Japanese</option>
          <option value="jordanian">Jordanian</option>
          <option value="kazakhstani">Kazakhstani</option>
          <option value="kenyan">Kenyan</option>
          <option value="kittian and nevisian">Kittian and Nevisian</option>
          <option value="kuwaiti">Kuwaiti</option>
          <option value="kyrgyz">Kyrgyz</option>
          <option value="laotian">Laotian</option>
          <option value="latvian">Latvian</option>
          <option value="lebanese">Lebanese</option>
          <option value="liberian">Liberian</option>
          <option value="libyan">Libyan</option>
          <option value="liechtensteiner">Liechtensteiner</option>
          <option value="lithuanian">Lithuanian</option>
          <option value="luxembourger">Luxembourger</option>
          <option value="macedonian">Macedonian</option>
          <option value="malagasy">Malagasy</option>
          <option value="malawian">Malawian</option>
          <option value="malaysian">Malaysian</option>
          <option value="maldivan">Maldivan</option>
          <option value="malian">Malian</option>
          <option value="maltese">Maltese</option>
          <option value="marshallese">Marshallese</option>
          <option value="mauritanian">Mauritanian</option>
          <option value="mauritian">Mauritian</option>
          <option value="mexican">Mexican</option>
          <option value="micronesian">Micronesian</option>
          <option value="moldovan">Moldovan</option>
          <option value="monacan">Monacan</option>
          <option value="mongolian">Mongolian</option>
          <option value="moroccan">Moroccan</option>
          <option value="mosotho">Mosotho</option>
          <option value="motswana">Motswana</option>
          <option value="mozambican">Mozambican</option>
          <option value="namibian">Namibian</option>
          <option value="nauruan">Nauruan</option>
          <option value="nepalese">Nepalese</option>
          <option value="new zealander">New Zealander</option>
          <option value="ni-vanuatu">Ni-Vanuatu</option>
          <option value="nicaraguan">Nicaraguan</option>
          <option value="nigerien">Nigerien</option>
          <option value="north korean">North Korean</option>
          <option value="northern irish">Northern Irish</option>
          <option value="norwegian">Norwegian</option>
          <option value="omani">Omani</option>
          <option value="pakistani">Pakistani</option>
          <option value="palauan">Palauan</option>
          <option value="panamanian">Panamanian</option>
          <option value="papua new guinean">Papua New Guinean</option>
          <option value="paraguayan">Paraguayan</option>
          <option value="peruvian">Peruvian</option>
          <option value="polish">Polish</option>
          <option value="portuguese">Portuguese</option>
          <option value="qatari">Qatari</option>
          <option value="romanian">Romanian</option>
          <option value="russian">Russian</option>
          <option value="rwandan">Rwandan</option>
          <option value="saint lucian">Saint Lucian</option>
          <option value="salvadoran">Salvadoran</option>
          <option value="samoan">Samoan</option>
          <option value="san marinese">San Marinese</option>
          <option value="sao tomean">Sao Tomean</option>
          <option value="saudi">Saudi</option>
          <option value="scottish">Scottish</option>
          <option value="senegalese">Senegalese</option>
          <option value="serbian">Serbian</option>
          <option value="seychellois">Seychellois</option>
          <option value="sierra leonean">Sierra Leonean</option>
          <option value="singaporean">Singaporean</option>
          <option value="slovakian">Slovakian</option>
          <option value="slovenian">Slovenian</option>
          <option value="solomon islander">Solomon Islander</option>
          <option value="somali">Somali</option>
          <option value="south african">South African</option>
          <option value="south korean">South Korean</option>
          <option value="spanish">Spanish</option>
          <option value="sri lankan">Sri Lankan</option>
          <option value="sudanese">Sudanese</option>
          <option value="surinamer">Surinamer</option>
          <option value="swazi">Swazi</option>
          <option value="swedish">Swedish</option>
          <option value="swiss">Swiss</option>
          <option value="syrian">Syrian</option>
          <option value="taiwanese">Taiwanese</option>
          <option value="tajik">Tajik</option>
          <option value="tanzanian">Tanzanian</option>
          <option value="thai">Thai</option>
          <option value="togolese">Togolese</option>
          <option value="tongan">Tongan</option>
          <option value="trinidadian or tobagonian">Trinidadian or Tobagonian</option>
          <option value="tunisian">Tunisian</option>
          <option value="turkish">Turkish</option>
          <option value="tuvaluan">Tuvaluan</option>
          <option value="ugandan">Ugandan</option>
          <option value="ukrainian">Ukrainian</option>
          <option value="uruguayan">Uruguayan</option>
          <option value="uzbekistani">Uzbekistani</option>
          <option value="venezuelan">Venezuelan</option>
          <option value="vietnamese">Vietnamese</option>
          <option value="welsh">Welsh</option>
          <option value="yemenite">Yemenite</option>
          <option value="zambian">Zambian</option>
          <option value="zimbabwean">Zimbabwean</option>
					</select>
				</section>
				<br><br><br>
				
				<section id="prioritycase">
					<h4>희망 대상(Target):</h4><br>
					<span class="radiobadge">
						<input type="radio" id="low" name="gub_target" value="low">
						<label for="low">일반(Normal)</label>
					</span>
				
					<span class="radiobadge">
						<input type="radio" id="med" name="gub_target" value="med" checked="checked">
						<label for="med">외국인(Foreign)</label>
					</span>
				
					<span class="radiobadge">
						<input type="radio" id="high" name="gub_target" value="high">
						<label for="high">장애인(Disabled Person)</label>
					</span>
				</section>
			</section>
		</div>


		<section id="buttons">
			<input type="reset" id="reset" class="resetbtn" value="Reset">
			<input type="button" id="submitbtn" class="submitbtn" tabindex="7" value="Submit this!">
			<br style="clear:both;">
		</section>
		</form>
	
	
	                                      
                                                
                                                
                                                
                                                
                                                <section id="content"> 
                                                                                   
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
          
        <div class="bg-bot">
        	<div class="main">
            	<div class="container_12">
                	<div class="wrapper">
                    	<article class="grid_4">
                        	<h3 class="p2">New Furniture</h3>
                            <div class="wrapper">
                            	<figure class="img-indent frame2"><img src="images/page4-img7.jpg" alt="" /></figure>
                                <p class="prev-indent-bot color-4">At vero eos eaccusa mus etusto odio.</p>
                                <p class="prev-indent-bot">Tium voluptatum del eniti atque corrupti quos dolores.</p>
                                <a class="button" href="#">View More</a>
                            </div>
                        </article>
                        <article class="grid_8">
                        	<h3 class="prev-indent-bot2">Our Pricing</h3>
                            <div class="wrapper">
                            	<div class="grid_4 alpha">
                                	<div class="indent-right2">
                                        <ul class="price-list">
                                            <li><span>$6700.00</span><a href="#">Totam rem aperiam eaque</a><strong>&nbsp;</strong></li>
                                            <li><span>$4370.00</span><a href="#">Inventore veritatis quasi</a><strong>&nbsp;</strong></li>
                                            <li><span>$5780.00</span><a href="#">Nemo enim ipsam voluptatem</a><strong>&nbsp;</strong></li>
                                            <li><span>$2300.00</span><a href="#">Voluptas sit aspernatur aut</a><strong>&nbsp;</strong></li>
                                            <li><span>$3650.00</span><a href="#">Sed quia consequuntur magni</a><strong>&nbsp;</strong></li>
                                            <li class="last"><span>$7900.00</span><a href="#">Ratione voluptatem sequi</a><strong>&nbsp;</strong></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="grid_4 omega">
                                	<div class="indent-right2">
                                        <ul class="price-list">
                                            <li><span>$6700.00</span><a href="#">Totam rem aperiam eaque</a><strong>&nbsp;</strong></li>
                                            <li><span>$4370.00</span><a href="#">Inventore veritatis quasi</a><strong>&nbsp;</strong></li>
                                            <li><span>$5780.00</span><a href="#">Nemo enim ipsam voluptatem</a><strong>&nbsp;</strong></li>
                                            <li><span>$2300.00</span><a href="#">Voluptas sit aspernatur aut</a><strong>&nbsp;</strong></li>
                                            <li><span>$3650.00</span><a href="#">Sed quia consequuntur magni</a><strong>&nbsp;</strong></li>
                                            <li class="last"><span>$7900.00</span><a href="#">Ratione voluptatem sequi</a><strong>&nbsp;</strong></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </article>
                    </div>
                </div>
            </div>
        </div>
    </section>
    </section>
    
    		 <jsp:include page="/WEB-INF/views/include/footer.jsp" />
    
</body>
</html>