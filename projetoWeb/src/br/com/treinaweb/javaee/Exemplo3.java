package br.com.treinaweb.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(
		name ="Exemplo3",
		urlPatterns = {"/Ex3"},
		initParams = {
				@WebInitParam(name = "empresa"    , value = "Treinaweb Cursos"),
				@WebInitParam(name = "autor"      , value = "Aluno"),
				@WebInitParam(name = "dataCriacao", value = "20/10/2014")
		})

public class Exemplo3 implements Servlet {
	
	private String empresa;
	private String autor;
	private String dataCriacao;

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		empresa = servletConfig.getInitParameter("empresa");
		autor = servletConfig.getInitParameter("autor");
		dataCriacao = servletConfig.getInitParameter("dataCriacao");
	}

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse)
			throws ServletException, IOException {
		servletResponse.setContentType("text/html;charset=UTF-8");
		PrintWriter out = servletResponse.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Informações do Sistema</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Informações do Sistema:</h2>");
		out.println("<h4>Servidor: " + empresa + "</h4>");
		out.println("<h4>Banco: " + autor + "</h4>");
		out.println("<h4>Usuário: " + dataCriacao + "</h4>");
		out.println("</body>");
		out.println("</html>");
	}

}
