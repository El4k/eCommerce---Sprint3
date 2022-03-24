package pear.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pear.controller.UsuarioController;
import pear.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			UsuarioController usuarioController = new UsuarioController();
			Usuario usuario = usuarioController.buscaUsuario(login, password);
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:pear?acao=TelaLogin";
		} catch (Exception e) {
			return "redirect:pear?acao=TelaIndex";
		}
	}
}