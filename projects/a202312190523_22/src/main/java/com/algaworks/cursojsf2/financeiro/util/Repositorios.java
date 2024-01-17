package com.algaworks.cursojsf2.financeiro.util;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;
import com.algaworks.cursojsf2.financeiro.repository.infra.LancamentosHibernate;
import com.algaworks.cursojsf2.financeiro.repository.infra.LancamentosJPA;
import com.algaworks.cursojsf2.financeiro.repository.infra.PessoasHibernate;
import com.algaworks.cursojsf2.financeiro.repository.infra.PessoasJPA;

public class Repositorios implements Serializable {

	//private Repositorios() {}

	public Pessoas getPessoas() {
		Session session = (Session) FacesUtil.getRequestAttribute("session");
		EntityManager entityManager = (EntityManager) FacesUtil.getRequestAttribute("entityManager");
		if(session != null) {
			return new PessoasHibernate(session);
		}else if(entityManager != null) {
			return new PessoasJPA(entityManager);
		}else {
			throw new RuntimeException("Implementação ORM para a interface Pessoas não encontrada !");
		}
	}

	public Lancamentos getLancamentos() {
		Session session = (Session) FacesUtil.getRequestAttribute("session");
		EntityManager entityManager = (EntityManager) FacesUtil.getRequestAttribute("entityManager");
		if(session != null) {
			return new LancamentosHibernate(session);
		}else if(entityManager != null) {
			return new LancamentosJPA(entityManager);
		}else {
			throw new RuntimeException("Implementação ORM para a interface Lancamentos não encontrada !");
		}
	}

}
