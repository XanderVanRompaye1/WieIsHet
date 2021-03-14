package be.kdg.view.WieIsHetView;

import be.kdg.model.WieIsHet;
import be.kdg.view.FileKlasse;
import be.kdg.view.WieIsHetView.onderdelenView.ImagePersoon;
import be.kdg.view.gewonnenView.GewonnenPresenter;
import be.kdg.view.gewonnenView.GewonnenView;
import be.kdg.view.music.Music;
import be.kdg.view.optiesView.OptiesView;
import be.kdg.view.verlorenView.VerlorenPresenter;
import be.kdg.view.verlorenView.VerlorenView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

import java.io.File;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class WieIsHetPresenter {
    private final Music music = new Music();
    private final ImagePersoon imagePersoon = new ImagePersoon();
    private final WieIsHet model;
    private final WieIsHetView wieIsHetView;

    public WieIsHetPresenter(WieIsHet model, WieIsHetView wieIsHetView, OptiesView optiesView) {
        this.model = model;
        wieIsHetView.getVboxLabel().getLblSpeler().setText(this.model.getBord().getSpeelveldSpeler().getSpeler().getNaam());
        this.wieIsHetView = wieIsHetView;
        if (optiesView.getHboxTop().getBtnMuziekAanUit().isSelected()) { // als het volume uitstaat in de optieView, staat hij hier ook uit.
            wieIsHetView.getVboxLabel().getMusicButton().setSelected(true);
            wieIsHetView.getVboxLabel().getMusicButton().setGraphic(wieIsHetView.getVboxLabel().getMusicButton().getVolumeOff());
        }
        this.addEventHandlers();
    }

    private void addEventHandlers() {

        wieIsHetView.getVboxLabel().getMusicButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (wieIsHetView.getVboxLabel().getMusicButton().isSelected()) {
                    wieIsHetView.getVboxLabel().getMusicButton().setGraphic(wieIsHetView.getVboxLabel().getMusicButton().getVolumeOff());
                    music.stopMusic();
                } else {
                    wieIsHetView.getVboxLabel().getMusicButton().setGraphic(wieIsHetView.getVboxLabel().getMusicButton().getVolume());
                    music.startMusic();
                }
            }
        });

        wieIsHetView.getVboxOpties().getCboxPersonen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                wieIsHetView.getVboxOpties().setLblFotoGekozenPersoon(imagePersoon.getPersoonUitLijst(wieIsHetView.getVboxOpties().getCboxPersonen().getValue()));
            }
        });

        wieIsHetView.getVboxOpties().getBtnKiesPersoon().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                wieIsHetView.getVboxOpties().getBtnKiesPersoon().setDisable(true);
                wieIsHetView.getVboxOpties().getCboxPersonen().setDisable(true);
                wieIsHetView.getVboxOpties().getCboxVragen().setDisable(false);
                wieIsHetView.getVboxOpties().getBtnStelVraag().setDisable(false);

                model.getBord().getSpeelveldSpeler().kiesPersoon(wieIsHetView.getVboxOpties().getCboxPersonen().getValue().toLowerCase());
                wieIsHetView.getVboxOpties().getLblOutputJaNee().setText("uw persoon is: " + model.getBord().getSpeelveldSpeler().getGekozenPersoonSpeler());

                model.getBord().maakGekozenPersoonSpelerGelijkOpBeideVelden();
                model.getBord().maakGekozenPersoonComputerGelijkOpBeideVelden();
                wieIsHetView.getVboxOpties().getLblOutputComputer().setText("stel nu een vraag:");
            }
        });

        wieIsHetView.getVboxOpties().getBtnStelVraag().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                wieIsHetView.getVboxOpties().getBtnStelVraag().setDisable(true);
                wieIsHetView.getVboxOpties().getHboxbuttons().getBtnNee().setDisable(false);
                wieIsHetView.getVboxOpties().getHboxbuttons().getBtnJa().setDisable(false);

                int vraagNummer = 0;

                switch (wieIsHetView.getVboxOpties().getCboxHuidigeVraag()) {
                    case "Is het een man?":
                        vraagNummer = 1;
                        break;
                    case "Draagt de persoon een bril?":
                        vraagNummer = 2;
                        break;
                    case "Heeft je persoon blauwe ogen?":
                        vraagNummer = 3;
                        break;
                    case "Heeft je persoon bruine ogen?":
                        vraagNummer = 4;
                        break;
                    case "Heeft je persoon een baard?":
                        vraagNummer = 5;
                        break;
                    case "Heeft je persoon een snor?":
                        vraagNummer = 6;
                        break;
                    case "Is je persoon kaal?":
                        vraagNummer = 7;
                        break;
                    case "Heeft je persoon blond haar?":
                        vraagNummer = 8;
                        break;
                    case "Heeft je persoon zwart haar?":
                        vraagNummer = 9;
                        break;
                    case "Heeft je persoon bruin haar?":
                        vraagNummer = 10;
                        break;
                    case "Heeft je persoon grijs haar?":
                        vraagNummer = 11;
                        break;
                    case "Heeft je persoon iets op zijn hoofd?":
                        vraagNummer = 12;
                        break;
                }

                model.getBord().getSpeelveldComputer().stelVraagAanComputer(vraagNummer);

                wieIsHetView.getVboxOpties().getLblOutputJaNee().setText(model.getBord().getSpeelveldComputer().getAntwoordComputer());

                wieIsHetView.getVboxOpties().getLblOutputComputer().setText("als u iemand wilt verwijderen klikt u op de foto");

                wieIsHetView.getVboxOpties().getLblOutputComputer().setText(model.getBord().getSpeelveldComputer().stelVraagAanSpeler());
            }
        });

        wieIsHetView.getVboxOpties().getHboxbuttons().getBtnJa().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.getBord().getSpeelveldComputer().verwijderPersoonAutomatisch("ja");
                controleerGewonnen();
            }
        });

        wieIsHetView.getVboxOpties().getHboxbuttons().getBtnNee().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.getBord().getSpeelveldComputer().verwijderPersoonAutomatisch("nee");
                controleerGewonnen();
            }
        });

        wieIsHetView.getVboxBord().getFlowpaneSpeler().getImagePersoon().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String naam = wieIsHetView.getVboxBord().getFlowpaneSpeler().getImagePersoon().getPersoonNaam();
                model.getBord().getSpeelveldSpeler().verwijderPersoon(naam);
                wieIsHetView.getVboxBord().getFlowpaneSpeler().setPersonenGegevenNaam(naam);

                System.out.println("clicked");
            }
        }); // er gebeurt nog niets

        wieIsHetView.getVboxOpties().getBtnGok().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (wieIsHetView.getVboxOpties().getTxtGok().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Niets ingevuld");
                    alert.setHeaderText("Geef een gok in!");
                    alert.showAndWait();
                } else {
                    for (String string : model.getBord().getSpeelveldSpeler().getNamen()) {
                        if (string.equalsIgnoreCase(wieIsHetView.getVboxOpties().getTxtGok().getText())) {
                            model.getBord().getSpeelveldSpeler().doeEenGok(wieIsHetView.getVboxOpties().getTxtGok().getCharacters().toString());
                            controleerGewonnen();
                            return;
                        }
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("De naam is incorrect");
                    alert.setHeaderText("Geef een deftige naam in!");
                    alert.showAndWait();
                }
            }
        });
    }

    private void controleerGewonnen() {
        FileKlasse fileKlasse = new FileKlasse();
        if (model.getWinnaar().equalsIgnoreCase(model.getSpelersnaam())) {
            fileKlasse.schrijfScoreWeg(model.getSpelersnaam(),true);
            GewonnenView gewonnenView = new GewonnenView(this.model);
            GewonnenPresenter gewonnenPresenter = new GewonnenPresenter(gewonnenView);
            wieIsHetView.getScene().setRoot(gewonnenView);
            gewonnenView.getScene().getWindow().sizeToScene();
        } else if (model.getWinnaar().equalsIgnoreCase(model.getComputersnaam())) {
            fileKlasse.schrijfScoreWeg(model.getSpelersnaam(), false);
            VerlorenView verlorenView = new VerlorenView(model);
            VerlorenPresenter verlorenPresenter = new VerlorenPresenter(verlorenView);
            wieIsHetView.getScene().setRoot(verlorenView);
            verlorenView.getScene().getWindow().sizeToScene();
        } else {
            wieIsHetView.getVboxOpties().getHboxbuttons().getBtnNee().setDisable(true);
            wieIsHetView.getVboxOpties().getHboxbuttons().getBtnJa().setDisable(true);
            wieIsHetView.getVboxOpties().getBtnStelVraag().setDisable(false);
        }
    }
}
