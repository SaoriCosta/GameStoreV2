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
public class DataGridView implements Serializable {
     
    private List<Produto> Produtos;
     
    private Produto selectedProduto;
     
    @ManagedProperty("#{produtoService}")
    private ProdutoService service;
     
    @PostConstruct
    public void init() {
        Produtos = service.createProdutos(48);
    }
 
    public List<Produto> getProdutos() {
        return Produtos;
    }
 
    public void setService(ProdutoService service) {
        this.service = service;
    }
 
    public Produto getSelectedProduto() {
        return selectedProduto;
    }
 
    public void setSelectedProduto(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }
}
