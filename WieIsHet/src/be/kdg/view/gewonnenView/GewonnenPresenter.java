package be.kdg.view.gewonnenView;

import be.kdg.model.WieIsHet;
import be.kdg.view.optiesView.OptiesPresenter;
import be.kdg.view.optiesView.OptiesView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class GewonnenPresenter {
    private WieIsHet model = new WieIsHet();
    private GewonnenView gewonnenView;


    public GewonnenPresenter(GewonnenView gewonnenView) {
        this.gewonnenView = gewonnenView;
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        gewonnenView.getBtnOpnieuw().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                OptiesView optiesView = new OptiesView();
                OptiesPresenter optiesPresenter = new OptiesPresenter(model, optiesView);
                gewonnenView.getScene().setRoot(optiesView);
                optiesView.getScene().getWindow().sizeToScene();
            }
        });

        gewonnenView.getBtnSluitAf().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}
