package model;

public class Driver {
    public static void main(String[] args) {
     
        UserList userList = UserList.getInstance();
        SongList songList = SongList.getInstance();
        DataLoader.getInstance().loadUsers();
        DataLoader.getInstance().loadSongs();

        System.out.println("🎵 Welcome to Scale-A-Saurus! \n");

        /*
         * hardcoded login 
         */

        String testUsername = "lily123";
        String testPassword = "password123";


        User currentUser = userList.getUser(testUsername, testPassword);
        if (currentUser == null) {
            System.out.println("User not found. Creating test user...");
            User newUser = new User(testUsername, "Lily", "Deller", testPassword, "lily@email.sc.edu");
            userList.addUser(newUser);
            currentUser = userList.getUser(testUsername, testPassword);
        }

        System.out.println(" Logged in as: " + currentUser.getUserName());

    
        System.out.println("\n🎶 Now Playing: Test Song ");
        Song testSong = new Song("test123", "Test Song", 3, "2:30", "POP", new java.util.ArrayList<>(), "sheetMusic", "tabsMusic", false);
        MusicProgram musicPlayer = new MusicProgram();
        
       
        musicPlayer.playSong("Test Song");

        System.out.println("\n Achievements:");
        currentUser.viewAchievements().forEach(System.out::println);

        System.out.println("\n Exiting Scale-A-Saurus!");
    }
}
