package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a lesson that includes a song, content, flashcards, and performance tracking.
 */

public class Lesson {
    private String title;
    private Song song;
    private String lessonID;
    private int difficulty;
    private String content;
    private double rating;
    private int performanceScore;
    private ArrayList<Flashcard> flashcards;
    private Instrument instrument;

    /**
     * Creates a Lesson object
     * @param title
     * @param song
     * @param lessonID
     * @param difficulty
     * @param content
     * @param rating
     * @param instrument
     */
    public Lesson(String title, Song song, String lessonID, int difficulty, String content, double rating, Instrument instrument) {
        this.title = title;
        this.song = song;
        this.lessonID = lessonID;
        this.difficulty = difficulty;
        this.content = content;
        this.rating = rating;
        this.instrument = instrument;
        this.flashcards = new ArrayList<>();
        this.performanceScore = 0;
    }

    /**
     * Starts the lesson
     */
    public void startLesson() {
        System.out.println("\nStarting Lesson: " + title);
        System.out.println("Song: " + song.getSongName());
        System.out.println("Instrument: " + instrument.getName());
        System.out.println("Content: " + content);
        System.out.println("Let's test your knowledge with some flashcards!");
    
        Scanner scanner = new Scanner(System.in);
        int correctCount = 0;
    
        for (Flashcard flashcard : FlashcardList.getInstance().getFlashcards()) {
            System.out.println("\nQuestion: " + flashcard.getQuestion());
            System.out.print("Your Answer: ");
            String userAnswer = scanner.nextLine().trim();
    
            if (userAnswer.equalsIgnoreCase(flashcard.getAnswer().trim())) {
                System.out.println("Correct!");
                correctCount++;
            } else {
                System.out.println("Incorrect. Correct answer: " + flashcard.getAnswer());
            }
        }
    
        this.performanceScore = (int)(((double) correctCount / FlashcardList.getInstance().getFlashcards().size()) * 100);
    }
    
    /**
     * Completes the lesson and checks your score
     */
    public void completeLesson() {
        System.out.println("Your performance score: " + performanceScore + "%");
    
        if (performanceScore == 100) {
            System.out.println("Perfect score! Great job!");
        } else if (performanceScore >= 70) {
            System.out.println("Nice work! Keep it up.");
        } else {
            System.out.println("Don't worry! Try again and you'll improve.");
        }
    }
    

    
    /**
     * displays feedback based on how the user does during the lesson
     */
    public void displayFeedback() {
        System.out.println("Your performance score: " + performanceScore + "%");
        if (performanceScore >= 80) {
            System.out.println("Great job!");
        } else if (performanceScore >= 50) {
            System.out.println("Good effort! Keep practicing");
        } else {
            System.out.println("Don't worry! Try again and you'll improve");
        }
    }

    /**
     * gets the song
     * @return a Song
     */
    public Song getSong() {
        return song;
    }

    /**
     * gets the flashcards for the lesson
     * @param lessonID
     * @return List of flashcards
     */
    public List<Flashcard> getFlashcards(String lessonID) {
        return flashcards;
    }
     
}
