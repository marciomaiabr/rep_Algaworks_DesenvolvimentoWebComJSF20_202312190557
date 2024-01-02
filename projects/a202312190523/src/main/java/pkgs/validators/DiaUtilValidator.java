package pkgs.validators;

import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("mmValidators.DiaUtilValidator")
public class DiaUtilValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		System.out.println("DiaUtilValidator.validate()");
		LocalDate data = (LocalDate) value;
		if (data.getDayOfWeek() == DayOfWeek.TUESDAY || data.getDayOfWeek() == DayOfWeek.SATURDAY) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data não permitida",
					"Informe um dia útil");
			throw new ValidatorException(msg);
		}
	}

}
