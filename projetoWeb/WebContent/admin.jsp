<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Admin</title>
</head>
<body>
	<h1>Página Admin</h1>
	<%
		if(Integer.parseInt(session.getAttribute("idUsuario").toString()) > 0){
			out.println("Id Usuário: " + session.getAttribute("idUsuario") + "<br/>");
			out.println("Login     : " + session.getAttribute("login") + "<br/>");
		}else{
			response.sendRedirect("login.jsp");
		}
	%>
	<jsp:text>Texto</jsp:text>
</body>
</html>