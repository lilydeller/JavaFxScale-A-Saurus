package model;

public class Keys {
    private Pitch pitch;
    private int length;

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

    // Added getKey() method to fix the error in Piano class
    public String getKey() {
        return pitch.toString(); // Assuming Pitch has a meaningful toString() method
    }
}
