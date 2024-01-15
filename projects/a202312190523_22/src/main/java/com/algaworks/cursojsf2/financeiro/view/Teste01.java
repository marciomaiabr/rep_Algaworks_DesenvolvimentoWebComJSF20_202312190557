package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Teste01 implements Serializable {

	public Teste01() {
		System.out.println("Teste01.Teste01()");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Teste01.postConstruct()");
	}

	private String nome;
	private String cor;

	public void exibir() {
		System.out.println("[this.nome="+this.nome+"][this.cor="+this.cor+"]");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
