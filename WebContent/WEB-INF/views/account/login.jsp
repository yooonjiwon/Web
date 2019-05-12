<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    
<!DOCTYPE html>

<html>
<head>
  <title>Login Form</title>  
  <meta charset="utf-8">
  <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script> -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/seoul/css/style3.css">
</head>
<body>

		<form action="login.action" method="post">
        <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
            <a href="/seoul/index.action">
			<div>Hello<span>Seoul</span></div></a>
            <br><br><br><br><br><br><br>
            <br><br><br><br>
            <hr class="style">
            <h3>간편하게 로그인하기</h3>
            <a href="#" style="text-decoration:none; color: white"> Sign in with Facebook </a>
            &nbsp;&nbsp;&nbsp;
            <a href="#" style="text-decoration:none; color: white"> Sign in with Google</a>
		</div>
    
		<br>
		<div class="login">
				<input type="text" placeholder="id" name="memberId" /><br>
				<input type="password" placeholder="password" name="passwd" /><br>
			<input type="submit" value="Login" name="submit" >
             
            <!-- Trigger the modal with a link-->
            <br><br>
            <a data-toggle="modal" href="#myModal" style="font-size: 18px; color: white; font-family: 고딕">비밀번호 찾기</a> 
                    
                    

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/seoul/account/signup.action" style="font-size: 18px; color: white">회원가입</a>
		        <br><br>
    </div>
        
       
        <hr class="style">

  
  </form>
  
  
  
  <!--Modal-->
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content" style="color: black; text-size: 13px;" >

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" >&times;</button>
							<h4 class="modal-title" >비밀번호 찾기</h4>
						</div>

						<div class="modal-body">
							<div class="modal-form">
								<p>
									&nbsp;&nbsp;비밀번호를 다시 설정하시겠습니까?<br> &nbsp;&nbsp;HelloSeoul 회원가입시 입력했던 이메일을 입력해주세요.
									<br> &nbsp;&nbsp;비밀번호 재전송 코드를 보내드리겠습니다.
								</p>
								&nbsp; <input type="text" placeholder="email" name="email" style="background-color: #e2e2e2; height: 46px">
								&nbsp; <button type="button" class="btn btn-default" data-dismiss="modal" name="submit" style="height: 50px">보내기</button>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>

					</div>

				</div>
			</div>
</body>
</html>
