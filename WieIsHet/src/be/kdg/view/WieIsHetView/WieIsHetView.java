package be.kdg.view.WieIsHetView;

import be.kdg.model.Speelveld;
import be.kdg.model.WieIsHet;
import be.kdg.view.WieIsHetView.onderdelenView.*;
import be.kdg.view.music.MusicButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class WieIsHetView extends BorderPane {
    private WieIsHet model;

    private VboxLabel vboxLabel;
    private VboxBord vboxBord;
    private VboxOpties vboxOpties;

    public WieIsHetView(WieIsHet model) {
        this.model = model;
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        vboxLabel = new VboxLabel();
        vboxBord = new VboxBord();
        vboxOpties = new VboxOpties(model);
    }

    private void layoutNodes() {
        super.setLeft(vboxLabel);
        super.setCenter(vboxBord);
        super.setRight(vboxOpties);
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(0), new Insets(0))));
    }

    public void updateLabelPersoon(Speelveld speelveld) {

    }

    public VboxOpties getVboxOpties() {
        return vboxOpties;
    }

    public VboxLabel getVboxLabel() {
        return vboxLabel;
    }

    public VboxBord getVboxBord() {
        return vboxBord;
    }
}
