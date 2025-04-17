package controllers;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.util.Duration;
import model.Flashcard;
import model.FlashcardList;

public class FlashcardController {

    @FXML private Rectangle frontRectangle;
    @FXML private Rectangle backRectangle;
    @FXML private Label frontLabel;
    @FXML private Label backLabel;
    
    private Flashcard currentFlashcard;
    private FlashcardList flashcardList;
    private RotateTransition flipTransition;

    
    @FXML
    public void initialize() {
        flashcardList = FlashcardList.getInstance();
        flashcardList.loadFlashcards();
        loadNextFlashcard();
        
        
        flipTransition = new RotateTransition(Duration.seconds(0.5), frontRectangle);
        flipTransition.setFromAngle(0);
        flipTransition.setToAngle(180);
        flipTransition.setCycleCount(1);
    }

    
    public void loadNextFlashcard() {
        if (!flashcardList.getFlashcards().isEmpty()) {
            currentFlashcard = flashcardList.getFlashcards().get(0); 
            frontLabel.setText(currentFlashcard.getQuestion());
            backLabel.setText(currentFlashcard.getAnswer());
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
}

