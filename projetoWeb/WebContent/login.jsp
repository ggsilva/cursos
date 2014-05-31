<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tela de Login</title>
  </head>
  <body>
      <form action="verificarlogin.jsp" method="post">
          <table border="0" align="center">
              <tr>
                  <td align="right">Login:</td>
                  <td align="left"><input type="text" name="login"></td>
              </tr>
              <tr>
                  <td align="right">Senha:</td>
                  <td align="left"><input type="password" name="senha"></td>
              </tr>
              <tr>
                  <td colspan="2" align="center"><input type="submit" value="Entrar"></td>
              </tr>
          </table>
      </form>
  </body>
</html>