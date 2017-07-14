package br.com.gamestorev2.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
				String sql = "SELECT o FROM Carrinho o Where usuario_id = "+user.getId();
				car = em.createQuery(sql,Carrinho.class).getSingleResult();
				em.getTransaction().commit();
				em.close();
		}catch(NoResultException r){
			em.close();
		}
			return car;
		}else return null;
	
	}
	
	public static void update(Carrinho carrinho){
		EntityManagerFactory emf = DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(carrinho);
		em.flush();
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Atualizado com sucesso");
		
	}

	public static void remove(Carrinho carrinho) {
		EntityManagerFactory emf = DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		String sql = "delete from CARRINHO_PRODUTO where CARRINHO_ID="+carrinho.getId();
		Query query = em.createNativeQuery(sql);
		query.executeUpdate();
		
		String sql2 = "delete from CARRINHO where USUARIO_ID="+carrinho.getUsuario().getId();
		Query query2 = em.createNativeQuery(sql2);
		query2.executeUpdate();
		
		em.getTransaction().commit();
		em.close();
	}
	
}

