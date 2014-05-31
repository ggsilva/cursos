<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo Utilizando Declarações</title>
</head>
<body>
	<%! String site = "www.treinaweb.com.br"; %>
	<%! public String getSite(){
			return site;
		}%>
	<% out.write("Curso de JavaEE disponível em: " + getSite());%>
</body>
</html>