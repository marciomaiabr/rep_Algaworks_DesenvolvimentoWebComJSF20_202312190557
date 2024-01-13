package com.algaworks.cursojsf2.financeiro.repository.infra;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;

public class PessoasJPA implements Pessoas {

	private EntityManager entityManager;

	public PessoasJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> todas() {
		return entityManager.createQuery("from Pessoa order by nome", Pessoa.class).getResultList();
	}

	@Override
	public Pessoa porCodigo(Integer codigo) {
		return (Pessoa) entityManager.find(Pessoa.class, codigo);
	}

}
