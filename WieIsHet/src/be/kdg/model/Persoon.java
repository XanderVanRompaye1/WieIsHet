package be.kdg.model;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class Persoon {
    private StatusPersoon statusPersoon;
    private final String persoonNaam;
    private final boolean isMan;

    private final boolean heeftHoofdDeksel;
    private final boolean isKaal;
    private final boolean draagtBril;
    private final boolean heeftSnor;
    private final boolean heeftBaard;

    private final boolean blondHaar;
    private final boolean bruinHaar;
    private final boolean zwartHaar;
    private final boolean grijsHaar;

    private final boolean blauweOgen;
    private final boolean bruineOgen;

    public Persoon(String persoonNaam, boolean isMan, boolean heeftHoofdDeksel, boolean isKaal, boolean draagtBril, boolean heeftSnor, boolean heeftBaard, boolean blondHaar, boolean bruinHaar, boolean zwartHaar, boolean grijsHaar, boolean blauweOgen, boolean bruineOgen) {
        this.persoonNaam = persoonNaam;
        this.isMan = isMan;
        this.heeftHoofdDeksel = heeftHoofdDeksel;
        this.isKaal = isKaal;
        this.draagtBril = draagtBril;
        this.heeftSnor = heeftSnor;
        this.heeftBaard = heeftBaard;
        this.blondHaar = blondHaar;
        this.bruinHaar = bruinHaar;
        this.zwartHaar = zwartHaar;
        this.grijsHaar = grijsHaar;
        this.blauweOgen = blauweOgen;
        this.bruineOgen = bruineOgen;
        initialiseerStatusPersoon(); //in het begin van het spel doet nog elke persoon mee
    }

    public void initialiseerStatusPersoon() {
        this.statusPersoon = StatusPersoon.DOETNOGMEE;
    }

    public StatusPersoon getStatusPersoon() {
        return statusPersoon;
    }

    public void setStatusPersoon(StatusPersoon statusPersoon) {
        this.statusPersoon = statusPersoon;
    } // als een persoon niet meer voldoet aan de beschrijving kan deze op doetNietMeerMee gezet worden

    public String getPersoonNaam() {
        return persoonNaam;
    }

    public boolean isMan() {
        return isMan;
    }

    public boolean isHeeftHoofdDeksel() {
        return heeftHoofdDeksel;
    }

    public boolean isKaal() {
        return isKaal;
    }

    public boolean isDraagtBril() {
        return draagtBril;
    }

    public boolean isHeeftSnor() {
        return heeftSnor;
    }

    public boolean isHeeftBaard() {
        return heeftBaard;
    }

    public boolean isBlondHaar() {
        return blondHaar;
    }

    public boolean isBruinHaar() {
        return bruinHaar;
    }

    public boolean isZwartHaar() {
        return zwartHaar;
    }

    public boolean isGrijsHaar() {
        return grijsHaar;
    }

    public boolean isBlauweOgen() {
        return blauweOgen;
    }

    public boolean isBruineOgen() {
        return bruineOgen;
    }

}
