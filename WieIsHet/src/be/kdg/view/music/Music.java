package be.kdg.view.music;

import javafx.scene.media.AudioClip;
/*
 * Xander Van Rompaye
 * 2020-2021
 */
public class Music {
    private final AudioClip musicfile = new AudioClip(this.getClass().getResource("/music/home.mp3").toString());

    public void startMusic() {
        musicfile.play();
    }

    public void stopMusic() {
        musicfile.stop();
    }
}
