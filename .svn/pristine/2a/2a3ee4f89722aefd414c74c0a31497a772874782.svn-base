<%-- <%@page import="com.seoul.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<!DOCTYPE html>

<html>
<head>
   <meta charset="utf-8" />
   <title>가이드 신청서 작성</title>
   
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
   a { text-decoration: none }
   </style>
   <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
   <script type="text/javascript">

		$(function() {
		$('button#submitbtn').on('click', function(event) {
			event.preventDefault();
		//정규표현식을 통한 유효성 검사 (/[]{}/), ^ : 시작, $ : 끝
		//아이디를 8개문자이상 20개 이하 영문자와 숫자로만
		var writer = $('input#writer').val();
		var idExpr = /^[a-zA-Z0-9]{1,20}$/; 
		var result = idExpr.test(writer);
		if (!result) { //result가 실패라면
			alert('아이디는 8~20자리의 영문자와 숫자 조합으로만 가능합니다.');
			$('input#writer').focus(); //실패한 후에 마우스 커서를 아이디쪽으로
			return;
		}
		
		var name = $('input#name').val();
		var nameExpr = /^[가-힣a-zA-Z]{1,30}$/; 
		var result = nameExpr.test(name);
		if (!result) { //result가 실패라면
			alert('이름은 한글 또는 영문자만 가능합니다.');
			$('input#name').focus(); //실패한 후에 마우스 커서를 아이디쪽으로
			return;
		}
		
		var email = $('input#email').val();
		var emailExpr = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var result = emailExpr.test(email);
		if (!result) { //result가 실패라면
			alert('E-Mail의 형식이 올바르지 않습니다.');
			$('#email').focus(); //실패한 후에 마우스 커서를 아이디쪽으로
			return;
		}
		
		var telephone = $('input#telephone').val();
		var telephoneExpr =  /^[0-9]{2,4}-[0-9]{3,4}-[0-9]{4}$/; 
		var result = telephoneExpr.test(telephone);
		if (!result) { //result가 실패라면
			alert('연락처는 000-000(0)-0000 의 형식으로 입력해야 합니다. ');
			$('#telephone').focus(); //실패한 후에 마우스 커서를 아이디쪽으로
			return;
		}
		
		var title = $('#title').val();
		if (title == "") { //result가 실패라면
			alert('제목을 입력해주세요. ');
			$('#title').focus(); //실패한 후에 마우스 커서를 아이디쪽으로
			return;
		}
		
		var intro = $('#intro').val();
		if (intro == "") { //result가 실패라면
			alert('자기소개를 입력해주세요. ');
			$('#intro').focus(); //실패한 후에 마우스 커서를 아이디쪽으로
			return;
		}
		
		 if (confirm("등록하시겠습니까?") == true) {
			 $('form#hongkiat-form').submit(); 
		 } else {
			 return;
		 }
		
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
		
		<div id="wrapping" class="clearfix">
			<section id="aligned">
			
			<% Member member = (Member)session.getAttribute("loginuser"); %>
			<input type="text" name="gub_writer" id="writer"  autocomplete="off" tabindex="1" class="txtinput" value="<%= member.getMemberId() %>" readonly>
			
			<input type="text" name="gub_name" id="name" placeholder="Your name" autocomplete="off" tabindex="1" class="txtinput">
		
			<input type="email" name="gub_email" id="email" placeholder="Your e-mail address" autocomplete="off" tabindex="2" class="txtinput">
		
			<input type="text" name="gub_passno" id="pass" placeholder="Passport No(Optional)" autocomplete="off" tabindex="1" class="txtinput">
		
			<input type="tel" name="gub_phone" id="telephone" placeholder="Phone number" tabindex="4" class="txtinput">
			
			<h4>주요 가이드 희망 분야 </h4>
			<select id="hopearea" name="gub_hopearea" tabindex="6" class="selmenu">
  				<option value="　">-- select one --</option>
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
  		  <option value=" ">-- select one --</option>
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
						<input type="radio" id="low" name="gub_target" value="일반(Normal)">
						<label for="일반(Normal)">일반(Normal)</label>
					</span>
				
					<span class="radiobadge">
						<input type="radio" id="med" name="gub_target" value="외국인(Foreigner)" checked="checked">
						<label for="외국인(Foreign)">외국인(Foreigner)</label>
					</span>
				
					<span class="radiobadge">
						<input type="radio" id="high" name="gub_target" value="장애인(Disabled Person)">
						<label for="장애인(Disabled Person)">장애인(Disabled Person)</label>
					</span>
				</section>
			</section>
		</div>


		<section id="buttons">
		
		
			<div class="mt40 textcenter">
				<button id="submitbtn" type="submit" class="button fontsize1 bold blue pl-20 pr-20">신청하기</button>
				&nbsp;&nbsp;
				<button class="button fontsize1 bold blue pl-20 pr-20" id="btnCancel" onclick="location.href='/seoul/seoulmate/list.action' ">목록보기</button>
			</div> 
		
		
		
			<!-- <input type="reset" id="reset" class="resetbtn" value="Reset">
			<input type="button" id="submitbtn" class="submitbtn" tabindex="7" value="Submit this!">
			<br style="clear:both;"> -->
		</section>
		</form>
	
                                                                                   
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

        </div>
    </section>
    		 <jsp:include page="/WEB-INF/views/include/footer.jsp" />
    
</body>
</html> --%>





<%@page import="com.seoul.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<!DOCTYPE html>

<html>
<head>
   <meta charset="utf-8" />
   <title>가이드 신청서 작성</title>
   
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
   a { text-decoration: none }
   </style>
   <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
   <script type="text/javascript">

		$(function() {
		$('button#submitbtn').on('click', function(event) {
			event.preventDefault();
		//정규표현식을 통한 유효성 검사 (/[]{}/), ^ : 시작, $ : 끝
		//아이디를 8개문자이상 20개 이하 영문자와 숫자로만
		var writer = $('input#writer').val();
		var idExpr = /^[a-zA-Z0-9]{1,20}$/; 
		var result = idExpr.test(writer);
		if (!result) { //result가 실패라면
			alert('아이디는 8~20자리의 영문자와 숫자 조합으로만 가능합니다.');
			$('input#writer').focus(); //실패한 후에 마우스 커서를 아이디쪽으로
			return;
		}
		
		var name = $('input#name').val();
		var nameExpr = /^[가-힣a-zA-Z]{1,30}$/; 
		var result = nameExpr.test(name);
		if (!result) { //result가 실패라면
			alert('이름은 한글 또는 영문자만 가능합니다.');
			$('input#name').focus(); //실패한 후에 마우스 커서를 아이디쪽으로
			return;
		}
		
		var email = $('input#email').val();
		var emailExpr = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var result = emailExpr.test(email);
		if (!result) { //result가 실패라면
			alert('E-Mail의 형식이 올바르지 않습니다.');
			$('#email').focus(); //실패한 후에 마우스 커서를 아이디쪽으로
			return;
		}
		
		var telephone = $('input#telephone').val();
		var telephoneExpr =  /^[0-9]{2,4}-[0-9]{3,4}-[0-9]{4}$/; 
		var result = telephoneExpr.test(telephone);
		if (!result) { //result가 실패라면
			alert('연락처는 000-000(0)-0000 의 형식으로 입력해야 합니다. ');
			$('#telephone').focus(); //실패한 후에 마우스 커서를 아이디쪽으로
			return;
		}
		
		var title = $('#title').val();
		if (title == "") { //result가 실패라면
			alert('제목을 입력해주세요. ');
			$('#title').focus(); //실패한 후에 마우스 커서를 아이디쪽으로
			return;
		}
		
		var intro = $('#intro').val();
		if (intro == "") { //result가 실패라면
			alert('자기소개를 입력해주세요. ');
			$('#intro').focus(); //실패한 후에 마우스 커서를 아이디쪽으로
			return;
		}
		
		 if (confirm("등록하시겠습니까?") == true) {
			 $('form#hongkiat-form').submit(); 
		 } else {
			 return;
		 }
		
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
		
		<div id="wrapping" class="clearfix">
			<section id="aligned">
			
			<%-- <% Member member = (Member)session.getAttribute("loginuser"); %> --%>
			<input type="text" name="gub_writer" id="writer"  autocomplete="off" tabindex="1" class="txtinput" value="${ loginuser.memberId }" readonly>
			
			<input type="text" name="gub_name" id="name" placeholder="Your name" autocomplete="off" tabindex="1" class="txtinput">
		
			<input type="email" name="gub_email" id="email" placeholder="Your e-mail address" autocomplete="off" tabindex="2" class="txtinput">
		
			<input type="text" name="gub_passno" id="pass" placeholder="Passport No(Optional)" autocomplete="off" tabindex="1" class="txtinput">
		
			<input type="tel" name="gub_phone" id="telephone" placeholder="Phone number" tabindex="4" class="txtinput">
			
			<h4>주요 가이드 희망 분야 </h4>
			<select id="hopearea" name="gub_hopearea" tabindex="6" class="selmenu">
  				<option value="　">-- select one --</option>
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
  		  <option value=" ">-- select one --</option>
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
						<input type="radio" id="low" name="gub_target" value="일반(Normal)">
						<label for="일반(Normal)">일반(Normal)</label>
					</span>
				
					<span class="radiobadge">
						<input type="radio" id="med" name="gub_target" value="외국인(Foreigner)" checked="checked">
						<label for="외국인(Foreign)">외국인(Foreigner)</label>
					</span>
				
					<span class="radiobadge">
						<input type="radio" id="high" name="gub_target" value="장애인(Disabled Person)">
						<label for="장애인(Disabled Person)">장애인(Disabled Person)</label>
					</span>
				</section>
			</section>
		</div>


		<section id="buttons">
		
		
			<div class="mt40 textcenter">
				<button id="submitbtn" type="submit" class="button fontsize1 bold blue pl-20 pr-20">신청하기</button>
				&nbsp;&nbsp;
				<button class="button fontsize1 bold blue pl-20 pr-20" id="btnCancel" onclick="location.href='/seoul/seoulmate/list.action' ">목록보기</button>
			</div> 
		
		
		
			<!-- <input type="reset" id="reset" class="resetbtn" value="Reset">
			<input type="button" id="submitbtn" class="submitbtn" tabindex="7" value="Submit this!">
			<br style="clear:both;"> -->
		</section>
		</form>
	
                                                                                   
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

        </div>
    </section>
    		 <jsp:include page="/WEB-INF/views/include/footer.jsp" />
    
</body>
</html>








