package model;
import java.util.UUID;
public class Flashcard {
    private String question;
    private String answer;
    private UUID flashcardID;
    private String chapter; 


    /*
     * flashcard object
     */
    public Flashcard(UUID flashcardID, String question, String answer, String chapter) {
        this.flashcardID = flashcardID;
        this.question = question;
        this.answer = answer;
        this.chapter = chapter;
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

    public String getChapter() {
        return chapter;
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

    public void setChapter(String chapter) {
        this.chapter = chapter;
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
