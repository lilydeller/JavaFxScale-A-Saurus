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
    @FXML private StackPane frontStack;
    @FXML private StackPane backStack;
    
    
    private String currentChapter;
    private Flashcard currentFlashcard;
    private FlashcardList flashcardList;
    private RotateTransition flipTransition;
    private List<Flashcard> chapterFlashcards;
    private int currentIndex = 0;  

    
    @FXML
    public void initialize() {
        flipTransition = new RotateTransition(Duration.seconds(0.5));
        flipTransition.setCycleCount(1);
    }

    public void setChapter(String chapter) {
        this.currentChapter = chapter;

        FlashcardList flashcardList = FlashcardList.getInstance();
        flashcardList.loadFlashcards();

    
        chapterFlashcards = flashcardList.getFlashcards().stream()
            .filter(f -> f.getChapter().equalsIgnoreCase(currentChapter))
            .collect(Collectors.toList());

        currentIndex = 0;
        loadNextFlashcard();
    }

    private void loadNextFlashcard() {
        if (chapterFlashcards != null && currentIndex < chapterFlashcards.size()) {
            currentFlashcard = chapterFlashcards.get(currentIndex);
            frontLabel.setText(currentFlashcard.getQuestion());
            backLabel.setText(currentFlashcard.getAnswer());

            frontRectangle.setVisible(true);
            backRectangle.setVisible(false);
        } else {
            frontLabel.setText("You've finished this set!");
            backLabel.setText("");
        }
    }

    @FXML
    public void handleClick() {
   
    if (frontRectangle == null || backRectangle == null || flipTransition == null) {
        System.out.println("flipping transition or rectangles are not properly initialized");
        return;
    }


    if (backRectangle.isVisible()) {
    
        flipTransition.setNode(backRectangle);
        flipTransition.setFromAngle(180);
        flipTransition.setToAngle(360);
        flipTransition.setOnFinished(event -> {
            backRectangle.setVisible(false);
            frontRectangle.setVisible(true);
        });
    } else {
     
        flipTransition.setNode(frontRectangle);
        flipTransition.setFromAngle(0);
        flipTransition.setToAngle(180);
        flipTransition.setOnFinished(event -> {
            frontRectangle.setVisible(false);
            backRectangle.setVisible(true);
        });
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

    @FXML
    private void handleNextCard() {
        currentIndex++;
        loadNextFlashcard();
    }
}
