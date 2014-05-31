<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo da tag remove - JSTL</title>
</head>
<body>
        <c:import url="barra.jsp" />
        <br /><br />
  <c:out value="Variável é criada" /><br />
  <c:set var="mensagem" value="Olá mundo" />
  <c:out value="${mensagem}" /><br />
  <c:out value="Variável é removida" /><br />
  <c:remove var="mensagem" />
  <c:out value="${mensagem}" /><br />
  <c:catch var="erro">
    <%
      out.println(5/0);
    %>
  </c:catch>
  <c:out value="${erro}" /><br />
    
  <c:catch var="erro">
    <c:set var="mesAtual" value="10" />
  </c:catch>
  <c:if test="${erro != null }">
    <c:out value="Ocorreu o erro: ${erro}" />
  </c:if>
  <c:choose>
    <c:when test="${mesAtual == 1}">
      <c:out value="Estamos em Janeiro" />
    </c:when>
    <c:when test="${mesAtual == 2}">
      <c:out value="Estamos em Feveiro" />
    </c:when>
    <c:when test="${mesAtual == 3}">
      <c:out value="Estamos em Março" />
    </c:when>
    <c:when test="${mesAtual == 4}">
      <c:out value="Estamos em Abril" />
    </c:when>
    <c:when test="${mesAtual == 5}">
      <c:out value="Estamos em Maio" />
    </c:when>
    <c:when test="${mesAtual == 6}">
      <c:out value="Estamos em Junho" />
    </c:when>
    <c:when test="${mesAtual == 7}">
      <c:out value="Estamos em Julho" />
    </c:when>
    <c:when test="${mesAtual == 8}">
      <c:out value="Estamos em Agosto" />
    </c:when>
    <c:when test="${mesAtual == 9}">
      <c:out value="Estamos em Setembro" />
    </c:when>
    <c:when test="${mesAtual == 10}">
      <c:out value="Estamos em Outubro" />
    </c:when>
    <c:when test="${mesAtual == 11}">
      <c:out value="Estamos em Novembro" />
    </c:when>
    <c:when test="${mesAtual == 12}">
      <c:out value="Estamos em Dezembro" />
    </c:when>
    <c:otherwise>
      <c:out value="Mês desconhecido" />
    </c:otherwise>
  </c:choose>

	<h2>Lista de cursos</h2>
	<c:set var="cursos" value="Java SE, Java EE, Java ME, EJB" scope="page" />
	<c:forEach var="curso" items="${cursos}">
		<c:out value="${curso}" /><br />
	</c:forEach>
	<hr>
	<c:forEach var="i" begin="1" end="5">
		<c:out value="${i}" /><br />
	</c:forEach>
	
  <h2>Salvar Usuário</h2>
    <c:url value="/salvarusuario.jsp" var="url">
        <c:param name="nome" value="José Silva" />
        <c:param name="login" value="jose.silva@treinaweb.com.br" />
        <c:param name="senha" value="1234" />
    </c:url>
    <a href="${url}">Incluir</a>
    <hr>
    Valor da url:<c:out value="${url}" />
        <br /><br />
        <!-- 
  <c:redirect url="/cadastroaluno.jsp" />
	 -->
</body>
</html>