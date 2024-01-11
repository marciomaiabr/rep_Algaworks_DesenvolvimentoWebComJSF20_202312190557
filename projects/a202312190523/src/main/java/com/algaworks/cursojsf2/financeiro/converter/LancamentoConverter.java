package com.algaworks.cursojsf2.financeiro.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@FacesConverter(forClass = Lancamento.class)
public class LancamentoConverter implements Converter {

	private Repositorios repositorios = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Lancamento retorno = null;
		Lancamentos lancamentos = this.repositorios.getLancamentos();

		if (value != null && !"".equals(value)) {
			retorno = lancamentos.porCodigo(Integer.parseInt(value));
			
			if(retorno == null) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, FacesUtil.getMensagemI18n("system.not_found_record.summary"), FacesUtil.getMensagemI18n("system.not_found_record.detail")));
			}
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Integer codigo = ((Lancamento)value).getCodigo();
			return codigo == null ? "" : codigo.toString();
		}
		return null;
	}

}
