package model;

public class Keys {
    private Pitch key;
    private int keyLength; 

    public Keys(String note, int noteLength) {
        this.key = Pitch.valueOf(note.toUpperCase()); // convert note string to enum
        this.keyLength = noteLength;
    }
    
    public Pitch getKey() {
        return key;
    }

    public int getKeyLength() {
        return keyLength;
    }

    public void setKey(Pitch pitch) {
        this.key = pitch;
    }

    public void setKeyLength(int length) {
        this.keyLength = length;
    }
}
