package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class DataLoader {
    private static DataLoader instance;
    private UserList userList;
    private SongList songList;

    // private constructor
    private DataLoader() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
    }

    // singleton pattern to get instance of DataLoader
    public static DataLoader getInstance() {
        if (instance == null) {
            instance = new DataLoader();
        }
        return instance;
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("userlist.json")) {
            JSONArray rootJson = (JSONArray) parser.parse(reader);

            for (Object obj : rootJson) {
                JSONObject userJson = (JSONObject) obj;

                String uuidString = (String) userJson.get("uuid");
                UUID uuid = UUID.fromString(uuidString);  // Convert String to UUID
                String firstName = (String) userJson.get("firstname");
                String lastName = (String) userJson.get("lastname");
                String username = (String) userJson.get("username");
                String email = (String) userJson.get("email");
                String password = (String) userJson.get("password");
                int streak = ((Long) userJson.get("streak")).intValue();
                int level = ((Long) userJson.get("level")).intValue();

                JSONArray achievementArray = (JSONArray) userJson.get("achievements");
                ArrayList<String> achievements = new ArrayList<>();
                for (Object achievement : achievementArray) {
                    achievements.add(achievement.toString());
                }


                JSONArray leaderboardArray = (JSONArray) userJson.get("leaderboard-ranking");
                ArrayList<String> leaderboardRankings = new ArrayList<>();
                for (Object ranking : leaderboardArray) {
                    leaderboardRankings.add(ranking.toString());
                }

                // create a User object
                User user = new User(uuid, username, firstName, lastName, password, email, streak, level, achievements);
                users.add(user);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void loadSongs() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("songlist.json")) {
            JSONObject rootJson = (JSONObject) parser.parse(reader);
            JSONArray songCategoriesArray = (JSONArray) rootJson.get("songlist");

            for (Object categoryObj : songCategoriesArray) {
                JSONObject categoryJson = (JSONObject) categoryObj;

                String categoryId = (String) categoryJson.get("id");
                String categoryName = (String) categoryJson.get("name");
                String difficulty = (String) categoryJson.get("difficulty");
                String length = (String) categoryJson.get("length");
                String genre = (String) categoryJson.get("genre");

                ArrayList<Song> songs = new ArrayList<>();

                JSONArray songsArray = (JSONArray) categoryJson.get("songs");
                for (Object songObj : songsArray) {
                    JSONObject songJson = (JSONObject) songObj;

                    String songId = (String) songJson.get("id");
                    String songName = (String) songJson.get("name");
                    int songDifficulty = ((Long) songJson.get("difficulty")).intValue();
                    String songLength = (String) songJson.get("length");
                    String songGenre = (String) songJson.get("genre");

                    JSONArray measuresArray = (JSONArray) songJson.get("measures");
                    ArrayList<Measure> measures = new ArrayList<>();

                    for (Object measureObj : measuresArray) {
                        JSONObject measureJson = (JSONObject) measureObj;
                        int measureNumber = ((Long) measureJson.get("measureNumber")).intValue();

                        JSONArray chordsArray = (JSONArray) measureJson.get("chords");
                        ArrayList<String> chords = new ArrayList<>();
                        for (Object chord : chordsArray) {
                            chords.add(chord.toString());
                        }

                        measures.add(new Measure(measureNumber, chords));
                    }

                    String sheetMusic = (String) songJson.get("sheetMusic");
                    String tabsMusic = (String) songJson.get("tabsMusic");
                    boolean metronome = (boolean) songJson.get("metronome");

                    Song song = new Song(songId, songName, songDifficulty, songLength, songGenre, measures, sheetMusic, tabsMusic, metronome);
                    songs.add(song);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<User> users = DataLoader.loadUsers();

        for (User user : users) {
            System.out.println(user);
        }
    }
}


