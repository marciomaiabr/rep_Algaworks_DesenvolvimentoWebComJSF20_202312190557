package com.algaworks.cursojsf2.financeiro.view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.Part;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;
import com.algaworks.cursojsf2.financeiro.service.GestaoLancamentos;
import com.algaworks.cursojsf2.financeiro.exceptions.RegraNegocioException;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Repositorios repositorios = new Repositorios();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento = new Lancamento();
	private transient Part arquivoComprovante;

	@ManagedProperty("#{glmb}")
//without #{}
/*
jan. 17, 2024 4:54:10 AM com.sun.faces.lifecycle.ProcessValidationsPhase execute
WARNING: Não é possível definir a propriedade gestaoLancamentosMP para o bean gerenciado cadastroLancamentoBean.
com.sun.faces.mgbean.ManagedBeanCreationException: Não é possível definir a propriedade gestaoLancamentosMP para o bean gerenciado cadastroLancamentoBean.
	at com.sun.faces.mgbean.ManagedBeanBuilder$BakedBeanProperty.set(ManagedBeanBuilder.java:615)
*/
	private GestaoLancamentos gestaoLancamentosMP;

/*
jan. 17, 2024 4:44:06 AM com.sun.faces.mgbean.BeanManager preProcessBean
SEVERE: O JSF estará indisponível para criar o bean gerenciado cadastroLancamentoBean quando ele for solicitado.  Os seguintes problemas foram encontrados:
     - A propriedade gestaoLancamentosMP para o bean gerenciado cadastroLancamentoBean não existe.
jan. 17, 2024 4:44:06 AM com.sun.faces.lifecycle.InvokeApplicationPhase execute
WARNING: Não foi possível criar o bean gerenciado cadastroLancamentoBean.  Os seguintes problemas foram encontrados:
     - A propriedade gestaoLancamentosMP para o bean gerenciado cadastroLancamentoBean não existe.
com.sun.faces.mgbean.ManagedBeanCreationException: Não foi possível criar o bean gerenciado cadastroLancamentoBean.  Os seguintes problemas foram encontrados:
     - A propriedade gestaoLancamentosMP para o bean gerenciado cadastroLancamentoBean não existe.
	at com.sun.faces.mgbean.BeanManager.create(BeanManager.java:265)
*/
	//without getGestaoLancamentosMP()
	public void setGestaoLancamentosMP(GestaoLancamentos gestaoLancamentosMP) {
		this.gestaoLancamentosMP = gestaoLancamentosMP;
	}

	public String init() {
//		if (this.lancamento.isPago()) {
//			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, 
//					"Lançamento pago não pode ser editado");
//			
//			return "ConsultaLancamento";
//		}
		
		Pessoas pessoas = this.repositorios.getPessoas();
		this.pessoas = pessoas.todas();
		
		return null;
	}
	
	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((Boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void uploadComprovante(ActionEvent event) {
		if (arquivoComprovante != null) {
			try (InputStream is = arquivoComprovante.getInputStream();
					ByteArrayOutputStream out = new ByteArrayOutputStream()) {
				
				int read = -1;
                byte[] buffer = new byte[1024];
                
                while ((read = is.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
				
                lancamento.setComprovante(out.toByteArray());
			} catch (IOException e) {
				throw new RuntimeException("Erro ao enviar arquivo.", e);
			}
		}
	}
	
	public void salvar() {
		gestaoLancamentosMP.teste();
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			if(lancamento.getDescricao().toUpperCase().indexOf("ERRO")>=0) {
				throw new RuntimeException("MMRuntimeException...2...");
			}
			gestaoLancamentos.salvar(lancamento);
			
			this.lancamento = new Lancamento();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("entry_saved"));
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, FacesUtil.getMensagemI18n(e.getMessage()));
		}
	}
	
	public boolean isEditando() {
		return this.lancamento.getCodigo() != null;
	}
	
	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}
	
	public void setLancamento(Lancamento lancamento) throws CloneNotSupportedException {
		this.lancamento = lancamento;
		if (this.lancamento == null) {
			this.lancamento = new Lancamento();
		} else {
			this.lancamento = (Lancamento) lancamento.clone();
		}
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public Part getArquivoComprovante() {
		return arquivoComprovante;
	}

	public void setArquivoComprovante(Part arquivoComprovante) {
		this.arquivoComprovante = arquivoComprovante;
	}

}