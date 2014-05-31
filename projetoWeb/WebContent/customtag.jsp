<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tlds/diassem.tld" prefix="t"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Exemplo de criação de tag</title>
</head>
	<body>
		Semana de hoje: <t:semana />
		<br /><br />
		Semana de 20/03/2017: <t:semana data="20/03/2017" />

		<br /><br />
		Semana de 22/07/2020:
		<t:semanabody>
			22/07/2020
		</t:semanabody>.
		<br /><br />
		Semana de 08/06/2021: <t:semanabody data="08/06/2021" />
		<br /><br />
		Semana de hoje: <s:semana />.
		<br /><br />
		Semana de 20/03/2017: <s:semana data="20/03/2017" />.
		<br /><br />
		Semana de 22/07/2020:
		<s:semana>	
			22/07/2020
		</s:semana>.
		<br /><br />
		<s:rodape>
		  <jsp:attribute name="nomeSite">
		  Treinaweb Cursos
		  </jsp:attribute>
		  <jsp:body>
		  Conteúdo do rodapé
		  </jsp:body>
		</s:rodape>
	</body>
</html>