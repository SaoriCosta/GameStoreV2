package br.com.gamestorev2.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.gamestorev2.entidades.Carrinho;
import br.com.gamestorev2.entidades.Produto;
import br.com.gamestorev2.entidades.Usuario;
import br.com.gamestorev2.repository.CarrinhoRepository;
import br.com.gamestorev2.repository.ProdutoRepository;

@ManagedBean(name="produtoBean")
@ViewScoped
public class ProdutoBean {
	
	@ManagedProperty("#{loginBean.usuario}")
	private Usuario user;
	private Produto produto;
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

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
	
	public String getPath(){
		return "/produtos.jsf";
	}
	
	public String add(Produto produto){
		if(CarrinhoRepository.getCarByUser(user)==null){
			Carrinho cart = new Carrinho();
			List<Produto> list =  new ArrayList<>();
			list.add(produto);
			cart.setProduto(list);
			cart.setPreco_acumulado(cart.getPreco_acumulado()+produto.getPreco());
			cart.setUsuario(user);
			CarrinhoRepository.setCarrinho(cart);
			System.out.println("Adicionado no carrinho");
			return "/carrinho.jsf";
		}
		
		Carrinho cart = CarrinhoRepository.getCarByUser(user);
		List<Produto> list =  cart.getProduto();
		list.add(produto);
		cart.setPreco_acumulado(cart.getPreco_acumulado()+produto.getPreco());
		cart.setProduto(list);
		CarrinhoRepository.update(cart);
		return "/carrinho.jsf";
		
	}
	

}
