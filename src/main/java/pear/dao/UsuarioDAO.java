package pear.dao;

import java.util.List;

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
		em.close();
	}

	public void atualizar(Usuario user) {
		em.getTransaction().begin();
		this.em.merge(user);
		em.getTransaction().commit();
		em.close();
	}

	public void remover(Usuario user) {
		em.getTransaction().begin();
		user = em.merge(user);
		this.em.remove(user);
		em.getTransaction().commit();
		em.close();
	}

	public Usuario buscaUsuario(String login, String senha) {
		try {
			String jpql = "FROM Usuario WHERE login = :login AND senha = :senha";
			return em.createQuery(jpql, Usuario.class).setParameter("login", login).setParameter("senha", senha).getSingleResult();		
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Usuário não encontrado!");
			return null;
		}
	}
	
	public List<Usuario> buscarTodos() {
		String jpql = "SELECT u FROM Usuario u";
		return em.createQuery(jpql, Usuario.class).getResultList();
	}
	
	public Usuario consultarId(Long id) {
		em.getTransaction().begin();
		String jpql = "SELECT u FROM usuario WHERE id = ?1";
		return em.createQuery(jpql, Usuario.class).setParameter("id", id).getSingleResult();	
	}
}
