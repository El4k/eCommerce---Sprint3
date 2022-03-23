package pear.controller;

import pear.dao.ProdutoDAO;
import pear.model.Produto;

public class ProdutoController {
	
	private ProdutoDAO produtoDAO;
	
	public ProdutoController() {
		produtoDAO = new ProdutoDAO();
	}
	
	public void cadastrar(Produto product) {
		this.produtoDAO.cadastrar(product);
	}
	
	public void atualizar(Produto product) {
		this.produtoDAO.atualizar(product);
	}
	
	public void remover(Produto product) {
		this.produtoDAO.remover(product);
	}
}
