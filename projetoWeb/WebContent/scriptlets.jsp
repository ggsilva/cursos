<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Utilizando Scriptlets</title>
</head>
<body>
	<% 
		String curso = " Java Intermedi�rio ";
		curso = curso.toUpperCase().trim();
		out.println("Curso: " + curso);
	%>
</body>
</html>