package pkgs.models;

import java.io.Serializable;

public class Cliente implements Serializable {

	private Integer codigo;
	private String nome;
	private String cidade;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", cidade=" + cidade + "]";
	}

	public Cliente() {
	}

	public Cliente(Integer codigo, String nome, String cidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
	}

}
