<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incluir Usuario</title>
</head>
<body>
	<fieldset style="width: 150px;">
		<legend>Usuário</legend>
		<form action="salvarusuario.jsp" method="POST">
			<div style="font-weight: bold;">Nome:</div>
			<div>
				<input type="text" name="nome" value=""/>
			</div>
			<div style="font-weight: bold;">Login:</div>
			<div>
				<input type="text" name="login" value=""/>
			</div>
			<div style="font-weight: bold;">Senha:</div>
			<div>
				<input type="password" name="senha" value=""/>
			</div>
			<div>
				<input type="submit" name=	"incluir" value="Incluir"/>
			</div>
		</form>
	</fieldset>
</body>
</html>