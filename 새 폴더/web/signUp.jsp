<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>연락처 프로그램 메인</title>
	<!-- 디자인 시트 가져오기 -->
	<link type="text/css" rel="stylesheet" href="login.css"/>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
		    <!-- Tabs Titles -->
		    <h2 class="inactive underlineHover"><a href="login.jsp"> 로그인 </a></h2>
		    <h2 class="active"><a href="signUp.jsp"> 회원가입 </a></h2>
		
		    <!-- Login Form -->
		    <form action="LoginServlet" method="get">
		      <input type="text" id="memid" class="fadeIn second" maxlength="20" name="memid" placeholder="id" required="required">
		      <input type="text" id="pwd" class="fadeIn third" maxlength="20" name="pwd" placeholder="password" required="required">
		      <input type="text" id="memname" class="fadeIn third" maxlength="30" name="memname" placeholder="name" required="required">
		      <input type="text" id="memtel" class="fadeIn third" maxlength="20" name="memtel" placeholder="phone" required="required">
		      <input type="submit" class="fadeIn fourth" value="가입">
		    </form>
		</div>
	</div>
</body>
</html>