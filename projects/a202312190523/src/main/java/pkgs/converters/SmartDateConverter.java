package pkgs.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("mmConverters.SmartDateConverter")
public class SmartDateConverter implements Converter {

	//private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate getDataHoje() {
		return LocalDate.now();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("SmartDateConverter.getAsObject()");
		LocalDate dataConvertida = null;

		if (value != null || !value.equals("")) {
			if (value.equalsIgnoreCase("hoje")) {
				dataConvertida = getDataHoje();
			} else {
				try {
					dataConvertida = LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
				} catch (Exception e) {
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data incorreta",
							"Informe uma data correta");
					throw new ConverterException(message);
				}
			}
		}

		return dataConvertida;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("SmartDateConverter.getAsString()");
		LocalDate date = (LocalDate) value;
		String s = null;
		if(date.equals(getDataHoje()))
			s = "hoje...";
		else
			s = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(date);
		return s;
	}

}
