<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:template>
    <jsp:attribute name="title">
        Edição de Produto
    </jsp:attribute>
    <jsp:body>
       <p class="validation-summary-errors">
           <c:out value="${msg}" />
      </p>
        <jsp:useBean id="produto" class="br.com.treinaweb.entities.Produto" scope="request" />
    <jsp:setProperty name="produto" property="*" />
    <form action="Produto" method="POST">
      <input type="hidden" name="idProduto" value="${produto.idProduto }" />
      <fieldset>
        <legend>Formulário de cadastro</legend>
        <ol>
          <li>
            <label>Produto:</label>
            <input type="text" name="produto" value="${produto.produto }" />
          </li>
                  <li>
                      <label>Código:</label>
                      <input type="text" name="codigo" value="${produto.codigo }" />
                  </li>
                  <li>
                      <label>Preço:</label>
                      <input type="text" name="preco" value="${produto.preco }" />
                  </li>
                  <li>
                      <label>Estoque:</label>
                      <input type="text" name="estoque" value="${produto.estoque }" />
                  </li>
                  <li>
                      <label>Categoria:</label>
                      <select name="idcategoria">
                      	<c:forEach items="${categorias}" var="categoria">
                        	<c:if test="${produto.categoria.idCategoria == categoria.idCategoria }">
                        		<option value="${categoria.idCategoria}" selected="selected">
                        			<c:out value="${categoria.nome}" />
                        		</option>
                        	</c:if>
                        	<c:if test="${produto.categoria.idCategoria != categoria.idCategoria }">
			            		<option value="${categoria.idCategoria}">
			            			<c:out value="${categoria.nome}" />
			            		</option>
			            	</c:if>
                      	</c:forEach>
                      </select>
                  </li>
        </ol>
        <input type="submit" value="Salvar">
      </fieldset>
    </form>
    </jsp:body>
</t:template>