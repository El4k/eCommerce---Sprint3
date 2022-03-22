package pear.dao;

import javax.persistence.EntityManager;

import pear.model.Endereco;
import pear.util.JPAUtil;

public class EnderecoDAO {

private EntityManager em = JPAUtil.getEntityManager();
	
	public EnderecoDAO() {
		
	}

	public void cadastrar(Endereco address) {
		em.getTransaction().begin();
		this.em.persist(address);
		em.getTransaction().commit();
	}

	public void atualizar(Endereco address) {
		em.getTransaction().begin();
		this.em.merge(address);
		em.getTransaction().commit();
	}

	public void remover(Endereco address) {
		em.getTransaction().begin();
		address = em.merge(address);
		this.em.remove(address);
		em.getTransaction().commit();
	}
}
