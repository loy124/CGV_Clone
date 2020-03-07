<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>RegistrationForm_v1 by Colorlib</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- MATERIAL DESIGN ICONIC FONT -->
<link rel="stylesheet"
	href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

<!-- STYLE CSS -->
<link rel="stylesheet" href="css/style.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel='stylesheet'
	href='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css' />
<script
	src='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js'></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js"
	type="text/javascript"></script>
</head>

<body>

	<div class="wrapper" style="">

		<div class="inner">
			<div class="image-holder">
				<img id="poster"
					src="https://upload.wikimedia.org/wikipedia/ko/f/f2/%EC%96%B4%EB%B2%A4%EC%A0%B8%EC%8A%A4-_%EC%97%94%EB%93%9C%EA%B2%8C%EC%9E%84_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg"
					alt="">
			</div>
			<form action="login.do" id="loginForm" method="post">
				<p class="register-title">
					<img src="http://img.cgv.co.kr/R2014/images/title/h1_cgv.png">
					<span>로그인</span>
				</p>
				<div class="form-wrapper form-wrapper-id">
					<div class="id-wrapper">
						<input id="id" name="id" type="text" placeholder="아이디"
							class="form-control"> <i class="zmdi zmdi-accounts"></i>
					</div>
				</div>

				<div class="form-wrapper">
					<input type="password" name="password" placeholder="비밀번호"
						id="password" class="form-control"> <i
						class="zmdi zmdi-lock"></i>
				</div>

				<div class="sort1">
					<input type="checkbox" id="checkSaveId"> <span>아이디
						저장</span>
				</div>


				<button type="button" class="loginButton">
					<span>로그인 하기</span> <i class="zmdi zmdi-arrow-right"></i>
				</button>
				<button type="button" class="moveRegister" style="margin-top: 10px;">
					<span>회원가입 하기</span> <i class="zmdi zmdi-arrow-right"></i>
				</button>
				
				<button type="button" class="moveMain" style="margin-top: 10px;">
					<span>메인 홈페이지</span> <i class="zmdi zmdi-arrow-right"></i>
				</button>
			</form>

		</div>
	</div>
	<script src="./js/login.js"></script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>















