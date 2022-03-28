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
import pear.model.Usuario;

public class TelaFinalizar implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		if (usuario == null) {
			sessao.setAttribute("finalizar", true);
			return "forward:index.jsp";
		}

		// implementação da função
		Pedido pedido = (Pedido) sessao.getAttribute("pedido");
		//PedidoController pedidoController = new PedidoController();
		//pedido = pedidoController.consultarPorId(pedido.getId());
		ProdutoController produtoController = new ProdutoController();
		// final da implementação da função

		// início da função
		List<Produto> produtos = pedido.getListaProdutos();
		Long maiorID = produtoController.buscaMaiorID();
		System.err.println("pegando o maior id " + maiorID);
		for (Long i = 1l; i <= maiorID; i++) {
			System.err.println("pegando o valor de i " + i);
			Long num = 0l;

			for (int j = 0; j < produtos.size(); j++) {
				System.err.println("pegando o valor de j " + j);
				System.err.println(produtos.get(j).getId());
				if (produtos.get(j).getId() == i) {
					num += 1;
				}
			}

			Produto produto = produtoController.consultarPorId(i);
			Long verifica = produto.verificaEstoque(num);
			System.out.println("Quantidade de valores no estoque: " + produto.getQuantidadeEstoque());
			if (verifica == null && num != 0l) {
				return "forward:deuRuim.jsp";
			} else {
				produto.setQuantidadeEstoque(verifica);
				produtoController.atualizar(produto);
				System.err.println("Teste de estoque: " + verifica);
				System.out.println("Estoque: " + produto.getQuantidadeEstoque());
			}
		}

		// final da função
		sessao.setAttribute("usuarioLogado", usuario);
		return "forward:finalizarCompra.jsp";
	}
}