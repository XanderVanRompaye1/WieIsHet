package be.kdg.view.WieIsHetView.onderdelenView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class FlowpaneComputer extends FlowPane {
    private ImagePersoon imagePersoon;

    public FlowpaneComputer() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        imagePersoon = new ImagePersoon();
        imagePersoon.maakImageComputerLijst();
    }

    private void layoutNodes() {
        this.getChildren().addAll(imagePersoon.getOnbekenden());
        this.setHgap(5);
        this.setVgap(5);
        this.setAlignment(Pos.CENTER);
        this.setMaxWidth(550);
        this.setMaxHeight(400);
        this.setPadding(new Insets(10));
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(10), new Insets(0))));
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
    }

    public ImagePersoon getImagePersoon() {
        return imagePersoon;
    }
}
