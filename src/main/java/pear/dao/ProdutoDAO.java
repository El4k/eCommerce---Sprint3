package pear.dao;

import javax.persistence.EntityManager;

import pear.model.Produto;
import pear.util.JPAUtil;

public class ProdutoDAO {

	private EntityManager em = JPAUtil.getEntityManager();

	
	public ProdutoDAO() {
		
	}

	public void cadastrar(Produto product) {
		em.getTransaction().begin();
		this.em.persist(product);
		em.getTransaction().commit();
	}

	public void atualizar(Produto product) {
		em.getTransaction().begin();
		this.em.merge(product);
		em.getTransaction().commit();
	}

	public void remover(Produto product) {
		em.getTransaction().begin();
		product = em.merge(product);
		this.em.remove(product);
		em.getTransaction().commit();
	}
}
