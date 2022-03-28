package pear.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pear.controller.UsuarioController;
import pear.model.Pedido;
import pear.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		UsuarioController usuarioController = new UsuarioController();
		Usuario usuario = usuarioController.buscaUsuario(login, senha);

		HttpSession sessao = request.getSession();
		sessao.setAttribute("usuarioLogado", usuario);
		Pedido pedido = (Pedido) sessao.getAttribute("pedido");

		if (usuario != null) {
			if ((Boolean) sessao.getAttribute("finalizar") == true) {
				sessao.setAttribute("finalizar", false);
				return "redirect:pear?acao=TelaFinalizar";
			}
			if (sessao.getAttribute("pedido") == null)
				return "redirect:pear?acao=TelaEntrada";
			return "redirect:pear?acao=TelaEntradaComAtributo&PedidoId=" + pedido.getId();
		} else {
			return "forward:loginInvalido.jsp";
		}
	}
}
