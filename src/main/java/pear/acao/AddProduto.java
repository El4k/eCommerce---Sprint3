package pear.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pear.controller.ProdutoController;
import pear.dao.PedidoDAO;
import pear.dao.ProdutoDAO;
import pear.model.Pedido;
import pear.model.Produto;

public class AddProduto implements Acao {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String idPedido = request.getParameter("PedidoId");
		System.out.println(idPedido + " id pedido");
		String idProduto = request.getParameter("produto");
		System.out.println(idProduto + " id produto");
		
		Long idProd = Long.parseLong(idProduto);
		System.out.println(idProd + "id do produto convertido");
		Pedido pedido = new Pedido();
		PedidoDAO pedidoDAO = new PedidoDAO();
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		System.out.println("pegando o idPedido" + idPedido);
		if ((idPedido == null) || idPedido=="") {
			
			pedidoDAO.cadastrar(pedido);
		} else {
			Long idPed = Long.parseLong(idPedido);	
			pedido = pedidoDAO.consultarPorId(idPed);
		}
		
		produto = produtoDAO.consultarPorId(idProd);
		pedido.addProduto(produto);
		
		pedidoDAO.atualizar(pedido);
		
		session.setAttribute("produto", produto);
		session.setAttribute("pedido", pedido);
		
		System.err.println("redirect:pear?acao=TelaEntrada&PedidoId=" + pedido.getId());
		
		return "redirect:pear?acao=TelaEntrada&PedidoId=" + pedido.getId();

	}
}
