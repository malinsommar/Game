package Game;

import Armor.HealerStartArmor;
import Weapons.HealerStartWeapon;

import javax.sound.sampled.*;
import java.io.File;
import java.util.ArrayList;

public class musicpick {

    private static Clip clip;
    private static int i = 0;

    public static void musicStart(String pick) {
        try {
            if (i > 0) {
                clip.stop();
            }
            File yourFile = new File(pick + ".wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(yourFile);
            clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioIn.getFormat()));
            clip.open(audioIn);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-30.0f); //ändrar volym
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            i = 5;

        } catch (Exception e) {
            //whatevers
        }
    }
}