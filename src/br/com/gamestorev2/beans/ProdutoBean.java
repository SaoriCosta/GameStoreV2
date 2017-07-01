package br.com.gamestorev2.beans;

import br.com.gamestorev2.entidades.Produto;

public class ProdutoBean {
	
	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoBean(){
		
		produto = new Produto();
	}
	

}
