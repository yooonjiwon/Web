<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	
	<!-- list실행창 타이틀 -->
	<title>웨이트 운동 목록</title>
	<link rel="Stylesheet" href="/dieat/resources/styles/default.css" />
	<link rel="stylesheet" href="/dieat/resources/styles/main.css" />
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript">
	 
	//데이타 등록클릭 링크이벤트
	$('#write').on('click', function(event) {
		location.href = 'weight-write.action';
	});	
	</script>	
</head>
<body>
<!-- ---------------------------Header-------------------------------- -->
	<jsp:include page="/WEB-INF/views/include/header.jsp" flush="true">
    	<jsp:param name="bg-color" value="palegreen" />
    </jsp:include>
<!-- ---------------------------Content------------------------------- -->	
	
	<!-- list틀 만들기 -->
	<table align="center">
		<tr style="background-color:palegreen; height:25px" >
			<th style="width:30px">번호</th>
			<th style="width:150px">운동명</th>
			<th style="width:80px">운동부위</th>
			<th style="width:50px">칼로리</th>
			<th style="width:250px">운동방법</th>
		</tr>
	</table>
	
	<!-- Button -->
	<div>
		<div style="padding-top:25px;text-align:center">
			<input id="write" type="button" value="글등록" style="width:80px; height:40px" />
		</div>
	</div>
	
<!-- ----------------------------footer-------------------------------- -->
	<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="true">
    	<jsp:param name="bg-color" value="palegreen" />
    </jsp:include>

</body>
</html>