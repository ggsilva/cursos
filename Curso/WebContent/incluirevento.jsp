<!DOCTYPE HTML>
<%@page contentType="text/html" %>
<%@page pageEncoding="ISO-8859-1" %>
<html>
    <head>
        <title>Gravando Eventos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <LINK HREF="/Curso/css/estilo.css" TYPE="text/css" REL="stylesheet">
    </head>
    <body bgcolor="white">
        <table border="0" align="center" >
            <tr>
                <td align="center">
					<form action="gravarEvento">
						Evento:<br /><input type="text" name="evento" value="" /><br />
						Data:<br /><input type="text" name="data" value="" /><br />
						<input type="submit" value="Salvar" name="incluir" />
					</form>
                </td>
            </tr>
         </table>
    </body>
</html>