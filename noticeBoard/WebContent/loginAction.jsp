<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.ssafy.noticeboard.user.dao.UserDaoImpl" %>
    <%@ page import = "java.io.PrintWriter" %>
    <% request.setCharacterEncoding("UTF-8");%>
    
    <jsp:useBean id="user" class="com.ssafy.noticeboard.user.dto.Users" scope="page"/>
    <jsp:setProperty name="user" property="user_id"/>
    <jsp:setProperty name="user" property="user_pw"/>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>로그인 페이지</title>
</head>
<body>
	<%
		UserDaoImpl userDAO = UserDaoImpl.getInstance();
		int res = userDAO.login(user.getUser_id(), user.getUser_pw());
		
		if(res == 1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		}
		else if(res == 0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else if(res == -1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else if(res == -2){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
	%>
</body>
</html>