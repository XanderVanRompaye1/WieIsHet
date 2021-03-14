package be.kdg.view.WieIsHetView.onderdelenView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class VboxBord extends VBox {
    private FlowpaneSpeler flowpaneSpeler;
    private FlowpaneComputer flowpaneComputer;

    public VboxBord() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        flowpaneSpeler = new FlowpaneSpeler();
        flowpaneComputer = new FlowpaneComputer();
    }

    private void layoutNodes() {
        this.setSpacing(20);
        this.getChildren().addAll(flowpaneComputer, flowpaneSpeler);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(50));
    }

    public FlowpaneSpeler getFlowpaneSpeler() {
        return flowpaneSpeler;
    }

    public FlowpaneComputer getGridPaneComputer() {
        return flowpaneComputer;
    }
}
