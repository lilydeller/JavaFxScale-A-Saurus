// package com.model;
public class flashcard {
    private String question;
    private String answer;

    //@PARAM quesiton - a String question , answer - a String answer
    //cronstructs a flashcard object 
    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    //@RETURN the Flashcard question 
    public String getQuestion() {
        return question;
    }

    //@RETURN the FlashCard answer 
    public String getAnswer() {
        return answer;
    }

    //@PARAM question
    //sets the question to the param 
    public void setQuestion(String question) {
        this.question = question;
    }

    //@PARAM answer 
    //sets the answer to the param
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    //@RETURN the Flashcard answer 
    public boolean answerFlashcard(String flashcardID, String answer ) {
        return false; // stub method 
    }
    
}
