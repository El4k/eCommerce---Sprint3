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

	public Usuario buscaUsuario(String login, String senha) {
		String jpql = "FROM User WHERE login = :login AND senha = :senha";
		return em.createQuery(jpql, Usuario.class).setParameter("login", login).setParameter("senha", senha).getSingleResult();		
	}
}
