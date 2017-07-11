package br.com.gamestorev2.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import br.com.gamestorev2.databasemaneger.DatabaseManager;
import br.com.gamestorev2.entidades.Carrinho;
import br.com.gamestorev2.entidades.Usuario;

public class CarrinhoRepository implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1943119878248778678L;

	public static void setCarrinho(Carrinho carrinho){
		
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(carrinho);
		em.flush();
		em.getTransaction().commit();
		em.close();

	}
	
	public static void getCarrinho(){
		
	}
	
	public static Carrinho getCarByUser(Usuario user){
		if(user!=null){
			EntityManagerFactory emf = DatabaseManager.getEmf();
			EntityManager em = emf.createEntityManager();
			Carrinho car = null;
			try{
				em.getTransaction().begin();
				String sql = "SELECT o FROM Carrinho o Where usuario.id = "+user.getId();
				car = em.createQuery(sql,Carrinho.class).getSingleResult();
				em.getTransaction().commit();
				em.close();
		}catch(NoResultException r){
			
		}
			return car;
		}else return null;
	
	}
	
	public static void update(){
		EntityManagerFactory emf = DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		
		
		
	}
	
}

