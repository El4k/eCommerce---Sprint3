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
		
		Endereco CEPExiste = new Endereco();
		EnderecoController enderecoController = new EnderecoController();
		CEPExiste = enderecoController.buscaCEP(paramCEP);
		
		if (CEPExiste != null) {
			Usuario usuario = new Usuario(nomeCliente, senhaCliente, CEPExiste);

			UsuarioController usuarioController = new UsuarioController();

			usuarioController.cadastrar(usuario);
			sessao.setAttribute("usuarioLogado", usuario);
		} else {

			Endereco endereco = new Endereco(paramRua, paramNumero, paramCidade, paramEstado, paramCEP);
			Usuario usuario = new Usuario(nomeCliente, senhaCliente, endereco);

			UsuarioController usuarioController = new UsuarioController();

			enderecoController.cadastrar(endereco);
			usuarioController.cadastrar(usuario);
			sessao.setAttribute("usuarioLogado", usuario);
		}
		return "redirect:pear?acao=TelaLogin";
	}

}
