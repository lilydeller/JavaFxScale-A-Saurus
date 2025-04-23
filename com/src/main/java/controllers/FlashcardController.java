package controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
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
    @FXML private StackPane frontStack, backStack;

    
    
    private String currentChapter;
    private Flashcard currentFlashcard;
    private FlashcardList flashcardList;
    private RotateTransition flipTransition;
    private List<Flashcard> chapterFlashcards;
    private int currentIndex = 0;  
    private boolean showingFront = true;

    
    @FXML
    public void initialize() {
        frontStack.setRotationAxis(Rotate.Y_AXIS);
        backStack.setRotationAxis(Rotate.Y_AXIS);

        frontStack.setVisible(true);
        backStack.setVisible(false);
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

            frontStack.setVisible(true);
            backStack.setVisible(false);

            frontStack.setRotate(0);
            backStack.setRotate(0);
        } else {
            frontLabel.setText("You've finished this set!");
            backLabel.setText("");
        }
    }

    @FXML
    public void handleClick() {
        StackPane hidePane = showingFront ? frontStack : backStack;
        StackPane showPane = showingFront ? backStack  : frontStack;
        showingFront = !showingFront;

        // 1) rotate the visible side from 0° → 90°
        RotateTransition hideAnim = new RotateTransition(Duration.seconds(0.25), hidePane);
        hideAnim.setFromAngle(0);
        hideAnim.setToAngle(90);
        hideAnim.setOnFinished(evt -> {
            // once it’s edge‑on, hide it and reset its angle
            hidePane.setVisible(false);
            hidePane.setRotate(0);

            // prepare the other pane: set it edge‑on and visible
            showPane.setRotate(-90);
            showPane.setVisible(true);

            // 2) rotate the new pane from –90° → 0°
            RotateTransition showAnim = new RotateTransition(Duration.seconds(0.25), showPane);
            showAnim.setFromAngle(-90);
            showAnim.setToAngle(0);
            showAnim.play();
        });
        hideAnim.play();
    }
   



    @FXML
    private void handleCompleteLesson() {
        User currentUser = MusicAppFacade.getInstance().getCurrentUser();

        if (!currentUser.hasCompletedChapter(currentChapter)) {
            currentUser.addPoints(20);
            currentUser.markChapterComplete(currentChapter);
            MusicAppFacade.getInstance().saveAll();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/lessonfolder.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        App.setRoot(root);
    }

    @FXML
    private void handleNextCard() {
        currentIndex++;
        loadNextFlashcard();
    }

@FXML
public void goHome() throws IOException {
    App.setRoot("home");
}

@FXML
public void goSongs() throws IOException {
    App.setRoot("songssearch");
}

@FXML
public void goLessons() throws IOException {
    App.setRoot("lessonfolder");
}

@FXML
public void goUser() throws IOException {
    App.setRoot("settings");
}

}
