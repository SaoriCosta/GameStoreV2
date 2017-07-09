package br.com.gamestorev2.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.gamestorev2.databasemaneger.DatabaseManager;
import br.com.gamestorev2.entidades.Produto;
import br.com.gamestorev2.entidades.Usuario;
import br.com.gamestorev2.repository.ProdutoRepository;
import br.com.gamestorev2.repository.UsuarioRepository;


@WebListener
public class AppListener implements ServletContextListener {

    
	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         DatabaseManager.close();
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
         DatabaseManager.init();
         
         String email, senha;
         
         email = "einstein@gmail.com";
         senha = "123";
         
         if(UsuarioRepository.getByLoginSenha(email, senha) == null){
         Usuario admin = new Usuario();
         admin.setNome("Einstein");
         admin.setCpf("12345678");
         admin.setEmail("einstein@gmail.com");
         admin.setSenha("123");
         admin.setAdmin(true);
         UsuarioRepository.setUsuario(admin);;
         	
         
         Produto p1 = new Produto();
	     	p1.setNome("Grand Theft Auto V");
	     	p1.setCodigo("001");
	     	p1.setDescricao("Oh loko");
	     	p1.setPreco(123);
	     	//p1.setCategoria(cat);
	     	p1.setImage("images/gta.jpg");
	     	
	     	ProdutoRepository.setProduto(p1);
	     	
	     	Produto p2 = new Produto();
	     	p2.setNome("Resident Evil 7");
	     	p2.setCodigo("002");
	     	p2.setDescricao("Oh loko");
	     	p2.setPreco(123);
	        // p2.setCategoria(cat1);
	        p2.setImage("images/Resident-Evil-7-Art.jpg");
	        ProdutoRepository.setProduto(p2);
	     	
	     
	     	
	     	Produto p3 = new Produto();
	     	p3.setNome("Horizon Zero Dawn");
	     	p3.setCodigo("003");
	     	p3.setDescricao("Oh loko");
	     	p3.setPreco(123);
	        //p3.setCategoria(cat1);
	     	p3.setImage("images/maxresdefault.jpg");
	         
	         
	     	ProdutoRepository.setProduto(p3);
	     	
	     	
	     	
	     	
	     	Produto p4 = new Produto();
	     	p4.setNome("Silent hill");
	     	p4.setCodigo("004");
	     	p4.setDescricao("Oh loko");
	     	p4.setPreco(123);
	       //  p4.setCategoria(cat2);
	     	p4.setImage("images/silent-hills-5.jpg");
	         
	     	ProdutoRepository.setProduto(p4);
	       	
         
       
         }
         
    }
	
}
