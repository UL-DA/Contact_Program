<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 수정</title>
	<!-- 디자인 시트 가져오기 -->
	<link type="text/css" rel="stylesheet" href="main.css"/>
</head>
<body>
	<!-- 메인 화면 제목 -->
	<h1 id="login"><a href="MainServlet">연락처 프로그램</a></h1>
	<!-- header (상단 로그인 안내) -->
	<div id="header">
		<h2>안녕하세요. ${memid }회원님 :)</h2>
	</div>
	<!-- nav (왼쪽 영역) -->
	<div id="nav">
		<div id="menu">
			<div><a href="ContactAddServlet">1. 연락처 추가 </a></div>
			<div><a href="ContactSearchAllServlet">2. 연락처 조회 </a></div>
			<div><a href="MemberUpdateServlet">3. 회원 정보 수정 </a></div>
			<div><a href="LoginServlet">4. 로그아웃 </a></div>
			<div>-ContactApp-</div>
		</div>
	</div>
	<!-- section (기능 화면) -->
	<div id="section">
		<form action="MemberUpdateServlet" method="post">
			회원아이디 <input type="text" name="memid" readonly="readonly" value="${memberDto.memid }"><br>
			회원비밀번호 <input type="password" name="pwd" required="required"><br>
			회원이름 <input type="text" name="memname" value="${memberDto.memname }"><br>
			회원연락처 <input type="text" name="memtel" value="${memberDto.memtel }"><br>
			<input type="submit" value="수정" onclick="alert('수정이 완료되었습니다.');">
		</form>
	</div>
	<!-- footer (앱 출처) -->
	<div id="footer">
		copyright@PARK_DAUL
	</div>
</body>
</html>