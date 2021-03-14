package be.kdg.view.verlorenView;

import be.kdg.model.WieIsHet;
import be.kdg.view.optiesView.OptiesPresenter;
import be.kdg.view.optiesView.OptiesView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class VerlorenPresenter {
    private WieIsHet model = new WieIsHet();
    VerlorenView verlorenView;


    public VerlorenPresenter(VerlorenView verlorenView) {
        this.verlorenView = verlorenView;
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        verlorenView.getBtnOpnieuw().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                OptiesView optiesView = new OptiesView();
                OptiesPresenter optiesPresenter = new OptiesPresenter(model, optiesView);
                verlorenView.getScene().setRoot(optiesView);
                optiesView.getScene().getWindow().sizeToScene();
            }
        });

        verlorenView.getBtnSluitAf().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}
