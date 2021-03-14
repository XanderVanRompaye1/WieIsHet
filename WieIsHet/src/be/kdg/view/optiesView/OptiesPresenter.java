package be.kdg.view.optiesView;

import be.kdg.model.WieIsHet;
import be.kdg.view.WieIsHetView.WieIsHetPresenter;
import be.kdg.view.WieIsHetView.WieIsHetView;
import be.kdg.view.infoView.InfoPresenter;
import be.kdg.view.infoView.InfoView;
import be.kdg.view.music.Music;
import be.kdg.view.music.MusicButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.WindowEvent;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class OptiesPresenter {
    private Music music = new Music();
    private OptiesView optiesView;
    private WieIsHet model;

    public OptiesPresenter(WieIsHet model, OptiesView optiesView) {
        this.optiesView = optiesView;
        this.model = model;
        this.addEventHandlers();
    }

    private void addEventHandlers() {

        optiesView.getHboxTop().getBtnToonSpelGegevens().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InfoView infoView = new InfoView();
                InfoPresenter infoPresenter = new InfoPresenter(infoView);
                optiesView.getScene().setRoot(infoView);
                infoView.getScene();
            }
        });

        optiesView.getHboxTop().getBtnMuziekAanUit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(optiesView.getHboxTop().getBtnMuziekAanUit().isSelected()) {
                    optiesView.getHboxTop().getBtnMuziekAanUit().setGraphic(optiesView.getHboxTop().getBtnMuziekAanUit().getVolumeOff());
                    music.stopMusic();
                } else {
                    optiesView.getHboxTop().getBtnMuziekAanUit().setGraphic(optiesView.getHboxTop().getBtnMuziekAanUit().getVolume());
                    music.startMusic();
                }
            }
        });

        optiesView.getVboxCenter().getBtnStartSpel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (optiesView.getVboxCenter().getTxtNaam().getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Geen naam ingevuld");
                    alert.setHeaderText("Vul je naam in om door te gaan");
                    alert.showAndWait();
                    return;
                }

                model.startSpel(optiesView.getVboxCenter().getTxtNaam().getText());
                model.getBord().getSpeelveldComputer().kiesRandomPersoon();
                model.getBord().maakGekozenPersoonComputerGelijkOpBeideVelden();

                WieIsHetView wieIsHetView;
                wieIsHetView = new WieIsHetView(model);
                WieIsHetPresenter wieIsHetPresenter = new WieIsHetPresenter(model, wieIsHetView, optiesView);
                optiesView.getScene().setRoot(wieIsHetView);
                wieIsHetView.getScene();
            }
        });
    }

    public void voegWindowEventToe() {
        windowCloseEvent(optiesView.getScene());
    }

    private static void windowCloseEvent(Scene scene) {
        scene.getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Opgelet");
                alert.setHeaderText("Weet je zeker dat je het spel wilt stoppen?");
                alert.getButtonTypes().clear();
                ButtonType ja = new ButtonType("Ja");
                ButtonType nee = new ButtonType("Nee");
                alert.getButtonTypes().addAll(ja, nee);
                alert.showAndWait();
                if (alert.getResult() == null || alert.getResult().equals(nee)) {
                    windowEvent.consume();
                }
            }
        });
    }
}
