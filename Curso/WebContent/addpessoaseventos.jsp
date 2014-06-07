<!DOCTYPE HTML>
<%@page import="org.hibernate.*"%>
<%@page import="org.hibernate.cfg.*"%>
<%@page import="br.com.treinaweb.parte1.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <LINK href="/Curso/css/estilo.css" type="text/css" rel="stylesheet">
    <title>Adicionando Pessoas a Eventos</title>
  </head>
  <body>
    <p>Adicionando Pessoas a Eventos</p>
    <%
		GerenciadorEventos gerenciadorEventos = new GerenciadorEventos();
    	gerenciadorEventos.adicionarPessoaEvento(1, 1);
    %>
  </body>
</html>