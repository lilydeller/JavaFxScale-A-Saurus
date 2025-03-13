package model;

public abstract class DataConstants {

    //user constants 
    protected static final String USER_FILE_NAME = "json\\userlist.json";
	protected static final String USER_ID = "uuid";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
	protected static final String USER_USER_NAME = "userName";
	protected static final String USER_EMAIL = "email";
	protected static final String USER_PASSWORD = "password";
    protected static final String USER_STREAK = "streak";
    protected static final String USER_LEVEL = "level";
    protected static final String USER_ACHIEVEMENTS = "achievement";
    protected static final String USER_LEADERBOARD_RANKING = "leaderboard-ranking";

    // Songlist file location
    protected static final String SONG_FILE_NAME = "json\\songlist.json";

    // Root JSON key
    protected static final String SONG_LIST = "songlist";

    // Song category properties
    protected static final String CATEGORY_ID = "id";
    protected static final String CATEGORY_NAME = "name";
    protected static final String CATEGORY_DIFFICULTY = "difficulty";
    protected static final String CATEGORY_LENGTH = "length";
    protected static final String CATEGORY_GENRE = "genre";

    // Song details
    protected static final String SONGS = "songs";
    protected static final String SONG_ID = "id";
    protected static final String SONG_NAME = "name";
    protected static final String SONG_DIFFICULTY = "difficulty";
    protected static final String SONG_LENGTH = "length";
    protected static final String SONG_GENRE = "genre";

    // Measures inside each song
    protected static final String MEASURES = "measures";
    protected static final String MEASURE_NUMBER = "measureNumber";
    protected static final String CHORDS = "chords";

    // Additional song properties
    protected static final String SHEET_MUSIC = "sheetMusic";
    protected static final String TABS_MUSIC = "tabsMusic";
    protected static final String METRONOME = "metronome";

    //flashcard constants 
    protected static final String FLASHCARD_FILE_NAME = "json\\flashcard.json";
    protected static final String FLASHCARD_ID = "flashcardID";
    protected static final String FLASHCARD_QUESTION = "question";
    protected static final String FLASHCARD_ANSWER = "answer";
}