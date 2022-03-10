<%@page import="java.util.LinkedList"%>
<%@page import="Pack01.Person"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		int num = (int)request.getAttribute("num");
		out.println(num + "<br/>");
		
		String str = (String)request.getAttribute("str");
		out.println(str + "<br/>");
		
		
		int[] ar = (int [])request.getAttribute("ar");
		for(int v : ar){
			out.println(v + "<br/>");
		}
		
		Person p = (Person)request.getAttribute("person");
		out.println(p.getId());
		out.println(p.getPwd() + "<br>");
		
		
		// 5. Collection 전송
		@SuppressWarnings("unchecked") //오류 안보이게 하는 어노테이션
		LinkedList<Integer> list01 = 
				(LinkedList<Integer>)request.getAttribute("list01");
		out.println(list01.get(0));
		out.println(list01.get(1));
		out.println(list01.get(2)+ "<br>");
		
		
		// 6. Collection 전송(String)
		LinkedList<String> list02 = 
				(LinkedList<String>)request.getAttribute("list02");
		out.println(list02.get(0));
		out.println(list02.get(1));
		out.println(list02.get(2)+ "<br>");
		
		
		
		// 7. Collection 전송(Person)
		LinkedList<Person> list03 = 
				(LinkedList<Person>)request.getAttribute("list03");
		out.println(list03.get(0).getId());
		out.println(list03.get(0).getPwd());
		out.println(list03.get(1).getId());
		out.println(list03.get(1).getPwd());
		out.println(list03.get(2).getId());
		out.println(list03.get(2).getPwd()+ "<br>");
		
		
		
		
		
	%>
	
	<c:forEach var="value" items="${list04}" varStatus="status">
		<h3>${status.index} : ${value.getId()}</h3>
	</c:forEach>
	
	<c:forEach var="value" items="${ar}" varStatus="status">
		<h3>${status.index} : ${value}</h3>
	</c:forEach>
	
</body>
</html>