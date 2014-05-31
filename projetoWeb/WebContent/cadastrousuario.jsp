<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>
<jsp:useBean id="user" scope="session" class="br.com.treinaweb.javaee.Usuario" />
    <jsp:setProperty name="user" property="*" />
    <form method="POST">
        <table border="0" width="300">
            <tr bgcolor="whitesmoke"><td width="100"></td><td width="200"></td></tr>
            <tr><td align="right">Nome: </td><td><input type="text" name="nome"></td></tr>
            <tr><td align="right">Login: </td><td><input type="text" name="login"></td></tr>
            <tr><td align="right">Senha: </td><td><input type="password" name="senha"></td></tr>
            <tr><td colspan="2" align="center"><input type="submit" name="incluir" value="Incluir"></td></tr>
        </table>
    </form>
    <%
         if(request.getParameter("incluir") != null){
           //user.save();
           response.sendRedirect("gravausuario.jsp");
         }
    %>
    <table bgcolor="whitesmoke" width="300" border="0">
        <tr><td>Status:</td><td><jsp:getProperty name="user" property="status" /></td></tr>
    </table>
</body>
</html>