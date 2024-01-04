package pkgs.uteis;

import java.util.ArrayList;
import java.util.List;

import pkgs.models.Item;
import pkgs.models.SubItem;

public class Util {

	private static List<Item> li = new ArrayList<>();

	static {
		System.out.println("Util.static");

		Item item = null;

		item = new Item(1, "descItem 1...");
		item.setListSubItem(new ArrayList<>());
		item.getListSubItem().add(new SubItem(11, "descSubItem 11..."));
		item.getListSubItem().add(new SubItem(12, "descSubItem 12..."));
		item.getListSubItem().add(new SubItem(13, "descSubItem 13..."));
		li.add(item);
		item = new Item(2, "descItem 2...");
		item.setListSubItem(new ArrayList<>());
		item.getListSubItem().add(new SubItem(21, "descSubItem 21..."));
		item.getListSubItem().add(new SubItem(22, "descSubItem 22..."));
		item.getListSubItem().add(new SubItem(23, "descSubItem 23..."));
		li.add(item);
		item = new Item(3, "descItem 3...");
		item.setListSubItem(new ArrayList<>());
		item.getListSubItem().add(new SubItem(31, "descSubItem 31..."));
		item.getListSubItem().add(new SubItem(32, "descSubItem 32..."));
		item.getListSubItem().add(new SubItem(33, "descSubItem 33..."));
		li.add(item);
	}

	public static List<Item> listItem() {
		System.out.println("Util.listItem()");
		return li;
	}

	public static Item getItemById(Integer id) {
		Item itemById = null;
		
		for(Item item : li) {
			if(item.getIdItem().equals(id)) {
				itemById = item;
			}
		}
		
		return itemById;
	}

}
