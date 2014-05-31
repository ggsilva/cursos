<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo da tag out - JSTL</title>
</head>
<body>
	<h2>Propriedades do Java Beans</h2>
	
	<form method="post">
		<table border="0">
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="txtNome"></td>
			</tr>
			<tr>
				<td>Endereco:</td>
				<td><input type="text" name="txtEndereco"></td>
			</tr>
			<tr>
				<td>CEP:</td>
				<td><input type="text" name="txtCEP"></td>
			</tr>
			<tr>
				<td>Cidade:</td>
				<td><input type="text" name="txtCidade"></td>
			</tr>
			<tr>
				<td>Estado:</td>
				<td><input type="text" name="txtEstado"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="cmdIncluir" value="Incluir">
				</td>
			</tr>
		</table>
	</form>
	
    <c:if test="${param.cmdIncluir == 'Incluir'}" >	
	<c:set var="nome"     value="${param.txtNome}" />
	<c:set var="endereco" value="${param.txtEndereco}" />
	<c:set var="cep" 	  value="${param.txtCEP}" />
	<c:set var="cidade"   value="${param.txtCidade}" />
	<c:set var="estado"   value="${param.txtEstado}" />
	
	<table border="1">
		<tr>
			<td>Nome:</td>
			<td><c:out value="${nome}" /></td>
		</tr>
		<tr>
			<td>Endereco:</td>
			<td><c:out value="${endereco}" /></td>
		</tr>
		<tr>
			<td>CEP:</td>
			<td><c:out value="${cep}" /></td>
		</tr>
		<tr>
			<td>Cidade:</td>
			<td><c:out value="${cidade}" /></td>
		</tr>
		<tr>
			<td>Estado:</td>
			<td><c:out value="${estado}" /></td>
		</tr>
	</table>
    </c:if>
</body>
</html>