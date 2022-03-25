package pear.acao;

import java.io.IOException;

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
		
		HttpSession session = request.getSession();
//		Pedido pedido = (Pedido) session.getAttribute("pedido");
		
		PedidoController pedidoController = new PedidoController();
		String idPedido = request.getParameter("PedidoId");
		Long idPed = Long.parseLong(idPedido);
		
		Pedido pedido = pedidoController.consultarPorId(idPed); 
		
		String idProduto = request.getParameter("produto");
		Long idProd = Long.parseLong(idProduto);
		
		Produto produto = new Produto();
		ProdutoController produtoController = new ProdutoController();
		
		produto = produtoController.consultarPorId(idProd);
		System.err.println(pedido.getListaProdutos());
		pedido.addProduto(produto);
		System.out.println(pedido.getListaProdutos());
		
//		PedidoController pedidoController = new PedidoController();
		pedidoController.atualizar(pedido);
		
		return "redirect:pear?acao=TelaEntradaComAtributo&PedidoId=" + pedido.getId();
		
	}
}
