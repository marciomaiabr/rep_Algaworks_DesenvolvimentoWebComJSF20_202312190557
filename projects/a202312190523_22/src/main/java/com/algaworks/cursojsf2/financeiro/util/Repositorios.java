package com.algaworks.cursojsf2.financeiro.util;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;
import com.algaworks.cursojsf2.financeiro.repository.infra.LancamentosJPA;
import com.algaworks.cursojsf2.financeiro.repository.infra.PessoasJPA;

public class Repositorios implements Serializable {

	public Pessoas getPessoas() {
		return new PessoasJPA(this.getEntityManager());
	}

	public Lancamentos getLancamentos() {
		return new LancamentosJPA(this.getEntityManager());
	}
	
	private Session getSession() {
		System.out.println("Repositorios.getSession()");
		return (Session) FacesUtil.getRequestAttribute("session");
	}

	private EntityManager getEntityManager() {
		System.out.println("Repositorios.getEntityManager()");
		return (EntityManager) FacesUtil.getRequestAttribute("entityManager");
	}

}
