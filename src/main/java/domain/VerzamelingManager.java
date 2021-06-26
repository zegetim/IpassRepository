package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerzamelingManager {
    private List<Verzameling> verzamelingen = new ArrayList<>();
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
}
