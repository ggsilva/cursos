<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Propriedades do Java Beans</title>
</head>
<body>
	<jsp:useBean id="aluno" class="br.com.treinaweb.javaee.Alunos"></jsp:useBean>
	<h2>Propriedades do Java Beans</h2>
	<jsp:setProperty name="aluno" property="nome" value="Guilherme" />
	<jsp:setProperty name="aluno" property="cep" value="87.030-240" />
	<table border="1">
		<tr>
			<td>Propriedade</td>
			<td>Conteúdo</td>
		</tr>
		<tr>
			<td>Nome</td>
			<td>${aluno.nome}</td>
		</tr>
		<tr>
			<td>CEP</td>
			<td>${aluno.cep}</td>
		</tr>
	</table>
</body>
</html>