package pkgs.mbs.teste01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

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

	private Produto produtoSelecionado;

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	private String fabricantePesquisa;

	public String getFabricantePesquisa() {
		return fabricantePesquisa;
	}

	public void setFabricantePesquisa(String fabricantePesquisa) {
		this.fabricantePesquisa = fabricantePesquisa;
	}

	public void incluir() {
		System.out.println("Teste01.incluir()");
		produtos.add(this.produto);
		this.produto = new Produto();
	}

	public void excluir() {
		System.out.println("Teste01.excluir()");
		this.produtos.remove(produtoSelecionado);
	}

	public String tentaEncaminhar() {
		if (this.produtos.isEmpty()) {
			return "pagina03?faces-redirect=true";
		} else {
			return "pagina02?faces-redirect=true";
		}
	}

	public void pesquisar() {
		System.out.println("Teste01.pesquisar()");
	}

	public void fabricantePesquisaAlterado(ValueChangeEvent event) {
		System.out.println("Teste01.fabricantePesquisaAlterado()");
	}

	public void verificaInclusao(ActionEvent event) {
		System.out.println("Teste01.verificaInclusao()");
		if ("".equals(produto.getFabricante())) {
			produto.setFabricante("SEM FABRICANTE...");
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
