package br.com.gamestorev2.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.gamestorev2.entidades.Busca;
import br.com.gamestorev2.entidades.Produto;
import br.com.gamestorev2.repository.SearchRepository;

@ManagedBean(name="buscaBean")
@ApplicationScoped
public class BuscaBean {
	
	private Busca busca;
	
	public BuscaBean(){
		busca = new Busca();
	}
	
	public Busca getBusca() {
		return busca;
	}

	public void setBusca(Busca busca) {
		this.busca = busca;
	}
	
	
	public List<Produto> getSearch(){
		return busca.getProdutos();
	}
	
	public String looking(){
		busca.setProdutos(SearchRepository.getSearchByQuery(busca.getQuery()));
		if(busca.getProdutos() == null){
			return "/index.jsf";
		}
		return "/busca.jsf";
	}
	
	public String lookingcategoria(){
		busca.setProdutos(SearchRepository.getSearchByCategoria(busca.getCategoria()));
		if(busca.getProdutos() == null){
			return "/index.jsf";
		}
		
		return "/busca.jsf";
	}
		
}
