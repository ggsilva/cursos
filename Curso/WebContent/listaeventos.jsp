<!DOCTYPE HTML>
<%@page contentType="text/html" %>
<%@page pageEncoding="ISO-8859-1" %>
<%@page import="org.hibernate.*" %>
<%@page import="org.hibernate.cfg.*" %>
<%@page import="java.util.*"%>
<%@page import="br.com.treinaweb.parte1.*"%>
<html>
    <head>
        <title>Listando Eventos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <LINK HREF="/Curso/css/estilo.css" TYPE="text/css" REL="stylesheet">
    </head>
    <body>
  <h3></h3>
  <%
    GerenciadorEventos ge= new GerenciadorEventos();
    List lista = ge.listarEventos();
    String tabela = "";
    tabela += "<table align='center' border='1'>";
    tabela += "<tr><td><b>id</b></td><td><b>Evento</b></td><td><b>Data</b></td></tr>";
    for(int i = 0;i<lista.size();i++){
      Eventos c = (Eventos)lista.get(i);
      int idEvento = c.getIdevento();
      String evento = c.getEvento();
      String data = c.getData();
      tabela += "<tr><td>" + idEvento + "</td>";
      tabela += "<td>" + evento + "</td>";
      tabela += "<td>" + data + "</td></tr>";
    }
    tabela += "</table>";
    out.println(tabela);
  %>
    </body>
</html>