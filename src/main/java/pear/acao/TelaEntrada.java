package pear.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pear.controller.PedidoController;
import pear.controller.ProdutoController;
import pear.model.Pedido;
import pear.model.Produto;

public class TelaEntrada implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		ProdutoController produtoController = new ProdutoController();
		List<Produto> produtos = produtoController.buscaTodos();

		Pedido pedido = new Pedido(0,0,0);
		PedidoController pedidoController = new PedidoController();
		pedidoController.cadastrar(pedido);
		
		sessao.setAttribute("pedido", pedido);
		sessao.setAttribute("produtos", produtos);
		sessao.setAttribute("estoqueAcima", true);
		sessao.setAttribute("finalizar", false);
		
		return "forward:entrada.jsp";
	}

}
