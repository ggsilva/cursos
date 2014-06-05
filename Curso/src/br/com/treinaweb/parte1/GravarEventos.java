package br.com.treinaweb.parte1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GravarEventos
 */
@WebServlet("/GravarEventos")
public class GravarEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String evento = request.getParameter("evento");
		String data = request.getParameter("data");
		
		response.setContentType("text/html;charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println("<head>");
		out.println("<title>Gravando Eventos no Hibernate</title>");
		out.println("<LINK href='/Curso/css/estilo.css' type='text/css' rel='stylesheet' />");
		out.println("</head>");
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Gravando Eventos no Hibernate</h2>");
		out.println("Evento: " + evento + " ");
		out.println("Data: " + data + " ");
		
		GerenciadorEventos gerenciadorEventos = new GerenciadorEventos();
		if(gerenciadorEventos.salvarEvento(evento, data))
			out.println("<h3>Gravando com Sucesso!</h3>");
		else
			out.println("<h3>Não Gravado!</h3>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
