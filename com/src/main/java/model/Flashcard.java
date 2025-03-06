package model;
import java.util.UUID;
public class Flashcard {
    private String question;
    private String answer;
    private UUID flashcardID;


    public Flashcard(String question, String answer) {
        this.flashcardID = UUID.randomUUID();
        this.question = question;
        this.answer = answer;
    }

    public UUID getFlashcardID() {
        return flashcardID;
    }


    public String getQuestion() {
        return question;
    }


    public String getAnswer() {
        return answer;
    }


    public void setQuestion(String question) {
        this.question = question;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public boolean answerFlashcard(String flashcardID, String answer ) {
        return false; // stub method 
    }
    
}
