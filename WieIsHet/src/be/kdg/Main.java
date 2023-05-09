package be.kdg;

import model.WieIsHet;
import view.music.Music;
import view.optiesView.OptiesPresenter;
import view.optiesView.OptiesView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 * Xander Van Rompaye
 * 2020-2021
 */

// to  do: timer maken, spelers kunnen wegklikken, laadscherm invoegen.-------------------------------------------------
// fileklasse Paths.get werkt niet

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Music music = new Music();
        WieIsHet model = new WieIsHet();
        OptiesView optiesView = new OptiesView();
        OptiesPresenter optiesPresenter = new OptiesPresenter(model, optiesView);
        Scene scene = new Scene(optiesView, 1400, 800);

        scene.getStylesheets().add("stylesheets/stijl.css");
        Image favicon = new Image("images/favicon.jpg");
        stage.getIcons().addAll(favicon);

        stage.setTitle("Wie is het?");
        stage.setMinWidth(1400);
        stage.setMinHeight(800);
        stage.setScene(scene);
        optiesPresenter.voegWindowEventToe();
        //music.startMusic(); //achtergrond muziekje
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
