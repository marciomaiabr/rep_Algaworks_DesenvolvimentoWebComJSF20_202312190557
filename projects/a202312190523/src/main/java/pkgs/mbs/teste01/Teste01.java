package pkgs.mbs.teste01;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Teste01 {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void enviar() {
		setNome(this.nome.toUpperCase());
	}

}
