<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>����� ȣ����</h2>
	
	<!-- t6 -->
	<!-- getAttri��� ��� -->
	<h3>${name} ${age}</h3>
	<!-- <h3>${age}</h3> -->
	
	
	<!-- t7 -->
	<!-- �𵨷� �� ���� getParameter�ȵȴ�. getAttribute���-->
	<%-- <%
		//String nn = (String)request.getParameter("name");
		String nn = (String)request.getAttribute("name");
		String aa = (String)request.getAttribute("age");
	%>
	<%=nn %>
	<%=aa %> --%>
	<!-- �̷��� �޴� ����� �ִ�.-->
	
	
	
</body>
</html>