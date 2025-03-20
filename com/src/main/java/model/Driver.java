package model;

public class Driver {
    public static void main(String[] args) {
        UserList userList = UserList.getInstance();
        SongList songList = SongList.getInstance();
        DataLoader.getInstance().loadUsers();
        DataLoader.getInstance().loadSongs();

        System.out.println("Welcome to Scale-A-Saurus! \n");


        String testUsername = "lily123";
        String testPassword = "password123";

        User currentUser = userList.getUser(testUsername, testPassword);
        if (currentUser == null) {
            System.out.println(" User not found. Creating test user...");
            User newUser = new User(testUsername, "Lily", "Deller", testPassword, "lily@email.sc.edu");
            userList.addUser(newUser);
            currentUser = userList.getUser(testUsername, testPassword);
        }

        if (currentUser == null) {
            System.out.println("Failed to create user! Exiting...");
            return;
        }

        System.out.println("🎤 Logged in as: " + currentUser.getUserName());

      
        Instrument piano = new Instrument("Piano");
        System.out.println(" Default Instrument: " + piano.getName());


        MusicProgram musicProgram = new MusicProgram();
        musicProgram.addInstrument(piano);
        musicProgram.setCurrentInstrument("Piano");


        Song testSong = songList.getSong("Bohemian Rhapsody");
        if (testSong == null) {
            System.out.println("\nAdding Test Song...");
            testSong = new Song("test123", "Bohemian Rhapsody", 3, "2:30", "POP", new java.util.ArrayList<>(), "sheetMusic", "tabsMusic", false);
            songList.addSong(testSong);
            songList.saveSongs();  
            System.out.println(" Added song: " + testSong.getSongName());
        }

 
        Song retrievedSong = songList.getSong("Bohemian Rhapsody");

        if (retrievedSong != null) {
            System.out.println("\nNow Playing: " + retrievedSong.getSongName() + " on " + piano.getName());
            MusicProgram.playSong(retrievedSong.getSongName());  
        } else {
            System.out.println("Song retrieval failed.");
        }

 
        System.out.println("\nAchievements:");
        currentUser.viewAchievements().forEach(System.out::println);

        System.out.println("\nExiting Scale-A-Saurus!");
    }
}
