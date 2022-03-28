package pear.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pear.controller.EnderecoController;
import pear.controller.UsuarioController;
import pear.model.Endereco;
import pear.model.Usuario;

public class Atualizar implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		String nomeCliente = request.getParameter("login");
		String senhaCliente = request.getParameter("senha");
		String paramRua = request.getParameter("rua");
		Integer paramNumero = Integer.parseInt(request.getParameter("numero"));
		String paramCidade = request.getParameter("cidade");
		String paramEstado = request.getParameter("estado");
		String paramCEP = request.getParameter("CEP");
		String paramBairro = request.getParameter("bairro");

		usuario.setLogin(nomeCliente);
		usuario.setSenha(senhaCliente);

		Endereco enderecoNovo = new Endereco(paramRua, paramNumero, paramCidade, paramEstado, paramCEP, paramBairro);
		EnderecoController enderecoController = new EnderecoController();
		
		usuario.setEndereco(enderecoNovo);

		UsuarioController usuarioController = new UsuarioController();

		enderecoController.cadastrar(enderecoNovo);
		usuarioController.atualizar(usuario);

		sessao.setAttribute("usuarioLogado", usuario);
		
		return "redirect:pear?acao=TelaLogin";
	}

}
