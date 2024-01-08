import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.util.JPAUtil;

public class TesteJPA {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// listaPessoa();
		// 
		salvaLancamento();
	}

	public static void listaPessoa() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		List<Pessoa> pessoas = entityManager.createQuery(" from Pessoa ", Pessoa.class)
				//.add(Restrictions.gt("codigo", 3))
				.getResultList();
		
		for (Pessoa p : pessoas) {
			System.out.println(p.getCodigo() + " - " + p.getNome());
		}
		
		entityManager.close();
	}

	public static void salvaLancamento() {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		Pessoa pessoa = entityManager.createQuery(" from Pessoa ", Pessoa.class)
				.getResultStream().findFirst().orElse(null);

		Lancamento lancamento = new Lancamento();

		lancamento.setDataPagamento(Calendar.getInstance().getTime());
		lancamento.setDataVencimento(Calendar.getInstance().getTime());
		lancamento.setDescricao("qaz");
		lancamento.setPago(true);
		lancamento.setPessoa(pessoa);
		lancamento.setTipo(TipoLancamento.RECEITA);
		lancamento.setValor(BigDecimal.valueOf(1.23));

		System.out.println("[lancamento="+lancamento+"]");

		lancamento = entityManager.merge(lancamento);

		System.out.println("[lancamento="+lancamento+"]");

		entityManager.getTransaction().commit();

		entityManager.close();
	}

}
