package pkgs.mbs;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ConsultaLancamentoBean implements Serializable {

	public ConsultaLancamentoBean() {
		System.out.println("ConsultaLancamentoBean.ConsultaLancamentoBean()");
	}

	private List<String> lancamentos = new ArrayList<String>();

	public List<String> getLancamentos() {
		return lancamentos;
	}

	@PostConstruct
	public void init() {
		System.out.println("ConsultaLancamentoBean.init()");
		for (int i = 0; i < 20; i++) {
			lancamentos.add("");
		}
	}

	@PreDestroy
	public void finish() {
		System.out.println("ConsultaLancamentoBean.finish()");
	}

}
