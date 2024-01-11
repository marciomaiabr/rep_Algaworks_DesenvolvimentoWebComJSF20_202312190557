package com.algaworks.cursojsf2.financeiro.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {

	public static String getMensagemI18n(String chave) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle resourceBundle  = facesContext.getApplication().getResourceBundle(facesContext, "msg");
		String string = resourceBundle.getString(chave);
		return string;
	}

	public static void adicionarMensagem(Severity tipo, String msg) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(tipo, msg, msg));
	}
	
	public static Object getRequestAttribute(String name) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		return request.getAttribute(name);
	}
	
}
