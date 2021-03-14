package be.kdg.view.optiesView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class OptiesView extends BorderPane {
    private HboxTop hboxTop;
    private VboxCenter vboxCenter;
    private BorderPane borderpane;
    private Image achtergrondfoto;

    public OptiesView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        hboxTop = new HboxTop();
        vboxCenter = new VboxCenter();
        borderpane = new BorderPane();
        achtergrondfoto = new Image("images/achtergrond.jpg");
    }

    private void layoutNodes() {
        setPadding(new Insets(10));
        borderpane.minWidth(800);
        borderpane.setMaxHeight(1000);

        super.setCenter(borderpane);
        borderpane.setTop(hboxTop);
        hboxTop.setAlignment(Pos.CENTER);
        borderpane.setCenter(vboxCenter);
        vboxCenter.setAlignment(Pos.BOTTOM_CENTER);

        borderpane.setBackground(new Background(new BackgroundFill(
                Color.rgb(55, 50, 55, 0.7),
                new CornerRadii(50),
                new Insets(10))));

        this.setBackground(new Background(
                new BackgroundImage(achtergrondfoto,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0.0, false, Side.BOTTOM, 0.0, false),
                        new BackgroundSize(500, 500, false, false, false, true)
                )));
    }

    public HboxTop getHboxTop() {
        return hboxTop;
    }

    public VboxCenter getVboxCenter() {
        return vboxCenter;
    }
}
