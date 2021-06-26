package domain;


import java.util.List;

public class Eigenaar {
    private String voornaam;
    private String achternaam;
    private List<Verzameling> verzamelingen;

    public Eigenaar(String voornaam, String achternaam, List<Verzameling> verzamelingen) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.verzamelingen = verzamelingen;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }
}
