<%@page import="bit.com.a.model.CGVReserveDto"%>
<%@page import="java.util.List"%>
<%@page import="bit.com.a.model.CGVMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	CGVMemberDto login = (CGVMemberDto) session.getAttribute("login");
	if (login != null)
		System.out.println(login.toString());

	List<CGVReserveDto> list = (List<CGVReserveDto>) request.getAttribute("reserveList");
%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/myPage.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel='stylesheet'
	href='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css' />
<script
	src='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js'></script>
<link rel="stylesheet"
	href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
<!-- MATERIAL DESIGN ICONIC FONT -->

</head>

<body>
	<%
		if (login == null) {
	%>
	<script>
		alert("로그인이 필요한 작업입니다 로그인을 진행해 주세요!")
		location.href = "moveMain.do"
	</script>
	<%
		}
	%>
	<div class="header-nav-wrapper">
		<header class="header">
			<div class="header-inner">
				<div>
					<button>
						<i class="zmdi zmdi-apps"></i><span>&nbsp;CGV APP</span>
					</button>
				</div>
				<div>
					<button>
						<i class="zmdi zmdi-facebook-box"></i><span>&nbsp;Like</span>
					</button>
				</div>
				<div>
					<button>
						<i class="zmdi zmdi-instagram"></i><span>&nbsp;follow</span>
					</button>
				</div>
				<div>
					<button>알뜰한 영화 관람법</button>
				</div>
			</div>
			<div class="header-inner">

				<%
					if (login != null) {
				%>
				<div>
					<button><%=login.getName()%>님 환영합니다
					</button>
				</div>
				<div>
					<a href="moveMypage.do"><button>마이페이지</button></a>
				</div>
				<div>
					<a href="logout.do"><button>로그아웃</button></a>
				</div>
				<%
					} else {
				%>
				<div>
					<a href="moveLogin.do"><button>로그인</button></a>
				</div>
				<div>
					<a href="moveRegister.do"><button>회원가입</button></a>
				</div>
				<%
					}
				%>
			</div>
		</header>
		<nav class="nav-wrapper">
			<div class="logo-wrapper">
				<a href="moveMain.do"><img class="cgvLogo"
					src="./images/cgv.png"></a>
			</div>
			<div class="nav-content">
				<div class="movieLogo-wrapper">
					<img class="cgvMovie" src="./images/h2_movie.png">
				</div>
				<div class="nav-inner">
					<div>
						<button>영화</button>
					</div>
					<div>
						<button>예매</button>
					</div>
					<div>
						<button>극장</button>
					</div>
					<div>
						<button>이벤트&컬쳐</button>
					</div>
					<div class="search-wrapper">
						<input>
						<button class="searchButton">검색</button>
					</div>
				</div>
			</div>
			<div></div>
			<div></div>
		</nav>
	</div>
	<div>
		<div class="my-page-container">
			<div class="my-page-wrapper">
				<div class="my-page-header">예약한 영화 목록</div>
				<div class="movie-reserve-list">
					<%
						if (list == null) {
					%>
					<div>예약한 영화가 없습니다</div>
					<%
						} else {
							for (int i = 0; i < list.size(); i++) {
								CGVReserveDto reserveDto = list.get(i);
					%>
					<div class="movie-reserve">
						<div class="movie-reserve-age"><%=reserveDto.getMovieAge() %></div>
						<div class="movie-reserve-title"><%=reserveDto.getTitle() %></div>
						<div class="movie-reserve-theater-wrapper">
							<div><%=reserveDto.getSelectedTheater() %></div>
							&nbsp;/&nbsp;
							<div class="ticket-numeber"><%=reserveDto.getTicketNumber() %>장</div>
						</div>
						<div class="movie-reserve-seats"><%=reserveDto.getSelectedSeat() %></div>
						<div class="movie-reserve-date-wrapper">
							<div class="movie-reserve-date"><%=reserveDto.getMovieDate() %></div>
							<div class="movie-reserve-runningTime"><%=reserveDto.getRunningTime() %></div>
						</div>
						<div class="movie"></div>

						<div class="pay-information-wrapper">
							<div class="pay-information-date-wrapper">
								<div class="pay-information-date-title">결제한 날</div>
								<div class="pay-information-date"><%=reserveDto.getCgvPayDto().getPayDate() %></div>
							</div>

							<div class="pay-information-money-wrapper">
								<div class="pay-information-money-title">결제한 비용</div>
								<div class="pay-information-money"><%=reserveDto.getCgvPayDto().getPayMoney() %>원</div>
							</div>

							<div class="barcode-wrapper">
								<div>CGV</div>
								<img src="images/barcode.png">
							</div>

						</div>
					</div>
					<%
						}
					%>
					<!-- <div class="movie-reserve">
						<div class="movie-reserve-age">15세이상 관람가</div>
						<div class="movie-reserve-title">겨울왕국2</div>
						<div class="movie-reserve-theater-wrapper">
							<div>CGV 강남 1관 3층</div>
							&nbsp;/&nbsp;
							<div class="ticket-numeber">1명</div>
						</div>
						<div class="movie-reserve-seats">A01, A02</div>
						<div class="movie-reserve-date-wrapper">
							<div class="movie-reserve-date">2019.11.22 (금)</div>
							<div class="movie-reserve-runningTime">24:10 ~ 26:03</div>
						</div>
						<div class="movie"></div>

						<div class="pay-information-wrapper">
							<div class="pay-information-date-wrapper">
								<div class="pay-information-date-title">결제한 날</div>
								<div class="pay-information-date">2020-03-07-00시</div>
							</div>

							<div class="pay-information-money-wrapper">
								<div class="pay-information-money-title">결제한 비용</div>
								<div class="pay-information-money">60000원</div>
							</div>

							<div class="barcode-wrapper">
								<div>CGV</div>
								<img src="images/barcode.png">
							</div>

						</div>
					</div> -->
					<%
						}
					%>

	


				</div>

			</div>
		</div>
	</div>

</body>

</html>