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

public class TelaSaida implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession sessao = request.getSession();
			sessao.invalidate();
			return "redirect:pear?acao=TelaEntrada";
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}