package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataWriter extends DataConstants {
    private static DataWriter instance;
    private UserList userList;
    private SongList songList;

    private DataWriter() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
    }

    public static DataWriter getInstance() {
        if (instance == null) {
            instance = new DataWriter();
        }
        return instance;
    }

    public static void saveUsers() {
        ArrayList<User> userList = UserList.getInstance().getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (User user : userList) {
            jsonUsers.add(getUserJSON(user));
        }

        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_STREAK, user.getStreak());
        userDetails.put(USER_LEVEL, user.getLevel());
        userDetails.put(USER_LEADERBOARD_RANKING, user.getLeaderboardRanking());

        JSONArray achievementsArray = new JSONArray();
        for (Achievement achievement : user.viewAchievements()) {
            achievementsArray.add(achievement.getName());
        }
        userDetails.put(USER_ACHIEVEMENTS, achievementsArray);

        return userDetails;
    }

    public static void saveSongs() {
        JSONArray jsonSongList = new JSONArray();
        SongList songList = SongList.getInstance();
        String[] difficulties = {"Easy", "Medium", "Hard"};

        for (int i = 0; i < difficulties.length; i++) {
            JSONObject difficultyGroup = new JSONObject();
            difficultyGroup.put("difficulty_level", i + 1);
            difficultyGroup.put("difficulty", difficulties[i]);
            difficultyGroup.put("name", difficulties[i] + " Songs");

            JSONArray jsonSongs = new JSONArray();
            ArrayList<Song> songs = songList.getSongsByDifficulty(i + 1);
            for (Song song : songs) {
                jsonSongs.add(getSongJSON(song));
            }

            difficultyGroup.put("songs", jsonSongs);
            jsonSongList.add(difficultyGroup);
        }

        try (FileWriter file = new FileWriter(SONG_FILE_NAME)) {
            file.write("{\"songlist\": " + jsonSongList.toJSONString() + "}");
            file.flush();
            System.out.println("Songs successfully saved to " + SONG_FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving songs: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static JSONObject getSongJSON(Song song) {
        JSONObject songJSON = new JSONObject();
        songJSON.put(SONG_ID, song.getSongId());
        songJSON.put(SONG_NAME, song.getSongName());
        songJSON.put(SONG_DIFFICULTY, song.getDifficulty());
        songJSON.put(SONG_LENGTH, song.getLength());
        songJSON.put(SONG_GENRE, song.getGenre());
        songJSON.put(SHEET_MUSIC, song.getSheetMusic());
        songJSON.put(TABS_MUSIC, song.getTabsMusic());
        songJSON.put(METRONOME, song.isMetronomeEnabled());

        JSONArray jsonMeasures = new JSONArray();
        for (Measure measure : song.getMeasures()) {
            jsonMeasures.add(getMeasureJSON(measure));
        }

        songJSON.put(MEASURES, jsonMeasures);
        return songJSON;
    }

    public static JSONObject getMeasureJSON(Measure measure) {
        JSONObject measureJSON = new JSONObject();
        measureJSON.put(MEASURE_NUMBER, measure.getMeasureNumber());

        JSONArray jsonChords = new JSONArray();
        for (Chord chord : measure.getChords()) {
            String chordStr = Chord.chordToString(chord.getNotes());
            jsonChords.add(chordStr);
        }

        measureJSON.put(CHORDS, jsonChords);
        return measureJSON;
    }

    public void saveUserData(User user) {
        ArrayList<User> userList = this.userList.getUsers();
        userList.add(user);
        saveUsers();
    }

    public static void saveFlashcards() {
        ArrayList<Flashcard> flashcards = FlashcardList.getInstance().getFlashcards();
        JSONArray jsonFlashcards = new JSONArray();

        for (Flashcard flashcard : flashcards) {
            jsonFlashcards.add(getFlashcardJSON(flashcard));
        }

        try (FileWriter file = new FileWriter(FLASHCARD_FILE_NAME)) {
            file.write(jsonFlashcards.toJSONString());
            file.flush();
            System.out.println("Flashcards have been saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getFlashcardJSON(Flashcard flashcard) {
        JSONObject jsonFlashcard = new JSONObject();
        jsonFlashcard.put(FLASHCARD_ID, flashcard.getFlashcardID().toString());
        jsonFlashcard.put(FLASHCARD_QUESTION, flashcard.getQuestion());
        jsonFlashcard.put(FLASHCARD_ANSWER, flashcard.getAnswer());
        return jsonFlashcard;
    }

    public static void saveAll() {
        saveUsers();
        saveSongs();
        saveFlashcards();
    }

    public static void main(String[] args) {
        saveAll();
    }
}
