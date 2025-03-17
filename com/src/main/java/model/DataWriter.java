package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    private static DataWriter instance;
    private UserList userList;
    private SongList songList;

    // priivate constructor
    private DataWriter() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
    }

    // singleton pettern to get instance of DataWriter
    public static DataWriter getInstance() {
        if (instance == null) {
            instance = new DataWriter();
        }
        return instance;
    }


    public void saveUsers() {
        ArrayList<User> userList = this.userList.getUsers();

        JSONArray jsonUsers = new JSONArray();

        //create json objects 
        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));

        }
        //write json
        try {
            FileWriter file = new FileWriter(USER_FILE_NAME);
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (Exception e) {
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
        userDetails.put(USER_ACHIEVEMENTS, user.getAchievements());
        userDetails.put(USER_LEADERBOARD_RANKING, user.getLeaderboardRanking());
    

        return userDetails;
    }
    /*
     * //user constants 
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

     */

    public void saveSongs() {
        //get song list
        JSONArray jsonSongList = new JSONArray();
        String[] difficulties = {"Easy", "Medium", "Hard"};

        //group songs by difficulty 
        for (int i = 0; i < difficulties.length; i++) {
            JSONObject difficultyGroup = new JSONObject();
            difficultyGroup.put(SONG_DIFFICULTY, difficulties[i]);

            //get songs for current difficulty 
            ArrayList<Song> songs = songList.getSongsByDifficulty(difficulties[i]);
            JSONArray jsonSongs = new JSONArray();

            for (int e = 0; e < songs.size(); e++) {
                jsonSongs.add(getSongJSON(songs.get(e)));
            }
            difficultyGroup.put(SONGS, jsonSongs);
            jsonSongList.add(difficultyGroup);
        }
        //write into json file 
        try {
            FileWriter file = new FileWriter(SONG_FILE_NAME);
            file.write(jsonSongList.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //convert song into JSONObject 
    public static JSONObject getSongJSON(Song song) {
        JSONObject songJSON = new JSONObject();
        songJSON.put(SONG_ID, song.getSongId().toString());
        songJSON.put(SONG_NAME, song.getSongName());
        songJSON.put(SONG_DIFFICULTY, song.getDifficulty());
        songJSON.put(SONG_LENGTH, song.getLength());
        songJSON.put(SONG_GENRE, song.getGenre());
        songJSON.put(SHEET_MUSIC, song.getSheetMusic());
        songJSON.put(TABS_MUSIC, song.getTabsMusic());
        songJSON.put(METRONOME, song.isMetronomeEnabled());

        JSONArray jsonMeasures = new JSONArray();
        ArrayList<Measure> measures = song.getMeasures();

        for (int i = 0; i < measures.size(); i++) {
            jsonMeasures.add(getMeasureJSON(measures.get(i)));
        }
        songJSON.put(MEASURES, jsonMeasures);
        return songJSON;
    }
    //convert measure into JSON object 
    public static JSONObject getMeasureJSON(Measure measure) {
        JSONObject measureJSON = new JSONObject();
        measureJSON.put(MEASURE_NUMBER, measure.getMeasureNumber());

        JSONArray jsonChords = new JSONArray();
        ArrayList<String> chords = measure.getChord();

        for (int i = 0; i < chords.size(); i++) {
            jsonChords.add(chords.get(i));
        }
        measureJSON.put(CHORDS, jsonChords);
        return measureJSON;
    }

    public void saveUserData(User user) {
        ArrayList<User> userList = this.userList.getUsers();
        userList.add(user);
        saveUsers();
    }

    public void saveFlashcards() {
        ArrayList<Flashcard> flashcards = FlashcardList.getInstance().getFlashcards();

        JSONArray jsonFlashcards = new JSONArray();

        for (int i = 0; i < flashcards.size(); i++) {
            jsonFlashcards.add(getFlashcardJSON(flashcards.get(i)));
        }

        try (FileWriter file = new FileWriter(FLASHCARD_FILE_NAME)) { //add to constants once json is made TODO
            file.write(jsonFlashcards.toJSONString());
            file.flush();
            System.out.println("Flashcards have been saved");
        }
        catch (IOException e) {
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

  

    
    public static void main(String[] args) {

        ArrayList<User> users = DataLoader.loadUsers();
        for (User user : users) {
            System.out.println(user.getUserName() + " - " + user.getEmail());
        }

      
        SongList songList = SongList.getInstance();
        songList.sortByDifficulty();  
        for (Song song : songList.getSongs()) {
            System.out.println(song.getSongName() + " - Difficulty: " + song.getDifficulty());
        }

 
        DataWriter writer = DataWriter.getInstance();
        writer.saveUsers();
        writer.saveSongs();
    }
}
    

