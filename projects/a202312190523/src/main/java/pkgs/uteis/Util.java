package pkgs.uteis;

import java.util.ArrayList;
import java.util.List;

import pkgs.models.Item;

public class Util {

	private static List<Item> li = new ArrayList<>();

	static {
		System.out.println("Util.static");
		li.add(new Item(1, "descItem 1..."));
		li.add(new Item(2, "descItem 2..."));
		li.add(new Item(3, "descItem 3..."));
	}

	public static List<Item> listItem() {
		System.out.println("Util.listItem()");
		return li;
	}

	public static Item getItemById(Integer id) {
		Item itemById = null;

		for (Item item : li) {
			if (item.getIdItem().equals(id)) {
				itemById = item;
			}
		}

		return itemById;
	}

}
