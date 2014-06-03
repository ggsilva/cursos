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

@WebServlet("/Categoria")
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAOImpl categoriaDao;

    public CategoriaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("cmd");
		
		if(command == null){
			List<Categoria> categorias = getCategoriaDao().getAll(Categoria.class);
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("/categoria/list.jsp").forward(request, response);
		} else {			
			if(request.getParameter("id") != null){
				long id = Long.parseLong(request.getParameter("id"));
				Categoria categoria = getCategoriaDao().getById(Categoria.class, id);
				request.setAttribute("categoria", categoria);
			}
			
			if(command.equalsIgnoreCase("edit"))
				getServletConfig().getServletContext().getRequestDispatcher("/categoria/edit.jsp").forward(request, response);
			else if(command.equalsIgnoreCase("details"))
				getServletConfig().getServletContext().getRequestDispatcher("/categoria/details.jsp").forward(request, response);
			else if(command.equalsIgnoreCase("delete"))
				response.sendRedirect(deleteCategoria(request.getSession().getAttribute("idcategoria")));
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
			getCategoriaDao().save(categoria);
			request.setAttribute("msg", "Gravado com sucesso!");
			categoriaDao = null;
			if(categoria.getIdCategoria() > 0)
				response.sendRedirect("/ExemploLoja/Categoria");
			else
				request.getRequestDispatcher("/categoria/edit.jsp").forward(request, response);
		}catch(Exception ex){
			request.setAttribute("msg", "Erro: " + ex.getMessage());
			request.getRequestDispatcher("/categoria/edit.jsp").forward(request, response);
		}
	}
	
	private String deleteCategoria(Object idCategoria) {
		if(idCategoria != null){		
			long id = Long.parseLong(idCategoria.toString());
			Categoria categoria = getCategoriaDao().getById(Categoria.class, id);
			getCategoriaDao().remove(categoria);
		}
		return "/ExemploLoja/Categoria";
	}
	
	private CategoriaDAOImpl getCategoriaDao() {
		if(categoriaDao == null)
			categoriaDao = new CategoriaDAOImpl();
		return categoriaDao;
	}
}
