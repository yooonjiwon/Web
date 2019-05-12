
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>파일업로드</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/styles/input2.css" />	
	<style type="text/css">
	a { text-decoration: none }
	</style>
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript">
	$(function() {
		$('a#fileupload').on('click', function(event) {
			$('form#fileuploadform').submit(); //writeform을 서버로 전송처리
			var ok = alert('파일이 업로드 되었습니다.');
			window.close();
			event.preventDefault(); //<a>의 기본기능(화면 리프레시) 수행을 막는 명령
		});
	});
	
	$(function() {
		$('a#fileupload').on('click', function(event) {
			$('form#fileuploadform').submit(); //writeform을 서버로 전송처리
			var ok = alert('파일이 업로드 되었습니다.');
			window.close();
			event.preventDefault(); //<a>의 기본기능(화면 리프레시) 수행을 막는 명령
		});
	});

	</script>
</head>
<body>

		        <form id="fileuploadform" action="fileupload.action" method="post" enctype="multipart/form-data">
		        <table>
		          
		            <tr>
		                <th>파일</th>
		                <td>		                    
		                    <input type="file" name="attach">
		                </td>
		            </tr>
		           
		        </table>
		        <div class="buttons">
		        	<!-- <form>의 submit수행 -->	        	
		        	<a id="fileupload0" href="#">파일 올리기</a>
		        	&nbsp;&nbsp;
		        	<a href="#">취소</a>
		        </div>
		        </form>
		        
		    
		        
		        
		    <h1>FileUplad 실습</h1>
    <form action="Upload.action" method="post" enctype="multipart/form-data">
    작성자<input type="text" name="theAuthor"><br>
    파일<input type="file" name="theFile"><br>
    <input type = "submit" id = "fileupload" value="업로드">
    </form>




		        

</body>
</html>