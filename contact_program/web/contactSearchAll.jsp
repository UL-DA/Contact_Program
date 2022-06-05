<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>전체 연락처 목록</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
	  <h2 align="center">연락처 목록</h2>
	  <table class="table">
	    <tr>
	      <th>식별번호</th>
	      <th>이름</th>
	      <th>전화번호</th>
	      <th>주소</th>
	      <th>구분</th>
	      <th>수정</th>
	      <th>삭제</th>
	    </tr>
	    <c:forEach items="${contacts }" var="contact">   
		    <tr>
		      <td>${contact.contactno }</td>
		      <td>${contact.contactnm }</td>
		      <td>${contact.contactnum }</td>
		      <td>${contact.contactaddr }</td>
		      <td>${contact.categorynm }</td>
		      <td>
		      <form action="ContactUpdateServlet" method="get">
		      	<input type="text" name="contactno" value="${contact.contactno }" size="3">
		      	<input type="submit" value="수정">
		      </form>
		      </td>
		      <td>
		      <form action="ContactDeleteServlet" method="get">
		      	<input type="text" name="contactno" value="${contact.contactno }" size="3">
		      	<input type="submit" value="삭제">
		      </form>
		      </td>
		    </tr>
	   </c:forEach>
	  </table>
	</div>
</body>
</html>