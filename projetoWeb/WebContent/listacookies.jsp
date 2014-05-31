<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cookies</title>
</head>
<body>
	<h2>Cookies da Página</h2>
	<%
		String tabela;
		tabela  = "<table>";
		tabela += "<tr><td>nome</td><td>valor</td></tr>";
		for(Cookie cookie : request.getCookies())
			tabela += "<tr><td>" + cookie.getName() + "</td><td>" + cookie.getValue() + "</td></tr>";
		tabela += "</table>";
		out.println(tabela);
	%>
</body>
</html>