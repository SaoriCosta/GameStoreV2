package br.com.gamestorev2.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.gamestorev2.entidades.Produto;
//import org.primefaces.showcase.domain.Produto;
import br.com.gamestorev2.repository.ProdutoRepository;

@ManagedBean(name = "produtoService")
@ApplicationScoped
public class ProdutoService {
	     
	    public List<Produto> createProdutos(int size) {
	        List<Produto> list = ProdutoRepository.getProdutos();
	         
	        return list;
	    }
	     
	    
	
}
