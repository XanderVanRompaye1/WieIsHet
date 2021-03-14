package be.kdg.view.WieIsHetView.onderdelenView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class ImagePersoon extends ImageView {
    private String persoonNaam;
    private Rectangle clip;
    private ImagePersoon[] personen = new ImagePersoon[15];
    private ImagePersoon[] onbekenden = new ImagePersoon[15];
    private String[] fotoNamen = new String[]{"Anne", "Bernard", "Bill", "Charles", "Claire", "George", "Herman", "Joe", "Maria", "Max", "Richard", "Robert", "Sam", "Susan", "Tom"};

    public ImagePersoon(Image image, String persoonNaam) {
        super(image);
        this.persoonNaam = persoonNaam;
    }

    public ImagePersoon() {
        maakImagePersoonLijst();
    }

    public void setPersoonNaam(String persoonNaam) {
        this.persoonNaam = persoonNaam;
    }

    public void maakImagePersoonLijst() {
        for (int i = 0; i < personen.length; i++) {
            ImagePersoon imagePersoon = new ImagePersoon(new Image("images/" + fotoNamen[i] + ".jpg"), fotoNamen[i]);
            imagePersoon.setFitHeight(110);
            imagePersoon.setFitWidth(90);
            //afbeelding ronder maken
            clip = new Rectangle(imagePersoon.getFitWidth(), imagePersoon.getFitHeight());
            clip.setArcWidth(10);
            clip.setArcHeight(10);
            imagePersoon.setClip(clip);

            personen[i] = imagePersoon;
        }
    }

    public void maakImageComputerLijst() {
        for (int i = 0; i < onbekenden.length; i++) {
            ImagePersoon imagePersoon = new ImagePersoon(new Image("images/favicon.jpg"), "default" + i);
            imagePersoon.setFitHeight(90);
            imagePersoon.setFitWidth(90);
            //afbeelding ronder maken
            clip = new Rectangle(imagePersoon.getFitWidth(), imagePersoon.getFitHeight());
            clip.setArcWidth(10);
            clip.setArcHeight(10);
            imagePersoon.setClip(clip);

            onbekenden[i] = imagePersoon;
        }
    }

    public ImagePersoon getPersoonUitLijst(String persoonNaam) {
        for (ImagePersoon imagePersoon : personen) {
            if (imagePersoon.persoonNaam.equalsIgnoreCase(persoonNaam)) {
                return imagePersoon;
            }
        }
        return null;
    }

    public ImagePersoon getPersoonUitLijstMetNummer(int nummer) {
        return personen[nummer];
    }

    public ImagePersoon getpersoonUitLijstComputerMetNummer(int nummer) {
        return onbekenden[nummer];
    }

    public ImagePersoon[] getOnbekenden() {
        return onbekenden;
    }

    public ImagePersoon[] getPersonen() {
        return personen;
    }

    public String getPersoonNaam() {
        return persoonNaam;
    }

    public String[] getFotoNamen() {
        return fotoNamen;
    }
}
