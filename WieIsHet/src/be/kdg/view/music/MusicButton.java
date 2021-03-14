package be.kdg.view.music;

import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class MusicButton extends ToggleButton {
    private ImageView volume;
    private ImageView volumeOff;

    public MusicButton() {
        initialiseNodes();
        layoutNodes();

    }

    public void initialiseNodes() {
        volume = new ImageView("images/volume.png");
        volumeOff = new ImageView("images/volumeOff.png");
    }

    public void layoutNodes() {
        volume.setFitHeight(50);
        volumeOff.setFitHeight(50);
        volume.setPreserveRatio(true);
        volumeOff.setPreserveRatio(true);
    }

    public ImageView getVolume() {
        return volume;
    }

    public ImageView getVolumeOff() {
        return volumeOff;
    }
}
