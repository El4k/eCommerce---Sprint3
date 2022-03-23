package pear.controller;

import pear.dao.EnderecoDAO;
import pear.model.Endereco;

public class EnderecoController {
	
	private EnderecoDAO enderecoDAO;
	
	public EnderecoController() {
		enderecoDAO = new EnderecoDAO();
	}
	
	public void cadastrar(Endereco address) {
		this.enderecoDAO.cadastrar(address);
	}
	
	public void atualizar(Endereco address) {
		this.enderecoDAO.atualizar(address);
	}
	
	public void remover(Endereco address) {
		this.enderecoDAO.remover(address);
	}
}
