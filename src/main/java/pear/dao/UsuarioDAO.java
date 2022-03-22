package pear.dao;

import javax.persistence.EntityManager;

import pear.model.Usuario;
import pear.util.JPAUtil;

public class UsuarioDAO {

private EntityManager em = JPAUtil.getEntityManager();
	
	public UsuarioDAO() {
		
	}

	public void cadastrar(Usuario user) {
		em.getTransaction().begin();
		this.em.persist(user);
		em.getTransaction().commit();
	}

	public void atualizar(Usuario user) {
		em.getTransaction().begin();
		this.em.merge(user);
		em.getTransaction().commit();
	}

	public void remover(Usuario user) {
		em.getTransaction().begin();
		user = em.merge(user);
		this.em.remove(user);
		em.getTransaction().commit();
	}
	
}
