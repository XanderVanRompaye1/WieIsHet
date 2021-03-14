package be.kdg.view.laadView;

import be.kdg.view.laadView.onderdelen.HonderdProcentTransitie;
import be.kdg.view.laadView.onderdelen.VboxLaden;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class Laadview extends BorderPane {
    private HonderdProcentTransitie transitie = new HonderdProcentTransitie(this);
    private VboxLaden vboxLaden;
    private boolean isComplete = false;

    public Laadview() {
        this.initialiseNodes();
        this.layoutNodes();
        this.animate();
    }

    private void initialiseNodes() {
        vboxLaden = new VboxLaden();
    }

    private void layoutNodes() {
        this.setCenter(this.vboxLaden);
        this.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(0), new Insets(0))));
    }

    private void animate() {
        transitie.play();
        isComplete = true;
    }

    public VboxLaden getVboxLaden() {
        return vboxLaden;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
