package pear.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pear.model.Usuario;
import pear.util.CorreiosUtil;

public class TelaLogin implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		if (usuario != null) {
			sessao.setAttribute("usuarioLogado", usuario);
			CorreiosUtil.executa(request, response);
			return "forward:frete.jsp";
		}
		
		return "forward:login.jsp";
	}

}
