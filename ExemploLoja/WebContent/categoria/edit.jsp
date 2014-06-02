<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template>
	<jsp:attribute name="title">Edição da Categoria</jsp:attribute>
	
	<jsp:body>
		<p class="validation-summary-errors">
			<c:out value="${msg}"></c:out>
		</p>
		<jsp:useBean id="categoria" class="br.com.treinaweb.entities.Categoria" scope="request"/>
		<jsp:setProperty name="categoria" property="*" />
		<form action="Categoria" method="POST">
			<input type="hidden" name="idCategoria" value="${categoria.idCategoria}"/>
			<fieldset>
				<legend>Formulário de Cadastro</legend>
				<ol>
					<li>
						<label>Nome</label>
						<input type="text" name="nome" value="${categoria.nome}"/>
					</li>
				</ol>
				<input type="submit" value="Salvar">
			</fieldset>
		</form>
	</jsp:body>	
</t:template>