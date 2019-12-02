package Game;

import javax.sound.sampled.*;
import java.io.File;

public class musicpick {

    private static Clip clip;
    private static int i = 0;

    public static void musicStart(String pick, String soundType) {
        try {
            if (i > 0 && soundType == "music" ) {
                clip.stop();
            }
            File yourFile = new File(pick + ".wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(yourFile);
            clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioIn.getFormat()));
            clip.open(audioIn);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-30.0f); //ändrar volym
            clip.start();
            //ljudeffecter fuckar upp denna
            if (soundType == "music" ) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            //clip.loop(Clip.LOOP_CONTINUOUSLY);
            i = 5;

        } catch (Exception e) {
            //whatevers
        }
    }
}