package br.com.gamestorev2.beans;

import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.gamestorev2.entidades.Carrinho;
import br.com.gamestorev2.entidades.Usuario;
import br.com.gamestorev2.entidades.Venda;
import br.com.gamestorev2.repository.CarrinhoRepository;
import br.com.gamestorev2.repository.VendaRepository;

@ManagedBean
public class VendaBean {

	private Venda venda;

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public VendaBean() {

		venda = new Venda();

	}

	public String salvar(Carrinho carrinho) {

		venda.setUsuario(carrinho.getUsuario());
		venda.setCodigo(Math.random());
		venda.setPreco_total(carrinho.getPreco_acumulado());
		venda.setProdutos(carrinho.getProduto());
		Calendar cal = Calendar.getInstance();
		venda.setData(cal.getTime());

		VendaRepository.setVenda(venda);
		setVenda(new Venda());
		System.out.println("Venda gravada com sucesso");
		return "/index.jsf";
	}

	public List<Venda> getVendas() {
		return VendaRepository.getVendas();
	}

	public Venda getVendasByCodigo(double codigo) {
		return VendaRepository.getVendaByCodigo(codigo);
	}
	
	public Carrinho getCart(Usuario user1){
		Carrinho aux = CarrinhoRepository.getCarByUser(user1);
		if(aux==null){
			return null;
		}
			return aux;
	}

}
