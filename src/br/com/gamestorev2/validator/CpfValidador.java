package br.com.gamestorev2.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cpfValidador")
public class CpfValidador implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {

		String aux = (String) arg2;

		String regex = "^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$";
		if (!aux.matches(regex)) {
			
			FacesMessage msg = new FacesMessage("Formato de CPF invalido.", "Formato de "
					+ "cpf inválido.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

}
