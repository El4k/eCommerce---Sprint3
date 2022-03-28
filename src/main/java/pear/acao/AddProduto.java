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

public class AddProduto implements Acao {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
//		Pedido pedido = (Pedido) session.getAttribute("pedido");
		sessao.setAttribute("estoqueAcima", false);

		PedidoController pedidoController = new PedidoController();
		String idPedido = request.getParameter("PedidoId");
		Long idPed = Long.parseLong(idPedido);

		Pedido pedido = pedidoController.consultarPorId(idPed);

		String idProduto = request.getParameter("produto");
		Long idProd = Long.parseLong(idProduto);

		Produto produto = new Produto();
		ProdutoController produtoController = new ProdutoController();

		produto = produtoController.consultarPorId(idProd);
		pedido.addProduto(produto);

		int quantidadePedido = 0;
		Long quantidadeEstoque = produto.getQuantidadeEstoque();

		List<Produto> produtos = pedido.getListaProdutos();
		for (int j = 0; j < produtos.size(); j++) {
			if (produtos.get(j).getId() == produto.getId()) {
				quantidadePedido++;
			}
			if (quantidadePedido > quantidadeEstoque) {
				return "forward:erroEstoque.jsp";
			}
		}

		pedidoController.atualizar(pedido);
		sessao.setAttribute("pedido", pedido);

		return "redirect:pear?acao=TelaEntradaComAtributo&PedidoId=" + pedido.getId();
	}
}
