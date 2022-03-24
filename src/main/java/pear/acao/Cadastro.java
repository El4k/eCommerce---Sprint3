package pear.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pear.controller.EnderecoController;
import pear.controller.UsuarioController;
import pear.model.Endereco;
import pear.model.Usuario;

public class Cadastro implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeCliente = request.getParameter("login");
		String senhaCliente = request.getParameter("senha");

		String paramRua = request.getParameter("rua");
		String paramNumero = request.getParameter("numero");
		String paramCidade = request.getParameter("cidade");
		String paramEstado = request.getParameter("estado");
		String paramCEP = request.getParameter("CEP");

		Integer numero = Integer.valueOf(paramNumero);

		System.out.println(nomeCliente + senhaCliente);
		
		Endereco CEPExiste = new Endereco();
		EnderecoController enderecoController = new EnderecoController();
		CEPExiste = enderecoController.buscaCEP(paramCEP);
		
		if (CEPExiste != null) {
			Usuario usuario = new Usuario(nomeCliente, senhaCliente, CEPExiste);

			UsuarioController usuarioController = new UsuarioController();

			usuarioController.cadastrar(usuario);
		} else {

			Endereco endereco = new Endereco(paramRua, numero, paramCidade, paramEstado, paramCEP);
			Usuario usuario = new Usuario(nomeCliente, senhaCliente, endereco);

			UsuarioController usuarioController = new UsuarioController();

			enderecoController.cadastrar(endereco);
			usuarioController.cadastrar(usuario);
		}
		return "redirect:pear?acao=TelaIndex";
	}

}
