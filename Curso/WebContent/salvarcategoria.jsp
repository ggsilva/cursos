<!DOCTYPE HTML>
<%@page import="org.hibernate.*"%>
<%@page import="org.hibernate.cfg.*"%>
<%@page import="br.com.treinaweb.parte1.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <LINK href="/Curso/css/estilo.css" type="text/css" rel="stylesheet">
    <title>Primeiro exemplo do curso de J2EE</title>
  </head>
  <body>
    <h2>Primeiro exemplo do curso de Hibernate</h2>
    <%
       int idcategoria = 0;
       String categoria = "";
       if ((request.getParameter("idcategoria") != null) && (request.getParameter("categoria") != null)){
         try{
           idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
           categoria = request.getParameter("categoria");
           SessionFactory sf;
           sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
           Session s = sf.openSession();//Abre sessão
           Transaction tx = s.beginTransaction();//Cria transação
           Categoria c = new Categoria();
           c.setIdcategoria(idcategoria);
           c.setNome(categoria);
           s.save(c);
           tx.commit();
           s.close();
           out.println("Gravou");
         }catch (Exception x){
           out.println(x.getMessage());
         }
       }else{
         out.println("Não gravou");
       }
    %>
  </body>
</html>