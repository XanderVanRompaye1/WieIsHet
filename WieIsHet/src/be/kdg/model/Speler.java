package be.kdg.model;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class Speler {
    private String naam;
    private boolean isComputer;

    public Speler(String naam, boolean isComputer) {
        this.naam = naam;
        this.isComputer = isComputer;
    }

    public String getNaam() {
        return naam;
    }
}
