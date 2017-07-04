package br.com.gamestorev2.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.gamestorev2.databasemaneger.DatabaseManager;
import br.com.gamestorev2.entidades.Carrinho;
import br.com.gamestorev2.entidades.Categoria;

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
		em.getTransaction().commit();
		em.close();

	}
	
	public static void getCarrinho(){
		
	}
	
	
}

