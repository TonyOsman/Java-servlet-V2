package br.com.fiap.lojaweb;

import java.io.IOException;

import br.com.fiap.lojaclasses.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * Servlet implementation class CategoriaServlet
 */
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Categoria categoria = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() {
    	categoria = new Categoria();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acao = request.getParameter("acao");
		
		if (acao == null) {
			acao = "listar";
		}
		
		if (acao.equals("novo")) {
			System.out.println("Inserir novo");
			request.getRequestDispatcher("Categorias.jsp").forward(request, response);
		} else if (acao.equals("alterar")) {
			System.out.println("Alterar registro");
			request.getRequestDispatcher("Categorias.jsp").forward(request, response);
			
		} else {
			List<Categoria> lista = categoria.pesquisarCategorias();
			request.setAttribute("categorias", lista);
			request.getRequestDispatcher("Lista.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria();
		
		cat1.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
		cat1.setDescricao(request.getParameter("descricao"));
		cat1.inserirCategoria();
		request.getRequestDispatcher("Categoria.jsp").forward(request, response);
	}

}
