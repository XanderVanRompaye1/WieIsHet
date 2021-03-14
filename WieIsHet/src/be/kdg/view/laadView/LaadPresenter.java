package be.kdg.view.laadView;


import be.kdg.model.WieIsHet;
import be.kdg.view.optiesView.OptiesPresenter;
import be.kdg.view.optiesView.OptiesView;
/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class LaadPresenter {
    private WieIsHet model = new WieIsHet();
    private Laadview laadview;

    public LaadPresenter(Laadview laadview) {
        this.laadview = laadview;
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        if (laadview.isComplete()) {
            OptiesView optiesView = new OptiesView();
            OptiesPresenter optiesPresenter = new OptiesPresenter(model, optiesView);
            laadview.getScene().setRoot(optiesView);
            optiesView.getScene().getWindow().sizeToScene();
        }
    }
}
