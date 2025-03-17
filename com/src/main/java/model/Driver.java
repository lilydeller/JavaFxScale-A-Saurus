package model;

public class Driver {

    public static void main(String[]args ){

        User user = new User("username", "firstName", "lastName", "password", "email");
        Song song = new Song("Song Title", "Genre", "Difficulty");
        Lesson lesson = new Lesson;

        System.out.println("Welcome to the Music Program!");

        // Sample action: Display song details
        System.out.println("Song details:");
        System.out.println(song.getSongDetails());

        // Sample action: User starts a lesson
        System.out.println("Starting lesson: " + lesson.getLesson());
        lesson.startLesson();

        // Sample action: User completes the lesson
        lesson.completeLesson();
        System.out.println("Lesson Completed. " + lesson.getFeedback());

        // Sample action: Record user progress
        user.recordProgress(lesson, 85); // Assuming 85% completion

        // Add any other methods that simulate actions within the music program
    }
}
    }

}