package music;

import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;

public class Music {
    private static final Player player = new Player();

    public static void playNote(String note) {
       
        player.play(note + "q"); 
    }

    public static void playPattern(String patternStr) {
        Pattern pattern = new Pattern(patternStr);
        player.play(pattern);
    }
}
