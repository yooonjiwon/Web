<%@page import="com.seoul.dto.Guide"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="utf-8">
    <!-- <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">
    <script src="js/jquery-1.6.2.min.js"></script> -->
    <jsp:include page="/WEB-INF/views/include/common.jsp" />
   	<script type="text/javascript">
  	$(function() {
  		$('#informationwrite').on('click', function(event) {
  			location.href = 'write3.action';
  		});
  	});
	</script>
         
	<!--[if lt IE 7]>
        <div style=' clear: both; text-align:center; position: relative;'>
            <a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0"  alt="" /></a>
        </div>
	<![endif]-->
    <!--[if lt IE 9]>
   		<script type="text/javascript" src="js/html5.js"></script>
        <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen">
	<![endif]-->
</head>
<body id="page2">

	<jsp:include page="/WEB-INF/views/include/header.jsp" />

<!-- content -->
    <section id="content">
        <div class="bg-top">
        	<div class="bg-top-2">
                <div class="bg">
                    <div class="bg-top-shadow">
                        <div class="main">
                            <div class="box p3">
                                <div class="padding">
                                    <div class="container_12">
                                        <div class="wrapper">
                                            <div class="grid_12">
                                                <div class="wrapper">
                                                    <article class="grid_4 alpha">
                                                        <div class="indent">
                                                            <h3 class="prev-indent-bot2">Seoul Tour</h3>
                                                            <ul class="list-2">
                                                            	<li><a href="/seoul/information/list3.action">도봉, 강북, 성북, 노원 </a></li>                                                                
                                                                <li><a href="/seoul/information/list32.action">동대문, 중랑, 성동, 광진</a></li>
                                                                <li><a href="/seoul/information/list33.action">강동, 송파</a></li>
                                                                <li><a href="/seoul/information/list34.action">서초, 강남</a></li>
                                                                <li><a href="/seoul/information/list35.action">동작, 관악, 금천</a></li>
                                                               <li><a href="/seoul/information/list36.action">강서, 양천, 영등포, 구로</a></li>
																<li><a href="/seoul/information/list37.action">은평, 마포, 서대문</a></li>
																<li><a href="/seoul/information/list38.action">종로, 중구, 용산</a></li>
                                                            </ul>
                                                        </div>
                                                    </article>
                                                    <article class="grid_8 omega">
                                                        
                                                        
                                                        <div class="indent-right">
                                                            <h3 class="p2">Tourist Information</h3>
                                                            <div class="wrapper prev-indent-bot2">
                                                                <figure class="img-indent1 frame1"><img src="../images/seoul.jpg" alt="" /></figure>
                                                                <div class="extra-wrap"><br>
                                                                    <h6 class="prev-indent-bot">한반도 중앙부에 있는 대한민국의 수도. </h6>
                                                                    대한민국의 수도인 서울을 지방자치단체인 특별시로 부르는 명칭이다. 한반도 중앙에 있으며, 한강을 사이에 두고 남북으로 펼쳐져 있다. 북쪽 끝은 도봉구 도봉동, 동쪽 끝은 강동구 상일동, 남쪽 끝은 서초구 원지동, 서쪽 끝은 강서구 오곡동이다. 시청은 중구 을지로1가(태평로1가 31)에 있다.

                                                                </div>
                                                            </div>
                                                            <p>한반도의 0.28%(남한 면적의 0.61%)에 해당하는 넓이로, 남북간 연장거리 30.30km, 동서간 연장거리 36.78km이다. 1394년(태조 3)부터 한국의 수도가 되어 정치·경제·산업·사회·문화·교통의 중심지가 되어 왔다. 1960년대 이후 경제발전과 함께 도시화가 진행되면서 통근 및 거주지역이 반경 30km 내의 주변 수도권에 광역적으로 확장되고 있어, 거대도시(Megalopolis)가 되고 있다. 서울 정도(定都) 600년인 1994년에 10월 28일이 서울시민의 날로 제정되어 이후 각종 행사가 열리고 있다. 1988년 국제올림픽이 열렸고, 2010년 G20, 2012년 핵안보정상회의가 열렸다.
자매도시는 타이베이[臺北京:1993.10.23]·울란바토르(1995.10.6)·하노이(1996.5.1)·바르샤바(1996.6.20)·카이로(1997.4.27)·로마(2000.3.18) 등 17개국의 18개 도시이다.

서울특별시를 상징하는 꽃은 개나리, 나무는 은행나무, 새는 까치이며, 캐릭터는 해치라는 전설에 나오는 동물이다.</p>
                                                            <a class="button" href="#">Read More</a>
                                                            <!-- <a class="button" href="write3.action">눌러봥~♥</a> -->                                                                                                                
                                                        </div>                                                        
                                                    </article>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="container_12">
                            	<div class="wrapper">
                                	<article class="grid_4">
                                    	<h3 class="color-1 p2">Seoul Foundation</h3>
                                        <span class="text-1">It was established on March 15, 2005 by Seoul Metropolitan Goverment to raise the quality of life through culture and arts and to enhance Seoul's urban competitiveness. <br></span>
                                    </article>
                                    <article class="grid_4">
                                    	<h3 class="color-1 p2">Culture</h3>
                                        <span class="text-1">Major projects include the creation of cultural arts creation environment, the expansion of cultural services with citizens, the enhancement of Seoul's cultural competitiveness. </span>
                                    </article>
                                    <article class="grid_4">
                                    	<h3 class="color-1 indent-bot">Consultation</h3>
                                        <form id="subscribe-form" method="post" enctype="multipart/form-data">                    
                                            <fieldset>
                                                  <div class="subscribe-field">
                                                  	<input type="text" />
                                                  </div>
                                                  <a class="button" href="#" onClick="document.getElementById('subscribe-form').submit()">Subscribe</a>        
                                            </fieldset>						
                                        </form>
                                    </article>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>	
        </div>

    </section>
    
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>
