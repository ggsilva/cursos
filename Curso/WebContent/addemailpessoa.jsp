<!DOCTYPE HTML>
<%@page import="org.hibernate.*"%>
<%@page import="org.hibernate.cfg.*"%>
<%@page import="br.com.treinaweb.parte1.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <LINK href="/Curso/css/estilo.css" type="text/css" rel="stylesheet">
    <title>Adicionando Emails a Pessoas</title>
  </head>
  <body>
    <p>Adicionando Emails a Pessoas</p>
    <%
		GerenciadorEventos gerenciadorEventos = new GerenciadorEventos();
    	gerenciadorEventos.adicionarEmailPessoa(1, "guilherme.silva@mecaso.com.br");
    %>
  </body>
</html>