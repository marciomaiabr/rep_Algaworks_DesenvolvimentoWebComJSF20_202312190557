package com.algaworks.cursojsf2.financeiro.repository.infra;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;

public class LancamentosJPA implements Lancamentos {

	private EntityManager entityManager;

	public LancamentosJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> todos() {
		return entityManager.createQuery("from Lancamento order by dataVencimento", Lancamento.class).getResultList();
	}

	@Override
	public Lancamento guardar(Lancamento lancamento) {
		Lancamento lancamentoSalvo = entityManager.merge(lancamento);
		System.out.println("[lancamentoSalvo="+lancamentoSalvo+"]");
		return lancamentoSalvo;
	}

	@Override
	public void remover(Lancamento lancamento) {
		this.entityManager.remove(lancamento);
	}

	@Override
	public Lancamento comDadosIguais(Lancamento lancamento) {
		StringBuilder sql = new StringBuilder();
		sql.append(" from Lancamento ");
		sql.append(" where 1=1 ");
		sql.append(" and tipo = :tipo ");
		sql.append(" and pessoa = :pessoa ");
		sql.append(" and descricao = :descricao ");
		sql.append(" and valor = :valor ");
		sql.append(" and dataVencimento = :dataVencimento ");
		sql.append(" order by dataVencimento ");
		TypedQuery<Lancamento> query = entityManager.createQuery(sql.toString(), Lancamento.class);
		query.setParameter("tipo", lancamento.getTipo());
		query.setParameter("pessoa", lancamento.getPessoa());
		query.setParameter("descricao", lancamento.getDescricao());
		query.setParameter("valor", lancamento.getValor());
		query.setParameter("dataVencimento", lancamento.getDataVencimento());
		return query.getResultStream().findFirst().orElse(null);
	}

}