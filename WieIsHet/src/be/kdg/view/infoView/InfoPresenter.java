package be.kdg.view.infoView;

import be.kdg.model.WieIsHet;
import be.kdg.view.optiesView.OptiesPresenter;
import be.kdg.view.optiesView.OptiesView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class InfoPresenter {
    WieIsHet model = new WieIsHet();
    private InfoView infoView;

    public InfoPresenter(InfoView infoView) {
        this.infoView = infoView;
        addEventHandlers();
    }

    private void addEventHandlers() {
        infoView.getBtnTerug().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                    OptiesView optiesView = new OptiesView();
                    OptiesPresenter optiesPresenter = new OptiesPresenter(model, optiesView);
                    infoView.getScene().setRoot(optiesView);
                    optiesView.getScene().getWindow().sizeToScene();
            }
        });
    }
}
