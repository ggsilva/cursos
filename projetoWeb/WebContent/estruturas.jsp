<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estruturas em JSP</title>
</head>
<body>
	<h3>Exemplo com o for</h3>
	<%
		String tab = "";
		Calendar calendario = Calendar.getInstance();
		int hora = calendario.get(Calendar.HOUR_OF_DAY);
		if(hora >= 5 && hora < 12){
			tab = "Bom Dia";
		}else if(hora >= 5 && hora < 12){
			tab = "Boa Tarde";
		}else if(hora >= 5 && hora < 12){
			tab = "Boa Noite";
		}else{
			tab = "Boa Madrugada <br>";
		}
		out.println(tab);

		tab = "";
		int mesAtual = calendario.get(Calendar.MONTH) + 1;
		switch(mesAtual){
		case 1:
			tab = "Janeiro";
			break;
		case 2:
			tab = "Fevereiro";
			break;
		case 3:
			tab = "Março";
			break;
		case 4:
			tab = "Abril";
			break;
		case 5:
			tab = "Maio";
			break;
		case 6:
			tab = "Junho";
			break;
		case 7:
			tab = "Julho";
			break;
		case 8:
			tab = "Agostp";
			break;
		case 9:
			tab = "Setembro";
			break;
		case 10:
			tab = "Outubro";
			break;
		case 11:
			tab = "Novembro";
			break;
		case 12:
			tab = "Dezembro";
			break;
		}
		out.println("Mês Atual: " + tab);
		
		tab = "";
		tab += "<table border='1'>\n";
		tab += "	<tr bgcolor='writesmoke'>\n";
		tab += "		<td>Código</td>\n";
		tab += "		<td>Produtos</td>\n";
		tab += "	</tr>\n";
		for(int i=1;i <= 10;i++){
			tab += "	<tr bgcolor='writesmoke'>\n";
			tab += "		<td>" + i + "</td>\n";
			tab += "		<td>P" + i + "</td>\n";
			tab += "	</tr>\n";
		}
		tab += "</table>";
		out.println(tab);
		
		tab = "";
		tab += "<table border='1'>\n";
		tab += "	<tr bgcolor='writesmoke'>\n";
		tab += "		<td>Código</td>\n";
		tab += "		<td>Produtos</td>\n";
		tab += "	</tr>\n";
		int i = 1;
		while(i<=10){
			tab += "	<tr>\n";
			tab += "		<td>" + i + "</td>\n";
			tab += "		<td>P" + i + "</td>\n";
			tab += "	</tr>\n";
			i++;
		}
		tab += "</table>";
		out.println(tab);
		
		tab = "";
		tab += "<table border='1'>\n";
		tab += "	<tr bgcolor='writesmoke'>\n";
		tab += "		<td>Código</td>\n";
		tab += "		<td>Produtos</td>\n";
		tab += "	</tr>\n";
		i = 1;
		do{
			tab += "	<tr bgcolor='red'>\n";
			tab += "		<td>" + i + "</td>\n";
			tab += "		<td>P" + i + "</td>\n";
			tab += "	</tr>\n";
			i++;
		}while(i<=10);
		tab += "</table>";
		out.println(tab);
	%>
</body>
</html>