package com.algaworks.cursojsf2.financeiro.service;

import java.io.Serializable;

import com.algaworks.cursojsf2.financeiro.exceptions.RegraNegocioException;
import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@javax.faces.bean.ManagedBean(name = "gestaoLancamentosMB")
@javax.faces.bean.ViewScoped
public class GestaoLancamentos implements Serializable {

	private Lancamentos lancamentos;

	public GestaoLancamentos() {
		System.out.println("GestaoLancamentos.GestaoLancamentos()");
		this.lancamentos = (new Repositorios()).getLancamentos();
	}
	
	public void salvar(Lancamento lancamento) throws RegraNegocioException {
		if (existeLancamentoSemelhante(lancamento)) {
			throw new RegraNegocioException("existing_entry");
		}
		
		this.lancamentos.guardar(lancamento);
	}
	
	private boolean existeLancamentoSemelhante(Lancamento lancamento) {
		Lancamento lancamentoSemelhante = this.lancamentos.comDadosIguais(lancamento);
		
		return lancamentoSemelhante != null && !lancamentoSemelhante.equals(lancamento);
	}
	
	public void excluir(Lancamento lancamento) throws RegraNegocioException {
		if (lancamento.isPago()) {
			throw new RegraNegocioException("Lançamento pago não pode ser excluído.");
		}
		
		this.lancamentos.remover(lancamento);
	}
	
}