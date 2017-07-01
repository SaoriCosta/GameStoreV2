package br.com.gamestorev2.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.gamestorev2.databasemaneger.DatabaseManager;


@WebListener
public class AppListener implements ServletContextListener {

    
	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         DatabaseManager.close();
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
         DatabaseManager.init();
    }
	
}
