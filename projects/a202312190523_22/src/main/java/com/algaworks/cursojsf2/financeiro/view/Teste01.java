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
		System.out.println("Teste01.postConstruct()[this.descricao="+this.descricao+"]");
	}

	private String descricao;

	public String getDescricao() {
		System.out.println("Teste01.getDescricao()[this.descricao="+this.descricao+"]");
		return descricao;
	}

	public void setDescricao(String descricao) {
		System.out.println("Teste01.setDescricao()[descricao="+descricao+"][this.descricao="+this.descricao+"]");
		this.descricao = descricao;
	}

}
