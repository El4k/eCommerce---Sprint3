package pear.controller;

import pear.dao.UsuarioDAO;
import pear.model.Usuario;

public class UsuarioController {
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioController() {
		usuarioDAO = new UsuarioDAO();
	}
	
	public void cadastrar(Usuario user) {
		this.usuarioDAO.cadastrar(user);
	}
	
	public void atualizar(Usuario user) {
		this.usuarioDAO.atualizar(user);
	}
	
	public void remover(Usuario user) {
		this.usuarioDAO.remover(user);
	}
}
