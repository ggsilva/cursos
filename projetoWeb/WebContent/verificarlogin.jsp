<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.treinaweb.javaee.Usuario, br.com.treinaweb.javaee.UsuarioDAO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Verificar Usuário</title>
</head>
<body>
	<%
		Usuario usuario = new Usuario();
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		
		UsuarioDAO dao = new UsuarioDAO();
		usuario = dao.verificar(usuario);
		//if(usuario.getIdUsuarios() > 0){
			out.println("Login/Cookies correto para o usuário com o idUsuario: " + usuario.getIdUsuarios());
			Cookie cookie = new Cookie("login", usuario.getLogin());
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
			//Gravando na Sessão
			session.setAttribute("idUsuario", Integer.toString(usuario.getIdUsuarios()));
			session.setAttribute("login", usuario.getLogin());
			//Redireciona para a página administrativa
			response.sendRedirect("admin.jsp");
		//}else{
		//	out.println("Login Incorreto");
		//}
	%>
</body>
</html>