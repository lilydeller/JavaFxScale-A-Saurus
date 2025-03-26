package model;

/**
 * The {@code Keys} class represents a musical key or note played in a song,
 * including its pitch and duration (length)
*/
public class Keys {
    private Pitch pitch;
    private int length;

    /**
     * constructs a {@code Keys} object with the specified pitch and length
     *
     * @param pitch  the pitch of the key (note)
     * @param length the length or duration of the key
     */
    public Keys(Pitch pitch, int length) {
        this.pitch = pitch;
        this.length = length;
    }

    public Pitch getPitch() {
        return pitch;
    }

    public int getLength() {
        return length;
    }

    public void setPitch(Pitch pitch) {
        this.pitch = pitch;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getKey() {
        return pitch.toString(); 
    }
}
