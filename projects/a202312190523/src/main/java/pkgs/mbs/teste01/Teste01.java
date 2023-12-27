package pkgs.mbs.teste01;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Teste01 implements Serializable {

	public long getMbTs() {
		return 202312260748L;
	}

	public Teste01() {
		System.out.println("Teste01.Teste01()");
	}

	private String nome;
	private String email;
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void cadastrar() {
		System.out.println("Teste01.cadastrar()");
		if(this.getNome() == null || this.getNome().length() < 10) {
			this.adicionarMensagem("frmPrincipal:nome", FacesMessage.SEVERITY_ERROR, "Nome incompleto", "Favor informar o seu nome completo");
		}if(this.getEmail() == null || this.getEmail().indexOf("@") <= 1) {
			this.adicionarMensagem("frmPrincipal:email", FacesMessage.SEVERITY_ERROR, "E-mail inválido", "Favor informar um email válido");
		}
		if(hojeDiaDescanso()) {
			this.adicionarMensagem(null, FacesMessage.SEVERITY_WARN, "Hoje é dia de descanso", "Você não pode cadastrar usuário hoje");
		}
	}

	private boolean hojeDiaDescanso() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY;
		//return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
	}

	public void adicionarMensagem(String clientId, Severity severity, String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(severity, summary, detail);
		context.addMessage(clientId, message);
	}

	@PostConstruct
	public void init() {
		System.out.println("Teste01.init()");
	}

	@PreDestroy
	public void finish() {
		System.out.println("Teste01.finish()");
	}

}
