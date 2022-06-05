<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>연락처 프로그램 메인화면</title>
	<!-- 디자인 시트 가져오기 -->
	<link type="text/css" rel="stylesheet" href="main.css"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
		<div class="w3-container">
		  <h2>회원 목록</h2>
		  <table class="w3-table w3-centered">
		    <tr>
		      <th>아이디</th>
		      <th>비밀번호</th>
		      <th>이름</th>
		      <th>연락처</th>
		      <th>가입일</th>
		    </tr>
		    <c:forEach items="${memberList }" var="member">   
			    <tr>
			      <td>${member.memid }</td>
			      <td>${member.pwd}</td>
			      <td>${member.memname}</td>
			      <td>${member.memtel }</td>
			      <td>${member.regdate }</td>
			    </tr>
		   </c:forEach>
		  </table>
		</div>
	</div>
	<!-- footer (앱 출처) -->
	<div id="footer">
		copyright@PARK_DAUL
	</div>
</body>
</html>