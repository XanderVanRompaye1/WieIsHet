package be.kdg.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class Speelveld {
    private final Speler speler;
    private SpelMateriaal spelMateriaal;
    private Random random = new Random();
    private int vraagAanSpeler;
    private String gokIsJuist = "geen";
    private Persoon laatstePersoon;
    private ArrayList<Integer> gesteldeVragenComputer = new ArrayList<>();
    private boolean komtVoorInArray = true;
    private String antwoordComputer;

    public Speelveld(String naam, boolean isComputer) {
        spelMateriaal = new SpelMateriaal();
        speler = new Speler(naam, isComputer);
    }

    //statische geneste klasse
    static class SpelMateriaal {
        private List<Persoon> personen;
        private String[] vragen;
        private Persoon gekozenPersoonSpeler;
        private Persoon gekozenPersoonComputer;

        public SpelMateriaal() {
            maakPersonen();
            maakVragen();
        }

        //maak alle personages aan (15)
        private void maakPersonen() {
            personen = new ArrayList<>();
            personen.add(new Persoon("anne", false, false, false, false, false, false, false, false, true, false, false, true));
            personen.add(new Persoon("bernard", true, true, false, false, false, false, false, true, false, false, false, true));
            personen.add(new Persoon("bill", true, false, true, false, false, true, false, false, false, false, false, true));
            personen.add(new Persoon("charles", true, false, false, false, true, false, true, false, false, false, false, true));
            personen.add(new Persoon("claire", false, true, false, true, false, false, false, false, false, false, false, true));
            personen.add(new Persoon("george", true, true, false, false, false, false, false, false, false, true, false, true));
            personen.add(new Persoon("herman", true, false, true, false, false, false, false, false, false, false, false, true));
            personen.add(new Persoon("joe", true, false, false, true, false, false, true, false, false, false, false, true));
            personen.add(new Persoon("maria", false, true, false, false, false, false, false, true, false, false, false, true));
            personen.add(new Persoon("max", true, false, false, false, true, false, false, false, true, false, false, true));
            personen.add(new Persoon("richard", true, false, true, false, true, true, false, false, false, false, false, true));
            personen.add(new Persoon("robert", true, false, false, false, false, false, false, false, false, false, true, false));
            personen.add(new Persoon("sam", true, false, true, true, false, false, false, false, false, false, false, true));
            personen.add(new Persoon("susan", false, false, false, false, false, false, false, false, false, true, false, true));
            personen.add(new Persoon("tom", true, false, true, true, false, false, false, false, true, false, true, false));
        }

        //maak de vragen aan die de speler en de computer aan elkaar kunnen stellen
        private void maakVragen() {
            vragen = new String[12];
            vragen[0] = "Is het een man?";
            vragen[1] = "Draagt de persoon een bril?";
            vragen[2] = "Heeft je persoon blauwe ogen?";
            vragen[3] = "Heeft je persoon bruine ogen?";
            vragen[4] = "Heeft je persoon een baard?";
            vragen[5] = "Heeft je persoon een snor?";
            vragen[6] = "Is je persoon kaal?";
            vragen[7] = "Heeft je persoon blond haar?";
            vragen[8] = "Heeft je persoon zwart haar?";
            vragen[9] = "Heeft je persoon bruin haar?";
            vragen[10] = "Heeft je persoon grijs haar?";
            vragen[11] = "Heeft je persoon iets op zijn hoofd?";
        }

        //computer
        public void setGekozenPersoonComputer(Persoon gekozenPersoonComputer) {
            this.gekozenPersoonComputer = gekozenPersoonComputer;
        }

        //speler
        public void setGekozenPersoonSpeler(Persoon gekozenPersoonSpeler) {
            this.gekozenPersoonSpeler = gekozenPersoonSpeler;
        }

        //getters
        public Persoon getGekozenPersoonSpeler() {
            return gekozenPersoonSpeler;
        }

        public Persoon getGekozenPersoonComputer() {
            return gekozenPersoonComputer;
        }

        public String[] getVragen() {
            return vragen;
        }

        public String[] getNamen() {
            int teller = 0;
            String[] namen = new String[15];
            for (Persoon persoon : personen) {
                namen[teller] = persoon.getPersoonNaam();
                teller++;
            }
            return namen;
        }
    }

    //methodes computer
    public void kiesRandomPersoon() {
        spelMateriaal.gekozenPersoonComputer = spelMateriaal.personen.get(random.nextInt(spelMateriaal.personen.size()));
    }

    public String stelVraagAanSpeler() {
        int teller = 0;
        do {
            random = new Random();
            vraagAanSpeler = random.nextInt(spelMateriaal.vragen.length);
            if (!gesteldeVragenComputer.contains(vraagAanSpeler)) {
                komtVoorInArray = false;
                break;
            }
            teller++;
        } while (komtVoorInArray && teller <= 11);
        if (teller <= 11) {
            gesteldeVragenComputer.add(vraagAanSpeler);
            return spelMateriaal.vragen[vraagAanSpeler];
        } else {
            throw new WieIsHetException("de computer heeft alle vragen al gesteld, er is iets fout gelopen");
        }

    }

    public void verwijderPersoonAutomatisch(String antwoord) {
        if (antwoord.equalsIgnoreCase("ja")) {
            for (Persoon persoon : spelMateriaal.personen) {
                switch (vraagAanSpeler) {
                    case 0:
                        if (!persoon.isMan()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 1:
                        if (!persoon.isDraagtBril()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 2:
                        if (!persoon.isBlauweOgen()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 3:
                        if (!persoon.isBruineOgen()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 4:
                        if (!persoon.isHeeftBaard()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 5:
                        if (!persoon.isHeeftSnor()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 6:
                        if (!persoon.isKaal()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 7:
                        if (!persoon.isBlondHaar()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 8:
                        if (!persoon.isZwartHaar()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 9:
                        if (!persoon.isBruinHaar()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 10:
                        if (!persoon.isGrijsHaar()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 11:
                        if (!persoon.isHeeftHoofdDeksel()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                }
            }
        } else if (antwoord.equalsIgnoreCase("nee")) {
            for (Persoon persoon : spelMateriaal.personen) {
                switch (vraagAanSpeler) {
                    case 0:
                        if (persoon.isMan()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 1:
                        if (persoon.isDraagtBril()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 2:
                        if (persoon.isBlauweOgen()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 3:
                        if (persoon.isBruineOgen()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 4:
                        if (persoon.isHeeftBaard()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 5:
                        if (persoon.isHeeftSnor()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 6:
                        if (persoon.isKaal()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 7:
                        if (persoon.isBlondHaar()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 8:
                        if (persoon.isZwartHaar()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 9:
                        if (persoon.isBruinHaar()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 10:
                        if (persoon.isGrijsHaar()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    case 11:
                        if (persoon.isHeeftHoofdDeksel()) {
                            persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
                        }
                        break;
                    default:
                        throw new WieIsHetException("geen geldige vraag");
                }
            }
        }
        //checken hoeveel personen er over blijven, als dit nog maar 1 persoon is doet de computer een gok
        int teller = 0;
        for (Persoon persoon : spelMateriaal.personen) {
            if (persoon.getStatusPersoon().equals(StatusPersoon.DOETNOGMEE)) {
                teller++;
                laatstePersoon = persoon;
            }
        }
        if (teller == 1) {
            doeAutomatischEenGok();
        } else if (teller == 0) {
            throw new WieIsHetException("U heeft niet correct geantwoord, want er blijven geen personen meer over");
        }
    }

    public void doeAutomatischEenGok() {
        if (spelMateriaal.gekozenPersoonSpeler.getPersoonNaam().equalsIgnoreCase(laatstePersoon.getPersoonNaam())) {
            gokIsJuist = "ja";
        } else {
            gokIsJuist = "nee";
        }
    }

    //methodes speler
    public void kiesPersoon(String persoonnaam) {
        for (Persoon persoon : spelMateriaal.personen) {
            if (persoon.getPersoonNaam().equalsIgnoreCase(persoonnaam)) {
                spelMateriaal.gekozenPersoonSpeler = persoon;
                return;
            }
        }
        throw new WieIsHetException("De naam van de persoon komt niet overeen met een beschikbaar persoon.");
    }

    public void stelVraagAanComputer(int nummerVraag) {
        boolean isVraagJuist;
        Persoon persoon = spelMateriaal.gekozenPersoonComputer;
        if (nummerVraag >= 1 && nummerVraag <= 12) {
            switch (nummerVraag) {
                case 1:
                    isVraagJuist = persoon.isMan();
                    break;
                case 2:
                    isVraagJuist = persoon.isDraagtBril();
                    break;
                case 3:
                    isVraagJuist = persoon.isBlauweOgen();
                    break;
                case 4:
                    isVraagJuist = persoon.isBruineOgen();
                    break;
                case 5:
                    isVraagJuist = persoon.isHeeftBaard();
                    break;
                case 6:
                    isVraagJuist = persoon.isHeeftSnor();
                    break;
                case 7:
                    isVraagJuist = persoon.isKaal();
                    break;
                case 8:
                    isVraagJuist = persoon.isBlondHaar();
                    break;
                case 9:
                    isVraagJuist = persoon.isZwartHaar();
                    break;
                case 10:
                    isVraagJuist = persoon.isBruinHaar();
                    break;
                case 11:
                    isVraagJuist = persoon.isGrijsHaar();
                    break;
                case 12:
                    isVraagJuist = persoon.isHeeftHoofdDeksel();
                    break;
                default:
                    throw new WieIsHetException("geen geldige vraag, moet een getal tussen 1 en 12 zijn");
            }
            if (isVraagJuist) {
                antwoordComputer = "Het antwoord is ja";
            } else {
                antwoordComputer = "Het antwoord is nee";
            }
        } else {
            throw new WieIsHetException("geen geldige vraag, moet een getal tussen 1 en 12 zijn");
        }
    }

    public void doeEenGok(String gok) {
        if (spelMateriaal.gekozenPersoonComputer.getPersoonNaam().equalsIgnoreCase(gok)) {
            gokIsJuist = "ja";
        } else {
            gokIsJuist = "nee";
        }
    }

    public void verwijderPersoon(String persoonNaam) {
        for (Persoon persoon : spelMateriaal.personen) {
            if (persoon.getPersoonNaam().equalsIgnoreCase(persoonNaam)) {
                persoon.setStatusPersoon(StatusPersoon.DOETNIETMEERMEE);
            }
        }
    }

    //getters
    public SpelMateriaal getSpelMateriaal() {
        return spelMateriaal;
    }

    public Speler getSpeler() {
        return speler;
    }

    public String getAntwoordComputer() {
        return antwoordComputer;
    }

    public String getGekozenPersoonSpeler() {
        return spelMateriaal.gekozenPersoonSpeler.getPersoonNaam();
    }

    public String getGekozenPersoonComputer() {
        return spelMateriaal.gekozenPersoonComputer.getPersoonNaam();
    }

    public String getGokIsJuist() {
        return gokIsJuist;
    }

    public String[] getvragen() {
        return spelMateriaal.getVragen();
    }

    public String[] getNamen() {
        return spelMateriaal.getNamen();
    }
}