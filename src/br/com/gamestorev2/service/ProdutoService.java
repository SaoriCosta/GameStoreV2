package br.com.gamestorev2.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gamestorev2.entidades.Produto;
import br.com.gamestorev2.repository.ProdutoRepository;

@ManagedBean(name = "produtoService")
@ApplicationScoped
public class ProdutoService {
    
   public ProdutoService() {
	
   }
	
   public List<Produto> createCars(int size) {
       List<Produto> list = ProdutoRepository.getProdutos();
       return list;
   }
  
}