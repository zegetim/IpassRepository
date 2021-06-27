package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Item {
    String naam;
    String soort;
    int aantal;
    private static ArrayList<String> items = new ArrayList<>();

    public Item(String naam, String soort, int aantal) {
        this.naam = naam;
        this.soort = soort;
        this.aantal = aantal;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

}
