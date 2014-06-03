package br.com.treinaweb.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.treinaweb.dao.CategoriaDAOImpl;
import br.com.treinaweb.dao.ProdutoDAOImpl;
import br.com.treinaweb.entities.Categoria;
import br.com.treinaweb.entities.Produto;


@WebServlet("/Produto")
public class ProdutoController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String command = request.getParameter("cmd");
    ProdutoDAOImpl dao = new ProdutoDAOImpl();
    if(command != null){
      if(request.getParameter("id") != null){
        long id = Long.parseLong(request.getParameter("id").toString());
        Produto produto = dao.getById(Produto.class, id);
        request.setAttribute("produto", produto);
      }

      if(command.equalsIgnoreCase("edit")){
        CategoriaDAOImpl catDao = new CategoriaDAOImpl();
        List<Categoria> categorias = catDao.getAll(Categoria.class);
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/produto/edit.jsp").forward(request,response);
      }
      else if(command.equalsIgnoreCase("details")){
        request.getRequestDispatcher("/produto/details.jsp").forward(request,response);
      }
      else if(command.equalsIgnoreCase("delete")){
        if(request.getSession().getAttribute("idproduto") != null){
          long id = Long.parseLong(request.getSession().getAttribute("idproduto").toString());
          Produto produto = dao.getById(Produto.class, id);
          dao.remove(produto);
          response.sendRedirect("/ExemploLoja/Produto");
        }
      }
    }
    else{
      List<Produto> produtos = dao.getAll(Produto.class);
      request.setAttribute("produtos", produtos);
      request.getRequestDispatcher("/produto/list.jsp").forward(request,response);
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Produto produto = (Produto) request.getAttribute("produto");;
    if(produto == null){
      produto = new Produto();
      if(!request.getParameter("idProduto").isEmpty())
        produto.setIdProduto(Long.parseLong(request.getParameter("idProduto")));
      else
        produto.setIdProduto(0L);
      produto.setProduto(request.getParameter("produto"));
      produto.setCodigo(request.getParameter("codigo"));
      produto.setPreco(Double.parseDouble(request.getParameter("preco")));
      produto.setEstoque(Integer.parseInt(request.getParameter("estoque")));
      long idCategoria = Long.parseLong(request.getParameter("idcategoria"));
      CategoriaDAOImpl catDao = new CategoriaDAOImpl();
      Categoria categoria = catDao.getById(Categoria.class, idCategoria);
      produto.setCategoria(categoria);
    }
    try{
      ProdutoDAOImpl dao = new ProdutoDAOImpl();
      dao.save(produto);

      request.setAttribute("msg", "Gravado com sucesso!");
      if(produto.getIdProduto() > 0)
        response.sendRedirect("/ExemploLoja/Produto");
      else{
        CategoriaDAOImpl catDao = new CategoriaDAOImpl();
        List<Categoria> categorias = catDao.getAll(Categoria.class);
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/produto/edit.jsp").forward(request, response);
      }
    }catch (Exception e) {
      request.setAttribute("msg", "Erro: " + e.getMessage());
      request.getRequestDispatcher("/produto/edit.jsp").forward(request, response);
    }
  }
}