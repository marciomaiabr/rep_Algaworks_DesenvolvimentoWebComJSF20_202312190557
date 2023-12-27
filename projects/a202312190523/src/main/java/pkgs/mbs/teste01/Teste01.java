package pkgs.mbs.teste01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pkgs.models.Cliente;

@ManagedBean
@ViewScoped
public class Teste01 implements Serializable {

	public long getMbTs() {
		return 202312270620L;
	}

	public Teste01() {
		System.out.println("Teste01.Teste01()");
	}

	private List<Cliente> clientes = new ArrayList<>();

	public List<Cliente> getClientes() {
		System.out.println("Teste01.getClientes()");
		return clientes;
	}

	public void consultar() {
		System.out.println("Teste01.consultar()");
		this.getClientes().add(new Cliente(1, "Marcio", "Cuiabá"));
		this.getClientes().add(new Cliente(2, "Ana", "Belo"));
		this.getClientes().add(new Cliente(3, "Carina", "Campo Grande"));
		this.getClientes().add(new Cliente(4, "Driely", "Rio de janeiro"));
		this.getClientes().add(new Cliente(5, "Marcela", "Goiania"));
	}

	public void salvar() {
		System.out.println("Teste01.salvar()");
		this.getClientes().forEach(System.out::println);
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
