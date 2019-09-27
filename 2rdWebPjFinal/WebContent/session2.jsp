<%@page import="javax.websocket.Session"%>
<%@page import="bean.*"%>
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
session.invalidate(); //세션종료
//현재페이지 주소 읽어서 변수에 담아서, 뒷변수빼고 리디랙션으로 변수넣기.
 //자바코드: 다음페이지 설정

/* String foo = request.getRequestURL().toString(); */
response.sendRedirect("index.jsp");

%>
</body>
</html>