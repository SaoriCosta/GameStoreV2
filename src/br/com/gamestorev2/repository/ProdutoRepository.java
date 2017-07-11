package br.com.gamestorev2.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.annotations.LazyCollectionOption;

import br.com.gamestorev2.databasemaneger.DatabaseManager;
import br.com.gamestorev2.entidades.Produto;

public class ProdutoRepository implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1154885610621076551L;

	
	public static List<Produto> getProdutos(){
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		String sql = "SELECT o FROM Produto o";
		List<Produto> produto = em.createQuery(sql,Produto.class).getResultList();
		em.getTransaction().commit();
		em.close();
		
		return produto;
	}
	
	public static void setProduto(Produto produto){
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(produto);
		em.flush();
		em.getTransaction().commit();
		em.close();

	}
	
	public static void setProdutos(List<Produto> produtos){
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(produtos);
		em.flush();
		em.getTransaction().commit();
		em.close();
	
	}
	
	public static Produto getByCodigo(String codigo){
		
		System.out.println("passa");
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		Produto produto = null;
		System.out.println("codigoooooooooooo ::::::::  "+codigo);
		em.getTransaction().begin();
		try{
		
		String sql ="SELECT o FROM Produto o WHERE codigo='"+codigo+"'"; 
		produto = em.createQuery(sql,Produto.class).getSingleResult();
		em.getTransaction().commit();
		
		}catch(NoResultException e){
			
		}
		em.close();
		return produto;
	}

	public static void update(Produto produto) {
		EntityManagerFactory emf = DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(produto);
		em.flush();
		em.getTransaction().commit();
		em.close();

	}
	
	public static void delete(Produto produto){
		EntityManagerFactory emf = DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		String sql = "delete from Produto WHERE id="+produto.getId();
		Query query = em.createNativeQuery(sql);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	
	
	
	
	
	
	
}
