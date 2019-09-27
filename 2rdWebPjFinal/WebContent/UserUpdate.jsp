<%@page import="bean.UserDAO"%>
<%@page import="bean.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/UserMember.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
$(function() {
	$("#delete").click(function() {
		/* id의 세션값을  불러와 변수 id에 저장 */
		var id="<%=session.getAttribute("id")%>"  
		location.href="UserDelete.jsp?id="+id;  //탈퇴버튼을 누르면 UserDelete로 이동하면서 id값을 가져감
	});//delete
});//function
</script>
</head>
<body>
<%
String id= (String)session.getAttribute("id"); //세션 id값을 불러옴
UserDAO dao=new UserDAO();
UserDTO dto=dao.getUserInfo(id);  //저장된 id값의 다른 정보들을 dto에 넣어줌
%>
<div class="container">
			<h1>정보 수정 및 탈퇴</h1>
			<hr>
			<!-- 입력된 값들을 UUp.jsp로 보내줌 -->
			<form action="UUp.jsp">
			<div class="form-group">
				<label for="id"><b id="id">아이디 : <%=dto.getId()%></b></label> 
			</div>
			<div>
				<br>
			</div>
			<div>
				<label for="psw"><b>변경할 비밀번호</b></label> <input type="password"
					name="pw" id="pw" value="<%=dto.getPw()%>"required>
			</div>
			<div>
				<label for="email"><b id="name">이름 :<%=dto.getName()%></b></label> 
			</div>
			<div><br></div>
			<div>
				<label for="email"><b>변경할 전화번호</b></label> <input type="text" id="phone"
					 name="phone" value="<%=dto.getPhone()%>" required>
			</div>
			<div>
				<label for="email"><b>변경할 이메일</b></label> <input type="text" id="email"
					 name="email" value="<%=dto.getEmail()%>"required>
			</div>
			<hr>
			<div id="btn">
			<div id="up"><button type="sumbit" class="registerbtn1" id="update">수정</button></div>
			</form>
			<div id="bye"><button type="button" class="registerbtn1" id="delete">회원탈퇴</button></div>
			</div>
			</div>
	
</html>