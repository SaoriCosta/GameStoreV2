package br.com.gamestorev2.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gamestorev2.entidades.Produto;
import br.com.gamestorev2.repository.ProdutoRepository;

@ManagedBean(name="produtoBean")
@ViewScoped
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
		System.out.println("eita po");
		if(ProdutoRepository.getByCodigo(getProduto().getCodigo())==null){
			ProdutoRepository.setProduto(produto);
			setProduto(new Produto());
			System.out.println("deu certo");
			return "/admin/produtos.jsf";
		}
		
		System.out.println("Vai atualizar");
		ProdutoRepository.update(getProduto());
		return "/admin/produtos.jsf";
		
	}
	
	public List<Produto> getProdutos(){
		return ProdutoRepository.getProdutos();
	}
	
	public String carregar(Produto produto){
		setProduto(produto);
		return "/admin/produtos.jsf";
	}
	
	public String delete(Produto produto){
		ProdutoRepository.delete(produto);
		System.out.println("deletado");
		return "/admin/produtos.jsf";
	}
	

}
