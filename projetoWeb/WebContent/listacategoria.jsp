<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.persistence.EntityManager,
                 javax.persistence.EntityManagerFactory,
                 javax.persistence.Persistence,
                 javax.persistence.Query,
                 java.util.List,
                 br.com.treinaweb.entities.Categoria" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categorias</title>
</head>
<body>
<div>
  <p><a>Adicione uma nova Categoria</a></p>
</div>
<div>
  <h3>Categorias</h3>
<%
  EntityManagerFactory factory;
  factory = Persistence.createEntityManagerFactory("entidades");
  EntityManager em = factory.createEntityManager();
  Query q = em.createQuery("select c from Categoria c");
  List<Categoria> categoriaList = q.getResultList();
  out.println("<table><tr><td>Id</td><td>Nome</td><td>Edição</td></tr>");
  for (Categoria categoria : categoriaList) {
    out.println("<tr>");
      out.println("<td>" + categoria.getIdCategoria() + "</td>");
      out.println("<td>" + categoria.getCategoria() + "</td>");
      out.println("<td><a href='editarcategoria.jsp?id=" + categoria.getIdCategoria() + "'>editar</a></td>");
      out.println("</tr>");
  }
  out.println("</table>");
%>
</div>
</body>
</html>