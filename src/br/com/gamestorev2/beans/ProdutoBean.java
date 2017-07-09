package br.com.gamestorev2.beans;

import java.util.List;

import br.com.gamestorev2.entidades.Categoria;
import br.com.gamestorev2.entidades.Produto;
import br.com.gamestorev2.repository.CategoriaRepository;
import br.com.gamestorev2.repository.ProdutoRepository;

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
	
	public String save(){
		if(ProdutoRepository.getByCodigo(getProduto().getCodigo())==null){
			ProdutoRepository.setProduto(produto);
			setProduto(new Produto());
			System.out.println("deu certo");
			return "/admin/produtos.jsf";
		}
		
		return "/admin/index.jsf";
		
	}
	
	public List<Produto> getProdutos(){
		return ProdutoRepository.getProdutos();
	}
	
	

}
