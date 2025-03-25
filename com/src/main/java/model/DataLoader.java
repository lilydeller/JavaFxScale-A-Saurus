package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * loads the data from a JSON file into corresponding lists
 */
public class DataLoader {
    private static DataLoader instance;
    private UserList userList;
    private SongList songList;
    private static ArrayList<Achievement> achievements = new ArrayList<>();

    /**
     * Creates a DataLoader object
     */
    private DataLoader() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
    }

    /**
     * Retrieves the singleton instance of DataLoader
     * @return a DataLoader instance
     */
    public static DataLoader getInstance() {
        if (instance == null) {
            instance = new DataLoader();
        }
        return instance;
    }

    /**
     * loads all data
     */
    public void loadAll() {
        loadUsers();
        loadSongs();
        loadAchievements();
        loadFlashcards(); 
    }

    /**
     * loads flashcards from a JSON file
     */
    public static void loadFlashcards() {
        JSONParser parser = new JSONParser();
    
        try (FileReader reader = new FileReader("json/flashcard.json")) {
            JSONObject rootJson = (JSONObject) parser.parse(reader);
            JSONArray flashcardArray = (JSONArray) rootJson.get("flashcards");
    
            for (Object obj : flashcardArray) {
                JSONObject flashcardJson = (JSONObject) obj;
                String question = (String) flashcardJson.get("question");
                String answer = (String) flashcardJson.get("answer");
    
                Flashcard flashcard = new Flashcard(question, answer);
                FlashcardList.getInstance().addFlashcard(flashcard);
            }
    
            System.out.println("Flashcards Loaded: " + FlashcardList.getInstance().getFlashcards().size());
    
        } catch (IOException | ParseException e) {
            System.out.println("Error loading flashcards");
            e.printStackTrace();
        }
    }
    

    /**
     * loads acheivements from a JSON file
     */
    public static void loadAchievements() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("json/achievements.json")) {
            JSONObject rootJson = (JSONObject) parser.parse(reader);
            JSONArray achievementsArray = (JSONArray) rootJson.get("achievements");

            for (Object obj : achievementsArray) {
                JSONObject achievementJson = (JSONObject) obj;
                String id = (String) achievementJson.get("id");
                String name = (String) achievementJson.get("name");
                String description = (String) achievementJson.get("description");
                achievements.add(new Achievement(id, name, description));
            }

            System.out.println("Achievements Loaded: " + achievements.size());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * gets the list of achievements
     * @return an ArrayList of achievements
     */
    public static ArrayList<Achievement> getAchievements() {
        return achievements;
    }

    /**
     * loads users from a JSON file
     * @return an ArrayList of users
     */
    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
    
        try (FileReader reader = new FileReader("json/userlist.json")) {
            JSONObject rootJson = (JSONObject) new JSONParser().parse(reader); 
            JSONArray usersArray = (JSONArray) rootJson.get("users");          
    
            for (Object userObj : usersArray) {
                JSONObject userJson = (JSONObject) userObj;
    
                String uuidString = (String) userJson.get("uuid");
                UUID uuid = UUID.fromString(uuidString);
                String firstName = (String) userJson.get("firstName");
                String lastName = (String) userJson.get("lastName");
                String username = (String) userJson.get("userName");
                String email = (String) userJson.get("email");
                String password = (String) userJson.get("password");
                int streak = ((Long) userJson.get("streak")).intValue();
                int level = ((Long) userJson.get("level")).intValue();
    
                JSONArray achievementArray = (JSONArray) userJson.get("achievement");
                ArrayList<String> achievements = new ArrayList<>();
                for (Object achievement : achievementArray) {
                    achievements.add(achievement.toString());
                }
    
                JSONArray leaderboardArray = (JSONArray) userJson.get("leaderboard-ranking");
                ArrayList<String> leaderboardRankings = new ArrayList<>();
                for (Object ranking : leaderboardArray) {
                    leaderboardRankings.add(ranking.toString());
                }
    
                User user = new User(uuid, username, firstName, lastName, password, email, streak, level, achievements);
                user.setLeaderboardRanking(leaderboardRankings);
                users.add(user);
            }
    
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    
        
        UserList.getInstance().getUsers().clear();
        UserList.getInstance().getUsers().addAll(users);
    
        return users;
    }
    
    

    /**
     * loads songs from a JSON file
     * @return an ArrayList of songs
     */
    public static ArrayList<Song> loadSongs() {
        ArrayList<Song> songs = new ArrayList<>();
        JSONParser parser = new JSONParser();
    
        try (FileReader reader = new FileReader("json/songlist.json")) {
            JSONObject rootJson = (JSONObject) parser.parse(reader);
    
            JSONArray songsArray = (JSONArray) rootJson.get("songs"); // new flat format
            if (songsArray == null) {
                // fallback to old format
                songsArray = new JSONArray();
                JSONArray difficultyGroups = (JSONArray) rootJson.get("songlist");
                for (Object groupObj : difficultyGroups) {
                    JSONObject groupJson = (JSONObject) groupObj;
                    JSONArray groupSongs = (JSONArray) groupJson.get("songs");
                    if (groupSongs != null) {
                        songsArray.addAll(groupSongs);
                    }
                }
            }
    
            for (Object songObj : songsArray) {
                JSONObject songJson = (JSONObject) songObj;
    
                String songId = (String) songJson.get("id");
                String songName = (String) songJson.get("name");
                String artist = (String) songJson.get("artist");
                int songDifficulty = ((Long) songJson.get("difficulty")).intValue();
                String songLength = (String) songJson.get("length");
                String songGenre = (String) songJson.get("genre");
    
                JSONArray measuresArray = (JSONArray) songJson.get("measures");
                ArrayList<Measure> measures = new ArrayList<>();
    
                for (Object measureObj : measuresArray) {
                    JSONObject measureJson = (JSONObject) measureObj;
                    int measureNumber = ((Long) measureJson.get("measureNumber")).intValue();
    
                    JSONArray chordsArray = (JSONArray) measureJson.get("chords");
                    ArrayList<Chord> chords = new ArrayList<>();
                    for (Object chordObj : chordsArray) {
                        chords.add(Chord.fromString((String) chordObj));
                    }
    
                    measures.add(new Measure(measureNumber, chords));
                }
    
                String sheetMusic = (String) songJson.get("sheetMusic");
                String tabsMusic = (String) songJson.get("tabsMusic");
                boolean metronome = (Boolean) songJson.get("metronome");
    
                Song song = new Song(
                    songId, songName, songDifficulty, songLength, songGenre,
                    measures, sheetMusic, tabsMusic, metronome, artist
                );
    
                songs.add(song);
            }
    
            // Load into the singleton
            SongList.getInstance().getSongs().clear();
            SongList.getInstance().getSongs().addAll(songs);
    
        } catch (Exception e) {
            System.out.println(" Error loading songs.");
            e.printStackTrace();
        }
    
        return songs;
    }
    

    public static void main(String[] args) {
        ArrayList<User> users = DataLoader.loadUsers();
        ArrayList<Song> songs = DataLoader.loadSongs();

        for (User user : users) {
            System.out.println(user);
        }

        for (Song song : songs) {
            System.out.println("Song: " + song.getSongName() + " by " + song.getArtist());
            System.out.println("Genre: " + song.getGenre() + " | Length: " + song.getLength());
            System.out.println("Sheet Music: ");
            for (Measure measure : song.getMeasures()) {
                System.out.println("  Measure " + measure.getMeasureNumber() + ": " + measure.getChords());
            }
            System.out.println("-----------------------------");
        }
    }
}
