<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:template>
    <jsp:attribute name="title">
        Detalhes do produto <c:out value="${produto.produto}" />
    </jsp:attribute>
    <jsp:body>
    <c:set var="idproduto" value="${produto.idProduto}" scope="session" />
    <article>
        <fieldset>
            <legend>Dados produtos</legend>
            <ol>
                <li>
                    <label>Id:</label>
                    <c:out value="${produto.idProduto}" />
                </li>
                <li>
                    <label>Produto:</label>
                    <c:out value="${produto.produto}" />
                </li>
                <li>
                    <label>Código:</label>
                    <c:out value="${produto.codigo}" />
                </li>
                <li>
                    <label>Preço:</label>
                    <c:out value="${produto.preco}" />
                </li>
                <li>
                    <label>Estoque:</label>
                    <c:out value="${produto.estoque}" />
                </li>
                <li>
                    <label>Categoria:</label>
                    <c:out value="${produto.categoria.nome}" />
                </li>
            </ol>
        </fieldset>
    </article>
    <aside>
    <h3>Opções</h3>
    <p>
        Para mais ações clique em:
    </p>
    <ul>
        <li><a href="Produto?cmd=edit&id=${produto.idProduto}">Alterar</a></li>
        <li><a href="Produto?cmd=delete" onclick="return confirm('Tem certeza que gostaria de excluir esse produto?');">Excluir</a></li>
    </ul>
    </aside>
    </jsp:body>
</t:template>