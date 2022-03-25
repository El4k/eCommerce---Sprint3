package pear.controller;

import pear.dao.UsuarioDAO;
import pear.model.Endereco;
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
	
	public Usuario buscaUsuario(String login, String senha) {
		return this.usuarioDAO.buscaUsuario(login, senha);
	}
	
	public Usuario consultarId(Long id) {
		return this.usuarioDAO.consultarId(id);
	}
	
}
