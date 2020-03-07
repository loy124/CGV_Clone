<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String type = (String) request.getAttribute("type");
		Boolean isSuccess = (Boolean) request.getAttribute("isSuccess");
		if (isSuccess == null) {
			isSuccess = false;
		}
	%>
	

	<%
		if (type.equals("register")) {
			if (isSuccess) {
	%>
	<script>
		alert("회원가입이 정상적으로 완료되었습니다");
		location.href = "moveLogin.do"
	</script>
	<%
		} else {
	%>
	<script>
		alert("회원가입에 실패하였습니다");
		location.href = "moveRegister.do"
	</script>
	<%
		}
		}
	%>


	<%
		if (type.equals("login")) {

			if (isSuccess) {
				String name = (String) request.getAttribute("name");
	%>
	<script>
		alert("<%=name%>"+ "님 환영합니다");
		location.href = "moveMain.do"
	</script>
	<%
		} else {
	%>
	<script>
		alert("로그인에 실패하였습니다");
		location.href = "moveLogin.do"
	</script>
	<%
		}
		}
	%>
	

	<%
		if (type.equals("bbsWrite")) {
			if (isSuccess) {
	%>
	<script>
		alert("글 작성이 완료되었습니다");
		location.href = "bbsList.do"
	</script>
	<%
		} else {
	%>
	<script>
		alert("글 작성에 실패하였습니다");
		location.href = "bbsList.do"
	</script>
	<%
		}
		}
	%>
	
	<%
		if (type.equals("bbsUpdate")) {
			if (isSuccess) {
	%>
	<script>
		alert("글 수정이 완료되었습니다");
		location.href = "bbsList.do"
	</script>
	<%
		} else {
	%>
	<script>
		alert("글 수정에 실패하였습니다");
		location.href = "bbsList.do"
	</script>
	<%
		}
		}
	%>
	
	<%
		if (type.equals("bbsDelete")) {
			if (isSuccess) {
	%>
	<script>
		alert("글 삭제가 완료되었습니다");
		location.href = "bbsList.do"
	</script>
	<%
		} else {
	%>
	<script>
		alert("글 삭제에 실패하였습니다");
		location.href = "bbsList.do"
	</script>
	<%
		}
		}
	%>
	
	
	<%
		if (type.equals("answerWrite")) {
			if (isSuccess) {
	%>
	<script>
		alert("답글 작성이 완료되었습니다");
		location.href = "bbsList.do"
	</script>
	<%
		} else {
	%>
	<script>
		alert("답글 작성에 실패하였습니다");
		location.href = "bbsList.do"
	</script>
	<%
		}
		}
	%>
	
	
	<%
		if (type.equals("reserve")) {
			if (isSuccess) {
	%>
	<script>
		alert("결제및 예약이 완료되었습니다");
		location.href = "moveMain.do"
	</script>
	<%
		} else {
	%>
	<script>
		alert("결제및 예약에 실패하였습니다");
		location.href = "moveMain.do"
	</script>
	<%
		}
		}
	%>
</body>
</html>