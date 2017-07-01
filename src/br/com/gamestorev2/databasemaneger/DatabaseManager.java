package br.com.gamestorev2.databasemaneger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManager {
	
	private static EntityManagerFactory emf;
	
	public static void init(){
		
		emf = Persistence.createEntityManagerFactory("gamev2");
		
	}
	public static EntityManagerFactory getEmf(){
		return emf;
	}
	public static void close(){
		emf.close();
	}
}
