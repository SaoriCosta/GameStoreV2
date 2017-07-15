package br.com.gamestorev2.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.gamestorev2.databasemaneger.DatabaseManager;
import br.com.gamestorev2.entidades.Categoria;
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
			em.close();
		}
		em.close();
		return produtos;
	}

	public static List<Produto> getSearchByCategoria(Categoria categoria) {
		EntityManagerFactory emf  =	DatabaseManager.getEmf();
		EntityManager em = emf.createEntityManager();
		List<Produto> produtos = null;
		try{
		em.getTransaction().begin();
		String sql = "SELECT o from Produto o where o.id = "
					+ "(select o.PRODUTO_ID from PRODUTO_CATEGORIA o where o.CATEGORIAS_ID="+categoria.getId()+")";
		Query query = em.createQuery(sql, Produto.class);
		query.executeUpdate();
		ResultSet result = (ResultSet) query.getResultList();
		produtos = new ArrayList<>();
		Produto p = null;
		try {
			while(!result.next()){
				p = new Produto();
				p.setId(result.getInt("ID"));
				p.setCodigo(result.getString("CODIGO"));
				p.setImage(result.getString("IMAGE"));
				p.setNome(result.getString("NOME"));
				p.setPreco(result.getDouble("PRECO"));
				p.setPromocao(result.getBoolean("PROMOCAO"));
				produtos.add(p);
			}
			result.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		em.getTransaction().commit();
		
		}catch(NoResultException r){
			em.close();
		}
		em.close();
		return produtos;
		
	}
	
}
