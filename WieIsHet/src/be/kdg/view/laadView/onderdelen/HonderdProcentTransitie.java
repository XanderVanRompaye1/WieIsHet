package be.kdg.view.laadView.onderdelen;

import be.kdg.view.laadView.Laadview;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.util.Duration;
/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class HonderdProcentTransitie  extends Transition {
    private final Laadview laadview;


    public HonderdProcentTransitie(Laadview laadview) {
        this.laadview = laadview;
        this.setCycleDuration(Duration.seconds(5));
        this.setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double v) {
        this.laadview.getVboxLaden().getProcentDisplay().setText(String.format("%.0f", v * 100) + "%");
        this.laadview.getVboxLaden().getProcentProgress().setProgress(v);
    }
}
