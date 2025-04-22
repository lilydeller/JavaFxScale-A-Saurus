package model;

import music.Music;
import java.util.ArrayList;

/**
 * the {@code MusicProgram} class manages instruments and plays songs
 * using either predefined patterns or user-created content from the {@link SongList}.
 *  integrates with the JFugue-based {@code Music} player to produce audible output
 */
public class MusicProgram {
    private ArrayList<Instrument> instruments = new ArrayList<>();
    private static Instrument currentInstrument;
    private SongList songList = SongList.getInstance();

    public void addInstrument(Instrument instrument) {
        if (instrument != null) instruments.add(instrument);
    }

    public void setCurrentInstrument(String instrumentName) {
        for (Instrument instrument : instruments) {
            if (instrument.getName().equalsIgnoreCase(instrumentName)) {
                currentInstrument = instrument;
                System.out.println("Current instrument set to: " + instrumentName);
                return;
            }
        }
        System.out.println("Instrument not found.");
    }

    /**
     * plays a song using the selected instrument(defaulted piano) Predefined songs have custom patterns. Otherwise, songs are
     * retrieved from the {@link SongList} and played based on their {@link Measure} and {@link Chord} content.
     *
     * @param songName the name of the song to play
     */
    public static void playSong(String songName) {
        if (currentInstrument == null) {
            System.out.println("No instrument selected, defaulting to Piano.");
            currentInstrument = new Instrument("Piano");
        }
    
        System.out.println("\n🎵 Now Playing: " + songName + " on " + currentInstrument.getName());
    
        
        Song song = SongList.getInstance().getSong(songName);
        if (song == null) {
            System.out.println("Song not found!");
            return;
        }
    
        StringBuilder pattern = new StringBuilder();

        String instrument = song.getInstrument();
                if (instrument != null && !instrument.isEmpty()) {
                pattern.append("I[").append(instrument).append("] ");
            } else {
                pattern.append("I[Piano] ");
            }


    
        for (Measure measure : song.getMeasures()) {
            if (measure.getNotes() != null && !measure.getNotes().isEmpty()) {
                if (measure.getNotes().size() == 1 || !measure.getNotes().get(0).contains("+")) {
             
                    for (String note : measure.getNotes()) {
                        pattern.append(note).append(" ");
                    }
                } else {

                    for (String chord : measure.getNotes()) {
                        pattern.append(chord).append(" ");
                    }
                }
                
            pattern.append("| ");
        }
        Music.playPattern(pattern.toString().trim());
    }
}
    
    public static void main(String[] args) {
        MusicProgram player = new MusicProgram();
        Instrument piano = new Instrument("Piano");
        player.addInstrument(piano);
        player.setCurrentInstrument("Piano");

        SongList.getInstance().loadSongs();
      
        player.playSong("Fine Line (Full Melody)");
        player.playSong("Creep (Melody)");
        player.playSong("Mia & Sebastian's Theme");
        player.playSong("The Scientist (Melody)");

    }
}