<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuário Salvo</title>
</head>
<body>
	<%
		String nome  = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://127.0.0.1/loja?user=root&password=javaweb";
			Connection con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String query = "INSERT INTO loja.usuarios (nome, login, senha) VALUES";
			query += "( '" + nome  + "'";
			query += ", '" + login + "'";
			query += ", '" + senha + "')";
			int rows = st.executeUpdate(query);
			if(rows > 0)
				out.println("Usuário '" + nome + "' cadastrado com sucesso!");
		}catch(Exception ex){
			out.println("Erro: " + ex.getMessage());
		}
	%>
</body>
</html>