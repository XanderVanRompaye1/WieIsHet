package be.kdg.model;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class WieIsHet {
    private Bord bord;

    public WieIsHet() {
    }

    public void startSpel(String spelerNaam) {
        this.bord = new Bord(spelerNaam);
    }

    public Bord getBord() {
        return this.bord;
    }

    public String getWinnaar() {
        if (bord.getSpeelveldComputer().getGokIsJuist().equalsIgnoreCase("ja") || bord.getSpeelveldSpeler().getGokIsJuist().equalsIgnoreCase("nee")) {
            return getComputersnaam();
        } else if (bord.getSpeelveldSpeler().getGokIsJuist().equalsIgnoreCase("ja") || bord.getSpeelveldComputer().getGokIsJuist().equalsIgnoreCase("nee")) {
            return getSpelersnaam();
        } else {
            return "geen";
        }
    }

    public String getSpelersnaam() {
        return this.bord.getSpeelveldSpeler().getSpeler().getNaam();
    }

    public String getComputersnaam() {
        return this.bord.getSpeelveldComputer().getSpeler().getNaam();
    }
}
