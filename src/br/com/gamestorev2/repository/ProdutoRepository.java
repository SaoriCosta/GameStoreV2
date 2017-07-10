package br.com.gamestorev2.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import org.hibernate.Session;

import br.com.gamestorev2.databasemaneger.DatabaseManager;
import br.com.gamestorev2.entidades.Produto;
import br.com.gamestorev2.entidades.Usuario;

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
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		Produto produto = null;
		System.out.println("codigoooooooooooo ::::::::  "+codigo);
		try{
		em.getTransaction().begin();
		String sql ="SELECT o FROM Produto o WHERE codigo='"+codigo+"'"; 
		produto = em.createQuery(sql,Produto.class).getSingleResult();
		em.getTransaction().commit();
		em.close();
		}catch(NoResultException e){
			
		}
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
	
	
	
	
	
	
	
}
