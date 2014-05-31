<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Action e Java Bean</title>
</head>
<body>
	<jsp:useBean id="alun" class="br.com.treinaweb.javaee.Alunos"></jsp:useBean>
	<jsp:setProperty property="*" name="alun" />
	<form method="POST">
		<table border="0" width="300">
			<tr bgcolor="whitesmoke">
				<td width="100"></td>
				<td width="200"></td>
			</tr>
            <tr>
            	<td align="right">Nome: </td>
            	<td>
            		<input type="text" name="nome">
            	</td>
            </tr>
            <tr>
            	<td align="right">Endereço: </td>
            	<td>
            		<input type="text" name="endereco">
            	</td>
            <tr>
            	<td align="right">CEP: </td>
            	<td>
            		<input type="text" name="cep">
            	</td>
            </tr>
            <tr>
            	<td align="right">Cidade: </td>
            	<td>
            		<input type="text" name="cidade">
            	</td>
            </tr>
            <tr>
            	<td align="right">Estado: </td>
            	<td>
            		<input type="text" name="estado">
            	</td>
            </tr>
            <tr>
            	<td colspan="2" align="center"><input type="submit" value="Incluir" ></td>
            </tr>
		</table>	
	</form>
    <table border="0" width="300">
        <tr bgcolor="whitesmoke">
        	<td width="100"></td>
        	<td width="200"></td>
        </tr>
        <tr>
        	<td align="right">Nome: </td>
        	<td>
        		<jsp:getProperty name="alun" property="nome" />
        	</td>
        </tr>
        <tr>
        	<td align="right">Endereco: </td>
        	<td>
        		<jsp:getProperty name="alun" property="endereco" />
        	</td>
        </tr>
        <tr>
        	<td align="right">CEP: </td>
        	<td>
        		<jsp:getProperty name="alun" property="cep" />
        	</td>
        </tr>
        <tr>
        	<td align="right">Cidade: </td>
        	<td>
        		<jsp:getProperty name="alun" property="cidade" />
        	</td>
        </tr>
        <tr>
        	<td align="right">Estado: </td>
        	<td>
        		<jsp:getProperty name="alun" property="estado" />
        	</td>
        </tr>
    </table>
</body>
</html>