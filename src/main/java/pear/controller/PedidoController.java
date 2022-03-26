package pear.controller;

import pear.dao.PedidoDAO;
import pear.model.Pedido;

public class PedidoController {

	private PedidoDAO pedidoDAO;

	public PedidoController() {
		pedidoDAO = new PedidoDAO();
	}

	public void cadastrar(Pedido order) {
		this.pedidoDAO.cadastrar(order);
	}

	public void atualizar(Pedido order) {
		this.pedidoDAO.atualizar(order);
	}

	public void remover(Pedido order) {
		this.pedidoDAO.remover(order);
	}

	public Pedido consultarPorId(Long i) {
		return this.pedidoDAO.consultarPorId(i);
	}
}
