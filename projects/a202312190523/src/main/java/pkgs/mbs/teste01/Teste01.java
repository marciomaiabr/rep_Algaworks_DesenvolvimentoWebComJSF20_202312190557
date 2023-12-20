package pkgs.mbs.teste01;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pkgs.models.Produto;

@ManagedBean
@SessionScoped
public class Teste01 {

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

}
