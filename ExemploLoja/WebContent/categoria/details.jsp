<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template>
	<jsp:attribute name="title">Detalhes de  <c:out value="${categoria.nome}"/> </jsp:attribute>
	<jsp:body>
		<article>
			<fieldset>
				<legend>Dados Categoria</legend>
				<ol>
					<li>
						<label>Id:</label>
						<c:out value="${categoria.idCategoria}"/>
					</li>
					<li>
						<label>Nome:</label>
						<c:out value="${categoria.nome}"/>
					</li>
				</ol>				
			</fieldset>
		</article>
		<aside>
			<h3>Opções</h3>
			<p>Para mais ações clique em: </p>
			<ul>
				<li><a href="Categoria?cmd=edit?id=${categoria.idCategoria}">Alterar</a></li>
			</ul>
		</aside>
	</jsp:body>
</t:template>