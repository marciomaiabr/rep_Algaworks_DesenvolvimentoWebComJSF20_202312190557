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

	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void escolher() {
		System.out.println("[this.time="+this.time+"]");
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
