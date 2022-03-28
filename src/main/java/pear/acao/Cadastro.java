package pear.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pear.controller.EnderecoController;
import pear.controller.UsuarioController;
import pear.model.Endereco;
import pear.model.Usuario;

public class Cadastro implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		String nomeCliente = request.getParameter("login");
		String senhaCliente = request.getParameter("senha");
		String paramRua = request.getParameter("rua");
		Integer paramNumero = Integer.parseInt(request.getParameter("numero"));
		String paramCidade = request.getParameter("cidade");
		String paramEstado = request.getParameter("estado");
		String paramCEP = request.getParameter("CEP");
		String paramBairro = request.getParameter("bairro");

		UsuarioController usuarioController = new UsuarioController();
		List<Usuario> usuarios = usuarioController.buscarTodos();

		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getLogin().equals(nomeCliente)) {
				return "forward:loginRepetido.jsp";
			}
		}

		EnderecoController enderecoController = new EnderecoController();

		Endereco endereco = new Endereco(paramRua, paramNumero, paramCidade, paramEstado, paramCEP, paramBairro);
		Usuario usuario = new Usuario(nomeCliente, senhaCliente, endereco);

		usuarioController = new UsuarioController();

		enderecoController.cadastrar(endereco);
		usuarioController.cadastrar(usuario);
		sessao.setAttribute("usuarioLogado", usuario);
		
		return "redirect:pear?acao=TelaLogin";
	}

}
