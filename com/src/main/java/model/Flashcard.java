package model;
import java.util.UUID;
public class Flashcard {
    private String question;
    private String answer;
    private UUID flashcardID;


    /*
     * flashcard object
     */
    public Flashcard(String question, String answer) {
        this.flashcardID = UUID.randomUUID();
        this.question = question;
        this.answer = answer;
    }

    /*
     * getter method 
     * @return question 
     */
    public UUID getFlashcardID() {
        return flashcardID;
    }


    /*
     * getter method
     * @return question 
     */
    public String getQuestion() {
        return question;
    }


    /*
     * getter method 
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }


    /*
     * setter method 
     * @param question 
     */
    public void setQuestion(String question) {
        this.question = question;
    }


    /*
     * setter method 
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }


    /*checks if flashcard answer is correct
     * @param flashcardID
     * @param userAnswer
     * @return boolean 
     */
    public boolean answerFlashcard(String flashcardID, String userAnswer ) {
        if (userAnswer == this.answer) {
            return true;
        }
        else {
            return false;
        }
    }
    
}
