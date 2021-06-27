package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class VerzamelingManager {
    private List<Verzameling> verzamelingen = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private static VerzamelingManager vz = new VerzamelingManager();

    public static VerzamelingManager getInstance() {
        return vz;
    }
    public boolean addVerzameling(String naamVerzameling) {
        if (naamVerzameling != null) {
            Verzameling verzameling = new Verzameling(naamVerzameling);
            verzamelingen.add(verzameling);
        }
        return false;
    }
    public List<Verzameling> getAlleVerzamelingen() {
        return Collections.unmodifiableList(verzamelingen);
    }

    public Verzameling getNaamVerzameling(String naamVerzameling) {
        return verzamelingen.stream().filter(verz -> verz.getNaamVerzameling().equals(naamVerzameling)).findFirst().orElse(null);
    }
    public boolean addItem(String verzameling, String naam, String soort, int aantal) {
        if (verzameling != null && !verzameling.isBlank()) {
            Optional<Verzameling> gevonden = verzamelingen.stream().filter(c -> c.getNaamVerzameling().equals(verzameling)).findFirst();
            if (!gevonden.isEmpty()) {
                if (naam != null) {
                    Item toAdd = new Item(naam, soort, aantal);
                    if (!items.contains(toAdd)) {
                        items.add(toAdd);
                        gevonden.get().addItem(toAdd);
                    }
                }
            }
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
    public Item updateItem(Item item) {
        return items.set(items.indexOf(VerzamelingManager.getInstance().getItemByName(item.getNaam())),item);
    }
}
