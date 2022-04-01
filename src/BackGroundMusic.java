import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class BackGroundMusic {
    //First background music (?)
    void playMusic() {
        try {
            String musicLocation = "music.wav";
            File musicPath = new File(musicLocation);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

                long clipTimePosition = clip.getMicrosecondPosition();
                clip.stop();

                clip.setMicrosecondPosition(clipTimePosition);
                clip.start();

            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }
}
