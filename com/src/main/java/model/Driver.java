package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserList userList = UserList.getInstance();
        SongList songList = SongList.getInstance();
        DataLoader.getInstance().loadAll();

        System.out.println("Welcome to Scale-A-Saurus! \n");

        User currentUser = null;

        // Login or Register
        while (currentUser == null) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                currentUser = userList.getUser(username, password);
                if (currentUser == null) {
                    System.out.println("Invalid credentials. Try again.");
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

                User newUser = new User(username, firstName, lastName, password, email);
                userList.addUser(newUser);
                DataWriter.saveUsers();
                System.out.println("Account created successfully!");
                currentUser = newUser;
                
                if (userList.getUserByUsername(username) != null) {
                    System.out.println("Username already exists. Please choose a different one.");
                    continue;
                }
                
            }
        }

        System.out.println("Logged in as: " + currentUser.getUserName());

        // Main Menu
        boolean running = true;
        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Play a Song");
            System.out.println("2. Search for Songs");
            System.out.println("3. Create a Song");
            System.out.println("4. Start a Lesson");
            System.out.println("5. View Achievements");
            System.out.println("6. Logout");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    songList.display();
                    System.out.print("Enter song name: ");
                    String songName = scanner.nextLine();
                    Song song = songList.getSong(songName);
                    if (song != null) {
                        System.out.println("\n🎵 Now Playing: " + song.getSongName());
                        MusicProgram.playSong(song.getSongName());
                        saveSheetMusic(song);
                    } else {
                        System.out.println("Song not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    System.out.println("Searching for songs by " + artist + "...\n");
                    ArrayList<Song> foundSongs = songList.getSongsByArtist(artist);
                    if (foundSongs.isEmpty()) {
                        System.out.println("No songs found for artist: " + artist);
                    } else {
                        System.out.println("Songs by " + artist + ":");
                        for (Song s : foundSongs) {
                            System.out.println("- " + s.getSongName() + " (" + s.getGenre() + ", " + s.getLength() + ")");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter song title: ");
                    String newSongName = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String newArtist = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter length (MM:SS): ");
                    String length = scanner.nextLine();
                    System.out.print("Enter difficulty (1-3): ");
                    int difficulty = scanner.nextInt();
                    scanner.nextLine();

                    Song newSong = new Song(
                            "song" + (songList.getSongs().size() + 1),
                            newSongName, difficulty, length, genre,
                            new ArrayList<>(), "sheetMusic.txt", "tabsMusic.txt", false,
                            newArtist
                    );

                    songList.addSong(newSong);
                    songList.saveSongs();
                    System.out.println("Song '" + newSongName + "' by " + newArtist + " added successfully!");
                    break;

                case 4:
                    System.out.println("Starting a Lesson...");
                    Lesson lesson = new Lesson("Beginner Piano Lesson", songList.getSongs().get(0), "lesson1", 1, "Learn the basics of piano", 5.0, new Instrument("Piano"));
                    lesson.startLesson();
                    System.out.println("Lesson Completed!");
                    lesson.completeLesson();
                    currentUser.unlockAchievement("First Song Played!");
                    break;

                case 5:
                    System.out.println("\nAchievements:");
                    currentUser.viewAchievements().forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Logging out...");
                    currentUser = null;
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println("\nExiting Scale-A-Saurus!");
        scanner.close();
    }

    private static void saveSheetMusic(Song song) {
        try {
            String folderPath = "sheet_music";
            java.io.File folder = new java.io.File(folderPath);
            if (!folder.exists()) {
                folder.mkdir();
            }

            String fileName = "sheetMusic_" + song.getSongName().replaceAll(" ", "_") + ".txt";
            String filePath = folderPath + "/" + fileName;

            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write("Sheet Music for: " + song.getSongName() + "\n");
            fileWriter.write("Artist: " + song.getArtist() + "\n");
            fileWriter.write("Instrument: Piano\n\n");
            fileWriter.write("Measures:\n");

            for (Measure measure : song.getMeasures()) {
                fileWriter.write("Measure " + measure.getMeasureNumber() + ": | ");
                for (Chord chord : measure.getChords()) {
                    fileWriter.write(Chord.chordToString(chord.getNotes()) + "  ");
                }
                fileWriter.write("|\n");
            }

            fileWriter.close();
            System.out.println("Sheet music saved: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving sheet music.");
            e.printStackTrace();
        }
    }
}
