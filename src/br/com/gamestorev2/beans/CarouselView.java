package br.com.gamestorev2.beans;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.gamestorev2.entidades.Produto;
import br.com.gamestorev2.service.ProdutoService;
 
@ManagedBean
@ViewScoped
public class CarouselView implements Serializable {
     

	private List<Produto> produtos;
     
    private Produto selectedProduto;
     
    @ManagedProperty("br.com.gamestorev2.service.ProdutoService")
    private ProdutoService service1;
   
    @PostConstruct
    public void init() {
        produtos = service1.createCars(0);
    }
  
    
    
    public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public ProdutoService getService() {
		return service1;
	}

	public void setSelectedProduto(Produto selectedProduto) {
		this.selectedProduto = selectedProduto;
	}

	
    public List<Produto> getCars() {
        return produtos;
    }
 
    public void setService(ProdutoService service) {
        this.service1 = service;
    }
 
    public Produto getSelectedProduto() {
        return selectedProduto;
    }
 
    public void setSelectedCar(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }
}