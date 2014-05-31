<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Utilizando JSTL - forEach com JavaBeans</title>
</head>
<body>
    <h2>Lista de cursos</h2>
    <jsp:useBean id="curso" class="br.com.treinaweb.javaee.Cursos" />
    <c:set var="cursos" value="${curso.listaCursos}" scope="session" />
    <c:forEach var="nome" items="${cursos}">
        <c:out value="${nome} <br />" escapeXml="false" />
    </c:forEach>
    
        <h2>Lista de cursos 2</h2>
        <c:set var="cursos" value="Java SE, Java EE, Java ME, EJB" scope="page" />
        <c:forTokens var="curso" delims="," items="${cursos}">
            <c:out value="${curso}" /><br />
        </c:forTokens>
</body>
</html>