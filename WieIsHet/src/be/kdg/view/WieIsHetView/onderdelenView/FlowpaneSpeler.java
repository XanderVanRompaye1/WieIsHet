package be.kdg.view.WieIsHetView.onderdelenView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class FlowpaneSpeler extends FlowPane {
    private ImagePersoon imagePersoon;

    public FlowpaneSpeler() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        imagePersoon = new ImagePersoon();
        this.getChildren().addAll(imagePersoon.getPersonen());
    }

    private void layoutNodes() {
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

    public void setPersonenGegevenNaam(String naam) {
        for (int i = 0; i < imagePersoon.getPersonen().length; i++) {
            if (imagePersoon.getPersonen()[i].getPersoonNaam().equals(naam)) {
                imagePersoon.getPersonen()[i].setImage(null);
                imagePersoon.getPersonen()[i].setImage(new Image("images/favicon.jpg"));
            }
        }
    }

    public void setImagePersoon (ImagePersoon imagePersoon){
            this.imagePersoon = imagePersoon;
    }

    public ImagePersoon getImagePersoon () {
        return imagePersoon;
    }
}
