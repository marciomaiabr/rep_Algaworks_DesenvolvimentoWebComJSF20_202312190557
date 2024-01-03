package pkgs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pkgs.models.Item;
import pkgs.uteis.Util;

@FacesConverter("mm.ItemConverter")
public class ItemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("ItemConverter.getAsObject()[value="+value+"]");
		Integer idItem = Integer.valueOf(value);
		Item item = Util.getItemById(idItem);
		return item;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("ItemConverter.getAsString()[value="+value+"]");
		return ((Item) value).getIdItem().toString();
	}

}
