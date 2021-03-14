package be.kdg.view.WieIsHetView.onderdelenView;

import be.kdg.view.music.MusicButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class VboxLabel extends VBox {
    private MusicButton musicButton;
    private Label lblSpeler;
    private Label lblComputer;

    public VboxLabel() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        musicButton = new MusicButton();
        lblSpeler = new Label();
        lblComputer = new Label("Computer");
    }

    private void layoutNodes() {
        musicButton.setGraphic(musicButton.getVolume());
        this.setSpacing(200);
        this.getChildren().addAll(musicButton,lblComputer, lblSpeler);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(50));
    }

    public Label getLblSpeler() {
        return lblSpeler;
    }

    public MusicButton getMusicButton() {
        return musicButton;
    }
}
