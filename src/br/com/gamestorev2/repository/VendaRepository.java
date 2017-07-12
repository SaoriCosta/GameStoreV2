package br.com.gamestorev2.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.gamestorev2.databasemaneger.DatabaseManager;
import br.com.gamestorev2.entidades.Categoria;
import br.com.gamestorev2.entidades.Venda;

public class VendaRepository implements Serializable{

	public static void setVenda(Venda venda){
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(venda);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	public static Venda getVendaByCodigo(double codigo){
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		
		String sql = "SELECT o FROM Venda o WHERE codigo = "+codigo+"";
		Venda venda = em.createQuery(sql,Venda.class).getSingleResult();
		em.getTransaction().commit();
		em.close();

		return venda;
		
	}
	
	public static List<Venda> getVendas(){
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT o FROM Venda o";
		List<Venda> vendas = em.createQuery(sql,Venda.class).getResultList();
		em.getTransaction().commit();
		em.close();

		return vendas;
		
	}
}
