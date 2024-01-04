package pkgs.models;

import java.util.Objects;

public class SubItem {

	private Integer idSubItem;
	private String descSubItem;

	public Integer getIdSubItem() {
		return idSubItem;
	}

	public void setIdSubItem(Integer idSubItem) {
		this.idSubItem = idSubItem;
	}

	public String getDescSubItem() {
		return descSubItem;
	}

	public void setDescSubItem(String descSubItem) {
		this.descSubItem = descSubItem;
	}

	public SubItem() {
	}

	public SubItem(Integer idSubItem, String descSubItem) {
		super();
		this.idSubItem = idSubItem;
		this.descSubItem = descSubItem;
	}

	@Override
	public String toString() {
		return "SubItem [idSubItem=" + idSubItem + ", descSubItem=" + descSubItem + "]";
	}

	@Override
	public int hashCode() {
		System.out.println("SubItem.hashCode()");
		return Objects.hash(idSubItem);
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("SubItem.equals()");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubItem other = (SubItem) obj;
		return Objects.equals(idSubItem, other.idSubItem);
	}

}
