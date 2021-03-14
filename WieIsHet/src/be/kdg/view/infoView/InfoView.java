package be.kdg.view.infoView;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class InfoView extends VBox {
    private Label lblinformatie;
    private Button btnTerug;
    private Image achtergrondfoto;

    public InfoView() {
        initializeNodes();
        layoutNodes();
    }

    public Button getBtnTerug() {
        return btnTerug;
    }

    private void initializeNodes() {
        lblinformatie = new Label("\t    Wie Is Het\n\n" +
                "Project: KDG hogeschool\n" +
                "Credits: Xander Van Rompaye\n" +
                "Datum: 01 Maart 2021\n" +
                "Leeftijdscategorie: 6-99j");

        btnTerug = new Button("terug naar beginscherm");
        achtergrondfoto = new Image("images/infoachtergrond.png");
    }

    private void layoutNodes() {
        setPadding(new Insets(20));

        lblinformatie.setPadding(new Insets(50));
        lblinformatie.setFont(new Font("Arial", 28));

        btnTerug.setFont(new Font("Arial", 28));

        this.getChildren().addAll(lblinformatie, btnTerug);
        this.setAlignment(Pos.CENTER);

        this.setBackground(new Background(
                new BackgroundImage(achtergrondfoto,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0.0, false, Side.BOTTOM, 0.0, false),
                        new BackgroundSize(500, 500, false, false, false, true)
                )));
    }
}
