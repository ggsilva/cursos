package br.com.treinaweb.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.treinaweb.dao.CategoriaDAOImpl;
import br.com.treinaweb.entities.Categoria;

/**
 * Servlet implementation class CategoriaController
 */
@WebServlet("/Categoria")
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CategoriaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("cmd");
		
		if(command == null){
			CategoriaDAOImpl dao = new CategoriaDAOImpl();
			List<Categoria> categorias = dao.getAll(Categoria.class);
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("/categoria/list.jsp").forward(request, response);
		} else {			
			if(request.getParameter("id") != null){
				CategoriaDAOImpl dao = new CategoriaDAOImpl();
				long id = Long.parseLong(request.getParameter("id"));
				Categoria categoria = dao.getById(Categoria.class, id);
				request.setAttribute("categoria", categoria);
			}
			
			if(command.equalsIgnoreCase("edit"))
				getServletConfig().getServletContext().getRequestDispatcher("/categoria/edit.jsp").forward(request, response);
			else if(command.equalsIgnoreCase("edit"))
				getServletConfig().getServletContext().getRequestDispatcher("/categoria/details.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Categoria categoria = (Categoria) request.getAttribute("categoria");
		
		if(categoria == null){
			categoria = new Categoria();
			
			if(!request.getParameter("idCategoria").isEmpty())
				categoria.setIdCategoria(Long.parseLong(request.getParameter("idCategoria")));
			else
				categoria.setIdCategoria(0L);
			
			categoria.setNome(request.getParameter("nome").toString());
		}

		try{
			CategoriaDAOImpl dao = new CategoriaDAOImpl();
			dao.save(categoria);
			request.setAttribute("msg", "Gravado com sucesso!");
			
			if(categoria.getIdCategoria() > 0)
				response.sendRedirect("/ExemploLoja/Categoria");
			else
				request.getRequestDispatcher("/categoria/edit.jsp").forward(request, response);
				
		}catch(Exception ex){
			request.setAttribute("msg", "Erro: " + ex.getMessage());
			request.getRequestDispatcher("/categoria/edit.jsp").forward(request, response);
		}
	}

}
