<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Diretiva Include</title>
</head>
<body>
	<%@include file="barra.jsp" %>
	<hr>
	<%
		String mensagem = "";
		mensagem = "<h3>Uso da diretiva include </h3>";
		out.println(mensagem);
	%>
</body>
</html>