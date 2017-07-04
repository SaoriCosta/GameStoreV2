package br.com.gamestorev2.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.gamestorev2.databasemaneger.DatabaseManager;
import br.com.gamestorev2.entidades.Administrador;
import br.com.gamestorev2.entidades.Categoria;
import br.com.gamestorev2.entidades.Venda;

public class AdministradorRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2968912098896560081L;
	public static void setAdministrador(Administrador administrador){
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(administrador);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Administrador getAdminByLoginSenha(String email, String senha){
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		
		String sql = "SELECT o FROM Administrador o WHERE email ='"+email+"'and senha ='"+senha+"'";
		Administrador admin = em.createQuery(sql,Administrador.class).getSingleResult();
		em.getTransaction().commit();
		em.close();

		return admin;
	}
	
	
}


