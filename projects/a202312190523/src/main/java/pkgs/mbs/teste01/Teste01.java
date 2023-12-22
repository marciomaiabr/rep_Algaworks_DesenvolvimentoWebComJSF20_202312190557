package pkgs.mbs.teste01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pkgs.models.Produto;

@ManagedBean
@SessionScoped
public class Teste01 implements Serializable {

	public Teste01() {
		System.out.println("Teste01.Teste01()");
		this.produtos = new ArrayList<>();
		this.produto = new Produto();
	}

	private Produto produto;

	public Produto getProduto() {
		return produto;
	}

	private List<Produto> produtos;
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void incluir() {
		produtos.add(this.produto);
		this.produto = new Produto();
	}

	public String tentaEncaminhar() {
		if(this.produtos.isEmpty()) {
			return "pagina03?faces-redirect=true";
		}else {
			return "pagina02?faces-redirect=true";
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