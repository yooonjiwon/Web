<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <footer>
			<div class="container_12">
				<div class="grid_12">
					<div class="f_logo">
						<a href="index.html">Marathon</a>
					</div>
					<div class="f_contacts">
						<a href="#" class="mail_link"><span class="fa fa-envelope"></span> MAIL@DEMOLINK.ORG</a>
						<div class="f_phone"><span class="fa fa-phone"></span>+1 800 559 6580</div>
					</div>
					<div class="copy">
						<span>Marathon &copy; 2014 | <a href="#">Privacy Policy</a></span>
						Website designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster.com</a>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</footer>
		<script src="/dieat/resources/js/jquery.countdown.js"></script>
		<script src="/dieat/resources/js/cd_config.js"></script>
		<script src="/dieat/resources/js/modernizr.custom.69142.js"></script>
		<script type="text/javascript">
			Modernizr.load({
				test: Modernizr.csstransforms3d && Modernizr.csstransitions,
				yep : ['http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js','js/jquery.hoverfold.js'],
				nope: 'css/fallback.css',
				callback : function( url, result, key ) {
					if( url === 'js/jquery.hoverfold.js' ) {
						$( '#grid' ).hoverfold();
					}
				}
			});
		</script>
	</body>
   