package domain;

import java.util.Collections;
import java.util.List;

public class ItemManager {
    private List<Item> items;
    private static ItemManager it = new ItemManager();

    public static ItemManager getInstance() {
        return it;
    }
    public boolean addItem(String verzameling, String naam, String soort, int aantal) {
        if (naam != null) {
            Item item = new Item(naam,soort,aantal);
            items.add(item);
        }
        return false;
    }
    public List<Item> getAlleItems() {
        return Collections.unmodifiableList(items);
    }

    public Item getItemByName(String naam) {
        return items.stream().filter(verz -> verz.getNaam().equals(naam)).findFirst().orElse(null);
    }
    public boolean removeItem(String naam) {
        Item item = getItemByName(naam);
        if (item != null) {
            return items.remove(item);
        }
        return false;
    }
}
