package model;

import java.util.ArrayList;
import java.util.List;

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

    public void startLesson() {
 
    }

    public void completeLesson() {
  
    }

    public void calculateScore() {
  
    }

    public void displayFeedback() {

    }

    public Song getSong() {
        return song;
    }

    public List<Flashcard> getFlashcards(String lessonID) {
        return flashcards;
    }

    public void recordResponse(User user, String answer) {
        
    }
/*
    public void saveFlashcardProgress(User user, String lessonID, ProgressData progressData) {
      
    }
     */
}
