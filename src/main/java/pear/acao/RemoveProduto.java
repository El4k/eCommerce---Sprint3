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

public class RemoveProduto implements Acao {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		Pedido pedido = (Pedido) sessao.getAttribute("pedido");
		
		PedidoController pedidoController = new PedidoController();
		ProdutoController produtoController = new ProdutoController();
		pedido = pedidoController.consultarPorId(pedido.getId()); 
		
		String idProduto = request.getParameter("produto");
		Long idProd = Long.parseLong(idProduto);
		List<Produto> produtos = pedido.getListaProdutos();

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == idProd) {
				pedido.removeProduto(i);
				break;
			}
		}
		pedidoController.atualizar(pedido);
		sessao.setAttribute("pedido", pedido);
		
		return "redirect:pear?acao=TelaEntradaComAtributo&PedidoId=" + pedido.getId();
	}
}
