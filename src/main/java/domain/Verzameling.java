package domain;

import java.util.ArrayList;
import java.util.List;

public class Verzameling {
    private String naamVerzameling;
    private static ArrayList<String> verzamelingen = new ArrayList<>();
    private List<Item> items;

    public Verzameling(String naamVerzameling) {
        this.naamVerzameling = naamVerzameling;
    }

    public String getNaamVerzameling() {
        return naamVerzameling;
    }

    public void setNaamVerzameling(String naamVerzameling) {
        this.naamVerzameling = naamVerzameling;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
