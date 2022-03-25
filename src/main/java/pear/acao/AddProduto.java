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
		Pedido pedido = (Pedido) session.getAttribute("pedido");
		
		String idProduto = request.getParameter("produto");
		Long idProd = Long.parseLong(idProduto);
		
		Produto produto = new Produto();
		ProdutoController produtoController = new ProdutoController();
		
		produto = produtoController.consultarPorId(idProd);
		System.err.println(pedido.getListaProdutos());
		pedido.addProduto(produto);
		System.out.println(pedido.getListaProdutos());
		
		PedidoController pedidoController = new PedidoController();
		pedidoController.atualizar(pedido);
		
		return "redirect:pear?acao=TelaEntradaComAtributo&PedidoId=" + pedido.getId();
		
//		HttpSession session = request.getSession();
//		
//		String idPedido = request.getParameter("PedidoId");
//		System.out.println(idPedido + " id pedido");
//		String idProduto = request.getParameter("produto");
//		System.out.println(idProduto + " id produto");
//		
//		Long idProd = Long.parseLong(idProduto);
//		System.out.println(idProd + "id do produto convertido");
//		
//		Pedido pedido = (Pedido) session.getAttribute("pedido");
//		PedidoController pedidoController = new PedidoController();
//		
//		Produto produto = new Produto();
//		ProdutoController produtoController = new ProdutoController();
//		System.out.println("pegando o idPedido" + idPedido);
//		
//		if ((idPedido == null) || idPedido=="") {
//			
//			pedidoController.cadastrar(pedido);
//		} else {
//			Long idPed = Long.parseLong(idPedido);	
//			pedido = pedidoController.consultarPorId(idPed);
//		}
//		
//		produto = produtoController.consultarPorId(idProd);
//		pedido.addProduto(produto);
//		
//		pedidoController.atualizar(pedido);
//		
//		session.setAttribute("produto", produto);
//		session.setAttribute("pedido", pedido);
//		
//		System.err.println("redirect:pear?acao=TelaEntrada&PedidoId=" + pedido.getId());
//		
//		return "redirect:pear?acao=TelaEntrada&PedidoId=" + pedido.getId();

	}
}
