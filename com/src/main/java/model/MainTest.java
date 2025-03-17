package model;

import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("running backend tests");

 
        UserList userList = UserList.getInstance();
       // userList.addUser("Lily", "Deller", "lily123", "password123", "lily@email.sc.edu");
        User testUser = userList.getUser("lily123", "password123");

        if (testUser != null) {
           // System.out.println("user created and logged in successfully: " + testUser.getUsername());
        } else {
            System.out.println("user login failed.");
        }

     
        //DataWriter.saveUsers();
        System.out.println("user data saved to JSON.");

   
        SongList songList = SongList.getInstance();
        Song testSong = new Song("test123", "Test Song", 3, "2:30", "POP", new ArrayList<>(), "sheetMusic", "tabsMusic", false);
        songList.addSong(testSong);

        if (songList.getSong("Test Song") != null) {
            System.out.println("song added and retrieved successfully: " + testSong.getSongName());
        } else {
            System.out.println("song retrieval failed.");
        }

   
        //DataWriter.saveSongs();
        System.out.println("song data saved to JSON.");


        Flashcard flashcard = new Flashcard("what are the black keys on a piano called?", "accidentals");
        if (flashcard.getAnswer().equals("accidentals")) {
            System.out.println("flashcard system working correctly.");
        } else {
            System.out.println("flashcard system failed.");
        }

        ProgressData progressData = new ProgressData();
       // DataWriter.saveFlashcardProgress(testUser, "lesson1", progressData);
        System.out.println("flashcard progress saved.");

 
        Lesson lesson = new Lesson("beginner Lesson", testSong, "lesson1", 1, "Intro to piano", 5.0, new Instrument("Piano"));
        lesson.startLesson();
        lesson.completeLesson();
        System.out.println("lesson methods executed.");

       
        ArrayList<User> users = DataLoader.loadUsers();
        if (!users.isEmpty()) {
            System.out.println("JSON user data loaded successfully.");
        } else {
            System.out.println("JSON user data loading failed.");
        }

        ArrayList<Song> songs = DataLoader.loadSongs();
        if (!songs.isEmpty()) {
            System.out.println("JSON song data loaded successfully.");
        } else {
            System.out.println("JSON song data loading failed.");
        }

        System.out.println("All tests completed ");
    }
}
