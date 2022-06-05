<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>연락처 추가</title>
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
		<!-- 연락처 추가 Form -->
	    <form action="ContactAddServlet" method="post">
	      	연락처 이름<input type="text" maxlength="20" name="contactnm" placeholder="name" required="required"><br/>
	      	전화번호<input type="text" maxlength="13" name="contactnum" placeholder="phone" required="required"><br/>
	      	연락처 주소<input type="text" maxlength="50" name="contactaddr" placeholder="address" required="required"><br/>
	      	구분<input type="text" maxlength="2" size="32" name="categoryno" placeholder="1(가족),2(친구),3(회사),4(기타)_숫자입력" required="required"><br/>
	      	<input type="submit" value="등록" onclick="alert('등록이 완료되었습니다.');">
	    </form>
	</div>
	<!-- footer (앱 출처) -->
	<div id="footer">
		copyright@PARK_DAUL
	</div>
</body>
</html>