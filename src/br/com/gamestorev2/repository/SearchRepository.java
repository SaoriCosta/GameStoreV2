package br.com.gamestorev2.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import br.com.gamestorev2.databasemaneger.DatabaseManager;
import br.com.gamestorev2.entidades.Produto;

public class SearchRepository {
	
	
	public static List<Produto> getSearchByQuery(String query){
		
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		List<Produto> produtos = null;
		try{
		em.getTransaction().begin();
		String sql = "SELECT o FROM Produto o WHERE o.nome LIKE '%"+query+"%'";
		produtos = em.createQuery(sql,Produto.class).getResultList();
		em.getTransaction().commit();
		
		}catch(NoResultException r){
			
		}
		em.close();
		return produtos;
	}
	
}
