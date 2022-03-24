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

	public Endereco buscaCEP(String CEP) {
		try{
			String jpql = "FROM Endereco WHERE CEP = :CEP";
			return em.createQuery(jpql, Endereco.class).setParameter("CEP", CEP).getSingleResult();
		} catch (Exception e) {
			System.err.println("CEP não encontrado!");
			return null;
		}
	}
}
