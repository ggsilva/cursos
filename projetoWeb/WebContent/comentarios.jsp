<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comentários na Página JSP</title>
</head>
<body>
	<h1>Lista de Produtos</h1>
	<!-- Esta página gera uma lista simples de produtos. -->
	<%
		out.println("<ol>");
		//Lista simples de produtos
		for(int i=1; i<=10; i++){
			out.println("		<li><p>P" + i + "</p></li>");
			/*
				out.println("P2" + i + "<br/>");
			*/
		}
		out.println("	</ol>");
	%>
</body>
</html>