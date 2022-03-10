<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>여기는 호랑이</h2>
	
	<!-- t6 -->
	<!-- getAttri대신 사용 -->
	<h3>${name} ${age}</h3>
	<!-- <h3>${age}</h3> -->
	
	
	<!-- t7 -->
	<!-- 모델로 할 때는 getParameter안된다. getAttribute사용-->
	<%-- <%
		//String nn = (String)request.getParameter("name");
		String nn = (String)request.getAttribute("name");
		String aa = (String)request.getAttribute("age");
	%>
	<%=nn %>
	<%=aa %> --%>
	<!-- 이렇게 받는 방법도 있다.-->
	
	
	
</body>
</html>