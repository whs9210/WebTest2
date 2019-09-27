<%@page import="bean.UserDAO"%>
<%@page import="bean.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"></script>
<style type="text/css">
#d1 {
	padding-top: 200px;
}
</style>
</head>
<body bgcolor="#6ADEDA">
<% 
String id= (String)session.getAttribute("id"); //세션 id값을 변수 id에 저장
String pw=request.getParameter("pw");   //변경할 pw를 가져오고 변수 pw에 저장
String phone=request.getParameter("phone"); //변경할 phone를 가져오고 변수 phone에 저장
String email=request.getParameter("email"); //변경할 email을 가져오고 변수 email에 저장
UserDTO dto=new UserDTO();
UserDAO dao=new UserDAO();
dao.UpdateAll(pw, phone, email, id); //update문에 pw,phone,email,id를 대입
dto=dao.getUserInfo(id); //dto에 update하고 나서 다시 새로운 정보를 불러옴
session.setAttribute("pw", dto.getPw()); //새로 입력된 pw를 세션설정
session.setAttribute("phone", dto.getPhone()); //새로 입력된 phone을 세션설정
session.setAttribute("email", dto.getEmail()); //새로 입력된 email을 세션설정
%>
<h1 align="center">회원 정보가 수정되었습니다.</h1>
<div id="d1">
		<h3 align="center"><a href="index.jsp">메인 화면으로 돌아가기</a></h3>
	</div>
</body>
</html>