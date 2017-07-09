package br.com.gamestorev2.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import br.com.gamestorev2.databasemaneger.DatabaseManager;
import br.com.gamestorev2.entidades.Categoria;

public class CategoriaRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5397052177720559634L;

	public static void setCategoria(Categoria categoria) {
		EntityManagerFactory emf = DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
		em.close();

	}

	public static List<Categoria> getCategoriasByName(String nomeCategoria) {
		EntityManagerFactory emf = DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		String sql = "SELECT o FROM Categoria o WHERE nome like '%" + nomeCategoria + "%'";
		List<Categoria> categorias = em.createQuery(sql, Categoria.class).getResultList();
		em.getTransaction().commit();
		em.close();

		return categorias;
	}

	public static Categoria getCategoriaByName(String nomeCategoria) {
		EntityManagerFactory emf = DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		Categoria categoria =null;
		try {
		String sql = "SELECT o FROM Categoria o WHERE nome ='" + nomeCategoria + "'";
		em.getTransaction().begin();
			categoria = em.createQuery(sql, Categoria.class).getSingleResult();
			em.getTransaction().commit();
			em.close();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
		
		return categoria;
		
	}
	
	public static List<Categoria> getCategorias(){
		
		EntityManagerFactory emf = DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		String sql = "SELECT o FROM Categoria o";
		
		List<Categoria> categorias = em.createQuery(sql,Categoria.class).getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		
		return categorias;
	}

}
