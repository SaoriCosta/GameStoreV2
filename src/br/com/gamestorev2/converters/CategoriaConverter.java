package br.com.gamestorev2.converters;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gamestorev2.entidades.Categoria;
import br.com.gamestorev2.repository.CategoriaRepository;

@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		System.out.println(arg2);
		if(arg2 == null) throw new RuntimeException();
		return CategoriaRepository.getCategoriaById(Integer.parseInt(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Categoria categoria = (Categoria) arg2;
		System.out.println(categoria.getNome());
		return String.valueOf(categoria.getId());
	}

}
