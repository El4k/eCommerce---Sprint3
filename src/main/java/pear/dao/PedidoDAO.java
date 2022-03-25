package pear.dao;

import javax.persistence.EntityManager;

import pear.model.Pedido;
import pear.util.JPAUtil;

public class PedidoDAO {

	private EntityManager em = JPAUtil.getEntityManager();

	public PedidoDAO() {

	}

	public void cadastrar(Pedido order) {
		em.getTransaction().begin();
		this.em.persist(order);
		em.getTransaction().commit();
		em.close();
	}

	public void atualizar(Pedido order) {
		em.getTransaction().begin();
		this.em.merge(order);
		em.getTransaction().commit();
		em.close();
	}

	public void remover(Pedido order) {
		em.getTransaction().begin();
		order = em.merge(order);
		this.em.remove(order);
		em.getTransaction().commit();
		em.close();
	}

  public Pedido consultarPorId(Long i) {
		return em.find(Pedido.class, i);
	}

}
