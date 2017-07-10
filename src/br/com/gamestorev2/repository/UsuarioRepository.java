package br.com.gamestorev2.repository;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import br.com.gamestorev2.databasemaneger.DatabaseManager;
import br.com.gamestorev2.entidades.Usuario;

public class UsuarioRepository implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4228310173712883742L;

	public static List<Usuario> getUsuarios() {
	EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		String sql = "SELECT o FROM Usuario o";
		List<Usuario> users = em.createQuery(sql,Usuario.class).getResultList();
		em.getTransaction().commit();
		em.close();
		
		return users;
	}

	public static void setUsuario(Usuario newUsuario) {
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(newUsuario);
		em.flush();
		em.getTransaction().commit();
		em.close();
		System.out.println("Salvo");
	}
	
	public static Usuario getByLoginSenha(String login, String senha){
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		Usuario user = null;
		try{
		em.getTransaction().begin();
		String sql = "SELECT o FROM Usuario o WHERE email='"+login+"' and senha='"+senha+"'";
		user = em.createQuery(sql,Usuario.class).getSingleResult();
		em.getTransaction().commit();
		em.close();}
		catch(NoResultException e){
			System.out.println("Erro!");
		}
		
		return user;
	}
	
	public static Usuario getByLogin(String login){
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		Usuario user = null;
		try{
		em.getTransaction().begin();
		String sql = "SELECT o FROM Usuario o WHERE email='"+login+"'";
		 user = em.createQuery(sql,Usuario.class).getSingleResult();
		em.getTransaction().commit();
		em.close();
		}catch(NoResultException r){
			System.out.println(r.getMessage());
		}
		return user;
	}

	public static void update(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	

	
	
}
