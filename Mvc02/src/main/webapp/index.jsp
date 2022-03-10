<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<head>
<title>메인 페이지</title>
</head>


<body>
	<%=new Date()%> <!-- 웹페이지 새로고침 됐는지 확인하기 위해 -->
	<h2>Hello World</h2>
	<a href="t1">링크1</a><br>
	<a href="t2">링크2</a><br> 
	
	<!-- 클라이언트에서 컨트롤러로 데이터 전송 -->
	<a href="t3?name=apple">링크3</a><br>  <!-- ? = 데이터전송 -->
	<a href="t4?name=apple&age=30">링크4</a><br>  <!-- & = 연결고리로 여러개의 데이터 전송 -->
	<a href="t5?name=apple&age=30">링크5</a><br> 
	
	<a href="t6">링크6</a><br>
	
	 <!-- client -> controller -> view -->
	<a href="t7?name=apple&age=30">링크7</a><br>	
	
	<a href="t8">링크8</a><br>
	<a href="t9">링크9</a><br>
	
	
	<form method="post" action="t10">
		<!-- name은 input의 속성 -->
		<input type="text" name="id" value="낙타" /><br>
		<input type="number" name="pwd" value=500 /><br>
		<input type="submit" value="전송" /><br>
		<!-- 객체로 받음 -->
	</form>
	
	<a href="t11">링크11</a><br>
	
	<br/>
</body>