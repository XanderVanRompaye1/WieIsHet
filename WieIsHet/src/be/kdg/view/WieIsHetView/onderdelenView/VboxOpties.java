package be.kdg.view.WieIsHetView.onderdelenView;

import be.kdg.model.WieIsHet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class VboxOpties extends VBox {
    private WieIsHet model;

    private ImagePersoon lblFotoGekozenPersoon;
    private Rectangle clip;
    private ComboBox<String> cboxPersonen;
    private Button btnKiesPersoon;

    private ComboBox<String> cboxVragen;
    private Integer[] vraagNummers;
    private Button btnStelVraag;

    private Label lblOutputJaNee;
    private Label lblOutputComputer;
    private Hboxbuttons hboxbuttons;

    private TextField txtGok;
    private Button btnGok;

    public VboxOpties(WieIsHet model) {
        this.model = model;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        lblFotoGekozenPersoon = new ImagePersoon(new Image("images/favicon.jpg"), "default");
        clip = new Rectangle();
        lblFotoGekozenPersoon.setFitWidth(140);
        lblFotoGekozenPersoon.setFitHeight(180);
        lblFotoGekozenPersoon.maakImagePersoonLijst();
        cboxPersonen = new ComboBox<>();
        ObservableList<String> personen = FXCollections.observableArrayList(lblFotoGekozenPersoon.getFotoNamen());
        cboxPersonen.setItems(personen);
        cboxPersonen.setPromptText("kies uw persoon");
        btnKiesPersoon = new Button("bevestig keuze");

        cboxVragen = new ComboBox<>();
        ObservableList<String> vraag = FXCollections.observableArrayList(model.getBord().getSpeelveldSpeler().getvragen());
        cboxVragen.setItems(vraag);
        cboxVragen.setPromptText("vragenlijst");
        btnStelVraag = new Button("Stel vraag");

        lblOutputJaNee = new Label();
        lblOutputComputer = new Label();
        hboxbuttons = new Hboxbuttons();

        txtGok = new TextField();
        txtGok.setPromptText("plaats hier de verdachte persoon");
        btnGok = new Button("Doe een gok");
    }

    private void layoutNodes() {
        this.setSpacing(20);

        clip.setWidth(this.lblFotoGekozenPersoon.getFitWidth());
        clip.setHeight(this.lblFotoGekozenPersoon.getFitHeight());
        clip.setArcWidth(10);
        clip.setArcHeight(10);
        this.lblFotoGekozenPersoon.setClip(clip);

        lblOutputJaNee.setText("welkom bij 'Wie Is Het?'\nHier komen de antwoorden v/d computer.");
        lblOutputComputer.setText("Hier komen de vragen v/d computer.");

        cboxVragen.setDisable(true);
        btnStelVraag.setDisable(true);

        this.getChildren().addAll(lblFotoGekozenPersoon, cboxPersonen, btnKiesPersoon, cboxVragen, btnStelVraag, lblOutputJaNee, lblOutputComputer, hboxbuttons, txtGok, btnGok);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(50));
    }

    public void setLblFotoGekozenPersoon(ImagePersoon lblFotoGekozenPersoon) {
        this.lblFotoGekozenPersoon.setImage(null);
        this.lblFotoGekozenPersoon.setImage(lblFotoGekozenPersoon.getImage());
        this.lblFotoGekozenPersoon.setPersoonNaam(lblFotoGekozenPersoon.getPersoonNaam());
        this.lblFotoGekozenPersoon.setFitWidth(140);
        this.lblFotoGekozenPersoon.setFitHeight(180);
        clip.setWidth(this.lblFotoGekozenPersoon.getFitWidth());
        clip.setHeight(this.lblFotoGekozenPersoon.getFitHeight());
        clip.setArcWidth(10);
        clip.setArcHeight(10);
        this.lblFotoGekozenPersoon.setClip(clip);
    }

    public String getLblFotoGekozenPersoonNaam() {
        return lblFotoGekozenPersoon.getPersoonNaam();
    }

    public ImagePersoon getLblFotoGekozenPersoon() {
        return lblFotoGekozenPersoon;
    }

    public String getCboxHuidigeVraag() {
        return cboxVragen.getValue();
    }

    public Button getBtnStelVraag() {
        return btnStelVraag;
    }

    public ComboBox<String> getCboxVragen() {
        return cboxVragen;
    }

    public ComboBox<String> getCboxPersonen() {
        return cboxPersonen;
    }

    public Integer[] getVraagNummers() {
        return vraagNummers;
    }

    public Button getBtnKiesPersoon() {
        return btnKiesPersoon;
    }

    public Label getLblOutputJaNee() {
        return lblOutputJaNee;
    }

    public Label getLblOutputComputer() {
        return lblOutputComputer;
    }

    public Hboxbuttons getHboxbuttons() {
        return hboxbuttons;
    }

    public TextField getTxtGok() {
        return txtGok;
    }

    public Button getBtnGok() {
        return btnGok;
    }
}
