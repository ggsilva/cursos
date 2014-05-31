<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<c:if test="${idioma == null }">
		<fmt:setBundle basename="br.com.treinaweb.javaee.Recurso" var="idioma" scope="page" />
	</c:if>
	<form>
		<table border="0" align="center">
			<tr>
				<td colspan="2" align="center">
					<font size="3" color="blue">
						<fmt:message key="login.apresentacao" bundle="${idioma}" />
					</font>
				</td>
			</tr>
			<tr>
				<td align="right"><fmt:message key="login.usuario" bundle="${idioma}" /></td>
				<td align="left"><input type="text" name="login" size="25"></td>
			</tr>
			<tr>
				<td align="right"><fmt:message key="login.senha" bundle="${idioma}" /></td>
				<td align="left"><input type="password" name="senha" size="25"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="OK"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<font color="blue">
						<fmt:formatDate value="${data}" timeStyle="long" dateStyle="long" />
					</font>
				</td>
			</tr>
		</table>
	</form>

	<hr />Padrão do Navegador<br />
	<fmt:formatNumber value="123.45" type="currency" /><br />
	<fmt:formatNumber value="32.1" pattern=".000" /><br />
	<fmt:formatNumber value="123456.789" pattern="#,#00.0#" /><br />
	<fmt:formatDate value="${data}" timeStyle="long" dateStyle="long" /><br />
	<fmt:formatDate value="${data}" pattern="dd.MM.yyyy" /><br />
	<hr />Inglês<br />
	<fmt:setLocale value="en_US" />
	<fmt:formatNumber value="123.45" type="currency" /><br />
	<fmt:formatNumber value="32.1" pattern=".000" /><br />
	<fmt:formatNumber value="123456.789" pattern="#,#00.0#" /><br />
	<fmt:formatDate value="${data}" timeStyle="long" dateStyle="long" /><br />
	<fmt:formatDate value="${data}" pattern="dd.MM.yyyy" /><br />
	<hr />Francês<br />
	<fmt:setLocale value="fr_FR" />
	<fmt:formatNumber value="123.45" type="currency" /><br />
	<fmt:formatNumber value="32.1" pattern=".000" /><br />
	<fmt:formatNumber value="123456.789" pattern="#,#00.0#" /><br />
	<fmt:formatDate value="${data}" timeStyle="long" dateStyle="long" /><br />
	<fmt:formatDate value="${data}" pattern="dd.MM.yyyy" /><br />	
</body>
</html>