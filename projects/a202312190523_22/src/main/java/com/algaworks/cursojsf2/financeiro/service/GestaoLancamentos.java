package com.algaworks.cursojsf2.financeiro.service;

import com.algaworks.cursojsf2.financeiro.exceptions.RegraNegocioException;
import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;

@javax.faces.bean.ManagedBean(name = "glmb")
/*
jan. 17, 2024 4:17:03 AM com.sun.faces.lifecycle.InvokeApplicationPhase execute
WARNING: Não foi possível criar o bean gerenciado cadastroLancamentoBean.  Os seguintes problemas foram encontrados:
     - A propriedade gestaoLancamentosMP para o bean gerenciado cadastroLancamentoBean não existe.
com.sun.faces.mgbean.ManagedBeanCreationException: Não foi possível criar o bean gerenciado cadastroLancamentoBean.  Os seguintes problemas foram encontrados:
     - A propriedade gestaoLancamentosMP para o bean gerenciado cadastroLancamentoBean não existe.
	at com.sun.faces.mgbean.BeanManager.create(BeanManager.java:265)
*/
@javax.faces.bean.ViewScoped
/*
jan. 17, 2024 4:26:43 AM com.sun.faces.mgbean.BeanManager preProcessBean
SEVERE: O JSF estará indisponível para criar o bean gerenciado glmb quando ele for solicitado.  Os seguintes problemas foram encontrados:
     - A classe de bean gerenciado com.algaworks.cursojsf2.financeiro.service.GestaoLancamentos para o bean gerenciado glmb não declara um construtor no-argument público.
     - A classe de bean gerenciado com.algaworks.cursojsf2.financeiro.service.GestaoLancamentos para o bean gerenciado glmb não declara um construtor no-argument público.
jan. 17, 2024 4:26:43 AM com.sun.faces.mgbean.BeanManager preProcessBean
SEVERE: O JSF estará indisponível para criar o bean gerenciado cadastroLancamentoBean quando ele for solicitado.  Os seguintes problemas foram encontrados:
     - O escopo do objeto referido pela expressão #{glmb}, request, é menor do que o escopo do bean gerenciado referido (cadastroLancamentoBean) de view
jan. 17, 2024 4:26:43 AM com.sun.faces.lifecycle.InvokeApplicationPhase execute
WARNING: Não foi possível criar o bean gerenciado cadastroLancamentoBean.  Os seguintes problemas foram encontrados:
     - O escopo do objeto referido pela expressão #{glmb}, request, é menor do que o escopo do bean gerenciado referido (cadastroLancamentoBean) de view
com.sun.faces.mgbean.ManagedBeanCreationException: Não foi possível criar o bean gerenciado cadastroLancamentoBean.  Os seguintes problemas foram encontrados:
     - O escopo do objeto referido pela expressão #{glmb}, request, é menor do que o escopo do bean gerenciado referido (cadastroLancamentoBean) de view
	at com.sun.faces.mgbean.BeanManager.create(BeanManager.java:265)
*/
public class GestaoLancamentos {

	private Lancamentos lancamentos;

/*
jan. 17, 2024 4:31:03 AM com.sun.faces.mgbean.BeanManager preProcessBean
SEVERE: O JSF estará indisponível para criar o bean gerenciado glmb quando ele for solicitado.  Os seguintes problemas foram encontrados:
     - A classe de bean gerenciado com.algaworks.cursojsf2.financeiro.service.GestaoLancamentos para o bean gerenciado glmb não declara um construtor no-argument público.
     - A classe de bean gerenciado com.algaworks.cursojsf2.financeiro.service.GestaoLancamentos para o bean gerenciado glmb não declara um construtor no-argument público.
jan. 17, 2024 4:31:03 AM com.sun.faces.lifecycle.InvokeApplicationPhase execute
WARNING: Não é possível definir a propriedade gestaoLancamentosMP para o bean gerenciado cadastroLancamentoBean.
com.sun.faces.mgbean.ManagedBeanCreationException: Não é possível definir a propriedade gestaoLancamentosMP para o bean gerenciado cadastroLancamentoBean.
	at com.sun.faces.mgbean.ManagedBeanBuilder$BakedBeanProperty.set(ManagedBeanBuilder.java:615)
*/
	public GestaoLancamentos() {
		System.out.println("GestaoLancamentos.GestaoLancamentos()");
	}
	
	public GestaoLancamentos(Lancamentos lancamentos) {
		System.out.println("GestaoLancamentos.GestaoLancamentos(Lancamentos lancamentos)");
		this.lancamentos = lancamentos;
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

	public void teste() {
		System.out.println("GestaoLancamentos.teste()");
	}
	
}