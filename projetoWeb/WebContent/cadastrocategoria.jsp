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
<title>Cadastro Categoria</title>
</head>
<body>
  <fieldset>
    <legend>Cadastro Categoria</legend>
      <form method="post">
          <table border="0">
              <tr><td>Categoria:</td><td><input type="text" name="txtcategoria"></td></tr>
              <tr><td colspan="2"><input type="submit" name="cmdincluir" value="Incluir"></td></tr>
          </table>
      </form>
  </fieldset>
  <%
         if(request.getParameter("cmdincluir") != null){
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("entidades");
        EntityManager em = factory.createEntityManager();

        String nome = request.getParameter("txtcategoria");
        Categoria categoria = new Categoria();
        categoria.setCategoria(nome);

        em.getTransaction().begin();
        em.persist(categoria);
          em.getTransaction().commit();
          em.close();

          response.sendRedirect("listacategoria.jsp");
         }
    %>
</body>
</html>