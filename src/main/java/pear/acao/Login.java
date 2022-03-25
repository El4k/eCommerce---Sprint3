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
			String senha = request.getParameter("senha");
			
			UsuarioController usuarioController = new UsuarioController();
			Usuario usuario = usuarioController.buscaUsuario(login, senha);
			
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			if(usuario != null) {
				System.out.println("login com sucesso");
				return "redirect:pear?acao=TelaEntrada";
			}else {
				System.err.println("login invalido");
				return "redirect:pear?acao=TelaIndex";
			}
		} catch (Exception e) {
			System.out.println("ERROOOOO");
			e.printStackTrace();
			return "redirect:pear?acao=TelaIndex";
		}
	}
}