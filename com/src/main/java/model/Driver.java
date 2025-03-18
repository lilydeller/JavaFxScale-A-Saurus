package model;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserList userList = UserList.getInstance();
        SongList songList = SongList.getInstance();
        DataLoader.getInstance().loadUsers();
        DataLoader.getInstance().loadSongs();

        System.out.println("🎵 Welcome to Scale-A-Saurus! 🎵");
        System.out.println("1. Log in\n2. Register");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        User currentUser = null;
        if (choice == 1) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            currentUser = userList.getUser(username, password);

            if (currentUser == null) {
                System.out.println("Invalid credentials. Exiting...");
                return;
            }
        } else if (choice == 2) {
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Choose a username: ");
            String username = scanner.nextLine();
            System.out.print("Choose a password: ");
            String password = scanner.nextLine();

            userList.addUser(firstName, lastName, username, password, email);
            currentUser = userList.getUser(username, password);
        }

        System.out.println("\nWelcome, " + currentUser.getUsername() + "!");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Play a Song");
            System.out.println("2. Start a Lesson");
            System.out.println("3. View Achievements");
            System.out.println("4. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.println("Available Songs:");
                    songList.display();
                    System.out.print("Enter song name: ");
                    String songName = scanner.nextLine();
                    Song song = songList.getSong(songName);
                    if (song != null) {
                        MusicProgram musicPlayer = new MusicProgram();
                        musicPlayer.playSong();  
                    } else {
                        System.out.println("Song not found");
                    }
                    break;
    
                case 2:
                    System.out.println("Your Achievements:");
                    currentUser.viewAchievements().forEach(a -> System.out.println(a));
                    break;
                case 3:
                    System.out.println("Exiting Scale-A-Saurus!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
