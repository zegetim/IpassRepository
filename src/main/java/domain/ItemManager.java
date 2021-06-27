package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ItemManager {
    private List<Item> items = new ArrayList<>();
    private List<Verzameling> verzamelingen = new ArrayList<>();
    private static ItemManager it = new ItemManager();

    public static ItemManager getInstance() {
        return it;
    }
//    public boolean addItem(String verzameling, String naam, String soort, int aantal) {
//        if (naam != null) {
//            Item item = new Item(naam,soort,aantal);
//            items.add(item);
//        }
//        return false;
//    }
//public boolean addItem(String verzameling, String naam, String soort, int aantal) {
//    if (verzameling != null && !verzameling.isBlank()) {
//        Optional<Verzameling> gevonden = verzamelingen.stream().filter(c -> c.getNaamVerzameling().equals(verzameling)).findFirst();
//        if (!gevonden.isEmpty()) {
//            if (naam != null) {
//                Item toAdd = new Item(naam, soort, aantal);
//                if (!items.contains(toAdd)) {
//                    items.add(toAdd);
//                    gevonden.get().addItem(toAdd);
//                }
//            }
//        }
//    }
//    return false;
//}
//    public List<Item> getAlleItems() {
//        return Collections.unmodifiableList(items);
//    }
//
//    public Item getItemByName(String naam) {
//        return items.stream().filter(verz -> verz.getNaam().equals(naam)).findFirst().orElse(null);
//    }
//    public boolean removeItem(String naam) {
//        Item item = getItemByName(naam);
//        if (item != null) {
//            return items.remove(item);
//        }
//        return false;
//    }
//    public Item updateItem(Item item) {
//        return items.set(items.indexOf(ItemManager.getInstance().getItemByName(item.getNaam())),item);
//    }
}
