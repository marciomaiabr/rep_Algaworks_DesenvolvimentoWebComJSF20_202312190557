package pkgs.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("mmConverters.SmartDateConverter")
public class SmartDateConverter implements Converter {

	private static final SimpleDateFormat FORMATADOR = new SimpleDateFormat("dd/MM/yyyy");

	private Date getDataHoje() {
		Calendar datHoje = Calendar.getInstance();
		datHoje.set(Calendar.HOUR_OF_DAY, 0);
		datHoje.set(Calendar.MINUTE, 0);
		datHoje.set(Calendar.SECOND, 0);
		datHoje.set(Calendar.MILLISECOND, 0);
		return datHoje.getTime();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("SmartDateConverter.getAsObject()");
		Date dataConvertida = null;

		if (value != null || !value.equals("")) {
			if (value.equalsIgnoreCase("hoje")) {
				dataConvertida = getDataHoje();
			} else {
				try {
					FORMATADOR.setTimeZone(TimeZone.getTimeZone("UTC"));
					dataConvertida = FORMATADOR.parse(value);
				} catch (ParseException e) {
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
		Date date = (Date) value;
		String s = null;
		if(date.equals(getDataHoje()))
			s = "hoje...";
		else
			s = FORMATADOR.format(date);
		return s;
	}

}
