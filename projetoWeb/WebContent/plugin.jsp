<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Action: plugin</title>
</head>
  <body>
    <jsp:plugin type="applet" code="MeuApplet.class" codebase="." height="100" width="100">
	    <jsp:params>
	        <jsp:param name="line" value="Olá Mundo!"/>
	    </jsp:params>
	    <jsp:fallback>Plugin não iniciado</jsp:fallback>
  	</jsp:plugin>
</body>
</html>