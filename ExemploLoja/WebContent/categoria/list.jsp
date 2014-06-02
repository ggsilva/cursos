<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template>
	<jsp:attribute name="title">Edição da Categoria</jsp:attribute>
	
	<jsp:body>
		<table>
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categorias}" var="categoria">
					<tr>
						<td><c:out value="${categoria.idCategoria}"></c:out></td>
						<td><c:out value="${categoria.nome}"></c:out></td>
						<td><a href="Categoria?cmd=details&id=${categoria.idCategoria}">detalhes</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<aside>
			<h3>Nova Categoria</h3>
			<p>Para adicionar uma nova categoria clique em:</p>
			<ul>
				<li><a href="Categoria?cmd=edit">Cadastrar</a></li>
			</ul>
		</aside>
	</jsp:body>
</t:template>