package pkgs.mbs.teste01;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;

import pkgs.models.Item;
import pkgs.uteis.Util;

@ManagedBean
//@javax.faces.bean.SessionScoped
//@javax.faces.bean.ViewScoped
@javax.faces.bean.RequestScoped
public class Teste01 {

	public Teste01() {
		System.out.println("Teste01.Teste01()");
	}

	private List<Item> listItem;

	public List<Item> getListItem() {
		System.out.println("Teste01.getListItem()");
		System.out.println("[listItem=" + listItem + "]");
		return listItem;
	}

	public void buscaListItem() {
		System.out.println("Teste01.buscaListItem()");
		listItem = Util.listItem();
	}

	private Integer iIdItem;

	public Integer getiIdItem() {
		System.out.println("Teste01.getiIdItem()");
		System.out.println("[this.iIdItem=" + this.iIdItem + "]");
		return iIdItem;
	}

	public void setiIdItem(Integer iIdItem) {
		System.out.println("Teste01.setiIdItem()");
		System.out.println("[this.iIdItem=" + this.iIdItem + "][iIdItem=" + iIdItem + "]");
		this.iIdItem = iIdItem;
	}

	public String proximo() {
		System.out.println("Teste01.proximo()");
		System.out.println("[this.iIdItem=" + this.iIdItem + "][this.listItem=" + this.listItem + "]");
		return "pagina02";
	}

	public void salvar() {
		System.out.println("Teste01.salvar()");
		System.out.println("[this.iIdItem=" + this.iIdItem + "][this.listItem=" + this.listItem + "]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Teste01.postConstruct()");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Teste01.preDestroy()");
	}
}
