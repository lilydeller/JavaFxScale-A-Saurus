package music;

import org.jfugue.player.Player;

public class Music {
    public static void playNote(String note) {
        try {
            System.out.println(" Debug: Attempting to play note: " + note);
            Player player = new Player();
            player.play(note);
            System.out.println(" Debug: Successfully played note: " + note);
        } catch (Exception e) {
            System.out.println(" Error playing note: " + note);
            e.printStackTrace();
        }
    }
}