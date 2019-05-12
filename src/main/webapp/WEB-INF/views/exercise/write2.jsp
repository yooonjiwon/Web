<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    	 
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	
	<!-- write실행창 타이틀 -->
	<title>운동종류등록</title>
	<link rel="Stylesheet" href="/dieat/resources/styles/default.css" />
	<link rel="Stylesheet" href="/dieat/resources/styles/input2.css" />
	<link rel="stylesheet" href="/dieat/resources/styles/main.css" />
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript">
	
	//데이타 등록클릭 링크이벤트
	$(function() {
		$('a#write').on('click', function(event) {
			$('form#writeform').submit();
			event.preventDefault();
		});
	});
	</script>	
</head>
<body>
<!-- ---------------------------Header-------------------------------- -->
	<jsp:include page="/WEB-INF/views/include/header.jsp" flush="true">
    	<jsp:param name="bg-color" value="palegreen" />
    </jsp:include>
<!-- ---------------------------Content------------------------------- -->

	<!-- write틀 만들기 -->
	<div style="padding-top:20px; text-align:center" >
		<div>
			<div>
				<div>운동종류등록</div>
				<form id="writeform" action="weight-write.action" method="post">
					<table>
						<tr>
							<th>운동명</th>
							<td>
								<input type="text" name="title" style="width:150px" />
							</td>
						</tr>
						<tr>
							<th>운동부위</th>
							<td>
								<input type="text" name="type" style="width:100px" />
							</td>
						</tr>
						<tr>
							<th>칼로리</th>
							<td>
								<input type="text" name="cal" style="width:50px" />
							</td>
						</tr>
						<tr>
							<th>운동방법</th>
							<td>
								<textarea name="content" cols="76" rows="15" />
							</td>
						</tr>
					</table>
					<div class="buttons">
						<a id="write" href="#">글등록</a>
						<a href="/dieat/exercise/weight-list.action">목록</a>
					</div>
				</form>
			</div>
		</div>
	</div>

<!-- ----------------------------footer-------------------------------- -->
	<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="true">
    	<jsp:param name="bg-color" value="palegreen" />
    </jsp:include>

</body>
</html>
