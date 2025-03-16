package model;

public class Keys {
    private String note;
    private int noteLength;

    public Keys(String note, int noteLength) {
        this.note = note;
        this.noteLength = noteLength;
    }

    public String getNote() {
        return note;
    }

    public int getNoteLength() {
        return noteLength;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setNoteLength(int noteLength) {
        this.noteLength = noteLength;
    }
}
