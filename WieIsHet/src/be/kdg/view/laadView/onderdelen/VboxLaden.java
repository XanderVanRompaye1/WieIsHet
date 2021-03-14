package be.kdg.view.laadView.onderdelen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class VboxLaden extends VBox {
    private Label titel;
    private Label procentDisplay;
    private ProgressBar procentProgress;

    public VboxLaden() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.titel = new Label("Wie is het?");

        this.procentDisplay = new Label("0");
        this.procentProgress = new ProgressBar();
    }

    private void layoutNodes() {
        titel.setFont(new Font(80));
        titel.setPadding(new Insets(200));

        procentDisplay.setFont(new Font(40));
        procentProgress.setMinWidth(700);

        this.getChildren().addAll(titel,procentProgress, procentDisplay);
        this.setAlignment(Pos.CENTER);
    }

    public Label getProcentDisplay() {
        return procentDisplay;
    }

    public ProgressBar getProcentProgress() {
        return procentProgress;
    }
}
