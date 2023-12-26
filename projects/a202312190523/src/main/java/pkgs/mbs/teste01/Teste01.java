package pkgs.mbs.teste01;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Teste01 implements Serializable {

	public long getMbTs() {
		return 202312260521L;
	}

	public Teste01() {
		System.out.println("Teste01.Teste01()");
	}

	private String[] times;

	public String[] getTimes() {
		return times;
	}

	public void setTimes(String[] times) {
		this.times = times;
	}

	public void escolher() {
		System.out.println("[this.times="+this.times+"]");
		for(String time : this.times) {
			System.out.println("[time="+time+"]");
		}
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
