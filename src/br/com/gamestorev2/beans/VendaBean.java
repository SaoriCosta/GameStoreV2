package br.com.gamestorev2.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gamestorev2.entidades.Venda;
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

	public VendaBean(){
		
		venda = new Venda();
		
	}
	
	public String salvar(){
		if(VendaRepository.getVendaByCodigo(venda.getCodigo())== null){
			VendaRepository.setVenda(venda);
			setVenda(new Venda());
			return "/index.jsf";
		}
		
		return "/index.jsf";
	}
	
	public List<Venda> getVendas(){
		return VendaRepository.getVendas();
	}
	
	public Venda getVendasByCodigo(double codigo){
		return VendaRepository.getVendaByCodigo(codigo);
	}
	
	

}
