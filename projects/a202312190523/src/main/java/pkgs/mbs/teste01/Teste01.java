package pkgs.mbs.teste01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pkgs.models.ItemEstoque;

@ManagedBean
@ViewScoped
public class Teste01 implements Serializable {

	public Teste01() {
		System.out.println("Teste01.Teste01()");
	}

	public long getvMb() {
		return 202312280629L;
	}

	private ItemEstoque itemEstoque;

	public ItemEstoque getItemEstoque() {
		return itemEstoque;
	}

	public void setItemEstoque(ItemEstoque itemEstoque) {
		this.itemEstoque = itemEstoque;
	}

	private List<ItemEstoque> listaItemEstoque;

	public List<ItemEstoque> getListaItemEstoque() {
		return listaItemEstoque;
	}

	public void incluir() {
		System.out.println("Teste01.incluir()");
		getListaItemEstoque().add(getItemEstoque());
		setItemEstoque(new ItemEstoque());
	}

	@PostConstruct
	public void init() {
		System.out.println("Teste01.init()");
		this.itemEstoque = new ItemEstoque();
		this.listaItemEstoque = new ArrayList<>();
	}

	@PreDestroy
	public void finish() {
		System.out.println("Teste01.finish()");
	}

}
