package pear.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pear.controller.PedidoController;
import pear.model.Pedido;

public class TelaCarrinho implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.err.println("chamando o carrinho de compras");
		System.out.println("atualizou");
		return "forward:carrinho.jsp";
	}

}
