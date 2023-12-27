package pkgs.mbs.teste01;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Teste01 implements Serializable {

	public long getMbTs() {
		return 202312270503L;
	}

	public Teste01() {
		System.out.println("Teste01.Teste01()");
	}

	@PostConstruct
	public void init() {
		System.out.println("Teste01.init()");
	}

	@PreDestroy
	public void finish() {
		System.out.println("Teste01.finish()");
	}

}
