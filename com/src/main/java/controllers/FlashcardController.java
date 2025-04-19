package controllers;

import java.util.List;
import java.util.stream.Collectors;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.util.Duration;
import model.Flashcard;
import model.FlashcardList;
import model.MusicAppFacade;
import model.User;

public class FlashcardController {

    @FXML private Rectangle frontRectangle;
    @FXML private Rectangle backRectangle;
    @FXML private Label frontLabel;
    @FXML private Label backLabel;
    
    private String currentChapter;
    private Flashcard currentFlashcard;
    private FlashcardList flashcardList;
    private RotateTransition flipTransition;

    
    @FXML
    public void initialize() {
        flashcardList = FlashcardList.getInstance();
        flashcardList.loadFlashcards();
        
        
        flipTransition = new RotateTransition(Duration.seconds(0.5), frontRectangle);
        flipTransition.setFromAngle(0);
        flipTransition.setToAngle(180);
        flipTransition.setCycleCount(1);
    }

    public void setChapter(String chapter) {
        this.currentChapter = chapter;
        loadNextFlashcard();
    }
    

    private void loadNextFlashcard() {
        List<Flashcard> chapterFlashcards = flashcardList.getFlashcards().stream()
    .filter(f -> f.getChapter().equals(currentChapter))
    .collect(Collectors.toList());

    if (!chapterFlashcards.isEmpty()) {
    currentFlashcard = chapterFlashcards.get(0); 
    frontLabel.setText(currentFlashcard.getQuestion());
    backLabel.setText(currentFlashcard.getAnswer());
    }
    else {
        frontLabel.setText("No flashcards found for this chapter");
        backLabel.setText("");
    }
}  

    
    @FXML
    public void handleClick() {
        
        if (backRectangle.isVisible()) {
            flipTransition.setFromAngle(180);
            flipTransition.setToAngle(360);
            backRectangle.setVisible(false);
            frontRectangle.setVisible(true);
        } else {
            flipTransition.setFromAngle(0);
            flipTransition.setToAngle(180);
            backRectangle.setVisible(true);
            frontRectangle.setVisible(false);
        }
        flipTransition.play();
    }
    @FXML
private void handleCompleteLesson() {
    User currentUser = MusicAppFacade.getInstance().getCurrentUser();

    if (!currentUser.hasCompletedChapter(currentChapter)) {
        currentUser.addPoints(20);
        currentUser.markChapterComplete(currentChapter);
        MusicAppFacade.getInstance().saveAll();
    }
}

}

