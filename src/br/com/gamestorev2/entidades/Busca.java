package br.com.gamestorev2.entidades;

import java.util.List;

public class Busca {
	
	private String query;
	private List<Produto> produtos;
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
}
