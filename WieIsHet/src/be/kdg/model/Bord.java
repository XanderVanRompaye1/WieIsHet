package be.kdg.model;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class Bord {
    private Speelveld speelveldSpeler;
    private Speelveld speelveldComputer;

    Bord(String spelerNaam) {
        speelveldSpeler = new Speelveld(spelerNaam, false);
        speelveldComputer = new Speelveld("computer", true);
    }

    public void maakGekozenPersoonComputerGelijkOpBeideVelden() {
        getSpeelveldSpeler().getSpelMateriaal().setGekozenPersoonComputer(getSpeelveldComputer().getSpelMateriaal().getGekozenPersoonComputer());
    }

    public void maakGekozenPersoonSpelerGelijkOpBeideVelden() {
        getSpeelveldComputer().getSpelMateriaal().setGekozenPersoonSpeler(getSpeelveldSpeler().getSpelMateriaal().getGekozenPersoonSpeler());
    }

    public Speelveld getSpeelveldSpeler() {
        return speelveldSpeler;
    }

    public Speelveld getSpeelveldComputer() {
        return speelveldComputer;
    }
}
