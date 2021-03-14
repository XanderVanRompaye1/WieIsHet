package be.kdg.view.WieIsHetView.onderdelenView;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class Hboxbuttons extends HBox {
    private Button btnJa;
    private Button btnNee;

    public Hboxbuttons() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        btnJa = new Button("Ja");
        btnNee = new Button("Nee");
    }

    private void layoutNodes() {
        btnJa.setDisable(true);
        btnNee.setDisable(true);

        this.setSpacing(20);
        this.getChildren().addAll(btnJa,btnNee );
        this.setAlignment(Pos.CENTER);
    }

    public Button getBtnJa() {
        return btnJa;
    }

    public Button getBtnNee() {
        return btnNee;
    }
}
