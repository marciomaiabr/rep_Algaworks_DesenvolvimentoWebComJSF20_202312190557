package pkgs.uteis;

import java.util.ArrayList;
import java.util.List;

import pkgs.models.Item;

public class Util {

	public static List<Item> listItem() {
		System.out.println("Util.listItem()");
		List<Item> li = new ArrayList<>();
		li.add(new Item(1, "descItem 1..."));
		li.add(new Item(2, "descItem 2..."));
		li.add(new Item(3, "descItem 3..."));
		return li;
	}

}
