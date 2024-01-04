package pkgs.models;

import java.util.List;
import java.util.Objects;

public class Item {

	private Integer idItem;
	private String descItem;
	private List<SubItem> ListSubItem;

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public String getDescItem() {
		return descItem;
	}

	public void setDescItem(String descItem) {
		this.descItem = descItem;
	}

	public List<SubItem> getListSubItem() {
		return ListSubItem;
	}

	public void setListSubItem(List<SubItem> listSubItem) {
		ListSubItem = listSubItem;
	}

	public Item() {
	}

	public Item(Integer idItem, String descItem) {
		super();
		this.idItem = idItem;
		this.descItem = descItem;
	}

	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", descItem=" + descItem + "]";
	}

	@Override
	public int hashCode() {
		System.out.println("Item.hashCode()");
		return Objects.hash(idItem);
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Item.equals()");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(idItem, other.idItem);
	}

}
