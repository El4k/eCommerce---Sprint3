package pear.dao;

import java.util.List;

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
		em.close();
	}

	public void atualizar(Produto product) {
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
	}

	public void remover(Produto product) {
		em.getTransaction().begin();
		product = em.merge(product);
		this.em.remove(product);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Produto> buscaTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public Produto consultarPorId(Long i) {
		return em.find(Produto.class, i);
	}

	public Long buscaMaxID() {
		String jpql = "SELECT MAX(p.id) FROM Produto p";
		return em.createQuery(jpql, Long.class).getSingleResult();
	}
	
}
