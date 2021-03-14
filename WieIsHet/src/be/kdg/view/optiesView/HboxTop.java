package be.kdg.view.optiesView;

import be.kdg.view.music.MusicButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class HboxTop extends HBox {
    private Label lblSpelOpties;
    private MusicButton btnMuziekAanUit;
    private Button btnToonSpelGegevens;

    public HboxTop() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        lblSpelOpties = new Label("spelopties");
        btnMuziekAanUit = new MusicButton();
        btnToonSpelGegevens = new Button("info");
    }

    private void layoutNodes() {
        btnMuziekAanUit.setGraphic(btnMuziekAanUit.getVolume());
        this.getChildren().addAll(lblSpelOpties, btnMuziekAanUit,btnToonSpelGegevens);
        this.setSpacing(450);
        this.setPadding(new Insets(50));
    }

    public MusicButton getBtnMuziekAanUit() {
        return btnMuziekAanUit;
    }

    public Button getBtnToonSpelGegevens() {
        return btnToonSpelGegevens;
    }
}
