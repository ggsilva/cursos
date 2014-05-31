<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuário Gravado</title>
</head>
<body>
	<jsp:useBean id="user" scope="session" class="br.com.treinaweb.javaee.Usuario"></jsp:useBean>
	<table border="0" width="300" bgcolor="whitesmoke">
		<tr>
			<td align="right">Nome:</td>
			<td>
				<jsp:getProperty property="nome" name="user"/>
			</td>
		</tr>
		<tr>
			<td align="right">Login:</td>
			<td>
				<jsp:getProperty property="login" name="user"/>
			</td>
		</tr>
		<tr>
			<td align="right">Senha:</td>
			<td>
				<jsp:getProperty property="senha" name="user"/>
			</td>
		</tr>
	</table>
</body>
</html>