package be.kdg.view.gewonnenView;

import be.kdg.model.WieIsHet;
import be.kdg.view.WieIsHetView.onderdelenView.ImagePersoon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class GewonnenView extends BorderPane {
    private WieIsHet model;
    private ImagePersoon imagePersoon;
    private Rectangle clip;
    private Label lblGewonnen;
    private Button btnOpnieuw;
    private Button btnSluitAf;

    public GewonnenView(WieIsHet model) {
        this.model = model;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.imagePersoon = new ImagePersoon();
        this.imagePersoon = imagePersoon.getPersoonUitLijst(model.getBord().getSpeelveldSpeler().getGekozenPersoonComputer());
        imagePersoon.setFitHeight(300);
        imagePersoon.setFitWidth(250);
        clip = new Rectangle(imagePersoon.getFitWidth(), imagePersoon.getFitHeight());
        clip.setArcWidth(10);
        clip.setArcHeight(10);
        imagePersoon.setClip(clip);

        this.lblGewonnen = new Label("PROFICIAT " + model.getWinnaar() + "!\nU heeft gewonnen.");
        this.btnOpnieuw = new Button("opnieuw");
        this.btnSluitAf = new Button("sluit af");
    }

    private void layoutNodes() {
        this.setTop(imagePersoon);
        BorderPane.setMargin(imagePersoon, new Insets(50));
        BorderPane.setAlignment(this.imagePersoon, Pos.CENTER);

        this.setCenter(lblGewonnen);
        BorderPane.setAlignment(this.lblGewonnen, Pos.TOP_CENTER);

        this.setLeft(btnOpnieuw);
        BorderPane.setMargin(btnOpnieuw, new Insets(50));
        BorderPane.setAlignment(btnOpnieuw, Pos.BOTTOM_RIGHT);

        this.setRight(btnSluitAf);
        BorderPane.setMargin(btnSluitAf, new Insets(50));
        BorderPane.setAlignment(btnSluitAf, Pos.BOTTOM_LEFT);

        this.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(0), new Insets(0))));
    }

    public Button getBtnOpnieuw() {
        return btnOpnieuw;
    }

    public Button getBtnSluitAf() {
        return btnSluitAf;
    }
}
