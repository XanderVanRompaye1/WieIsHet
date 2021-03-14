package be.kdg.view.optiesView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class VboxCenter extends VBox {
    private TextField txtNaam;
    private Button btnStartSpel;

    public VboxCenter() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        txtNaam = new TextField();
        txtNaam.setText("naam");
        txtNaam.setPromptText("geef hier uw naam");
        btnStartSpel = new Button("START");
    }

    private void layoutNodes() {
        this.setSpacing(20);
        this.getChildren().addAll(txtNaam,btnStartSpel );
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(80));
        this.setMaxWidth(300);
    }

    public TextField getTxtNaam() {
        return txtNaam;
    }

    public Button getBtnStartSpel() {
        return btnStartSpel;
    }
}
