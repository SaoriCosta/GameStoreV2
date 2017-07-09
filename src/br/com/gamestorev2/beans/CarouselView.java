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
     
    /**
	 * 
	 */
	private static final long serialVersionUID = -469752869244401684L;

	private List<Produto> produtos;
     
    private Produto selectedProduto;
     
    @ManagedProperty("br.com.gamestorev2.service.ProdutoService@22396702")
    private ProdutoService service;
   
    @PostConstruct
    public void init() {
        produtos = service.createCars(9);
    }
  
    
    
    public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public ProdutoService getService() {
		return service;
	}

	public void setSelectedProduto(Produto selectedProduto) {
		this.selectedProduto = selectedProduto;
	}

	
    public List<Produto> getCars() {
        return produtos;
    }
 
    public void setService(ProdutoService service) {
        this.service = service;
    }
 
    public Produto getSelectedProduto() {
        return selectedProduto;
    }
 
    public void setSelectedCar(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }
}