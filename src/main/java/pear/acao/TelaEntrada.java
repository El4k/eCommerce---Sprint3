package pear.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pear.controller.ProdutoController;

import pear.model.Produto;

public class TelaEntrada implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ProdutoController produtoController = new ProdutoController();
		List<Produto> produtos = produtoController.buscaTodos();
			
		session.setAttribute("produtos", produtos);
		
		return "forward:entrada.jsp";
	}

}
