package pear.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TelaEntradaComAtributo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		System.err.println("entrando no carrinho");
		session.getAttribute("PedidoId");
		session.getAttribute("produtos");
		
		return "forward:entrada.jsp";
	}

}
