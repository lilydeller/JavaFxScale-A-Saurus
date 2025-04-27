package controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

import controllers.App;

public class LessonFolderController {
    
    /*
     * loads flashcards for chapter 1
     */
    @FXML
    private void handleChapter1() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/flashcard.fxml"));
    Parent root = loader.load();
    
    FlashcardController controller = loader.getController();
    controller.setChapter("chapter-1");

    App.setRoot(root);
}


/*
 * loads flashcards for chapter 2 
 */
@FXML
private void handleChapter2() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/flashcard.fxml"));
    Parent root = loader.load();
    
    FlashcardController controller = loader.getController();
    controller.setChapter("chapter-2");

    App.setRoot(root);
}

/*
 * loads flashcards for chapter 3 
 */
@FXML
private void handleChapter3() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/flashcard.fxml"));
    Parent root = loader.load();
    
    FlashcardController controller = loader.getController();
    controller.setChapter("chapter-3");

    App.setRoot(root);
}

/*
 * loads flashcards for chapter 4
 */
@FXML
private void handleChapter4() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/flashcard.fxml"));
    Parent root = loader.load();
    
    FlashcardController controller = loader.getController();
    controller.setChapter("chapter-4");

    App.setRoot(root);
}


/*
 * loads flashcards for chapter 5
 */
@FXML
private void handleChapter5() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/flashcard.fxml"));
    Parent root = loader.load();
    
    FlashcardController controller = loader.getController();
    controller.setChapter("chapter-5");

    App.setRoot(root);
}

/*
 * loads flashcards for chapter 6
 */
@FXML
private void handleChapter6() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/flashcard.fxml"));
    Parent root = loader.load();
    
    FlashcardController controller = loader.getController();
    controller.setChapter("chapter-6");

    App.setRoot(root);
}

/*
 * moves back to home 
 */
@FXML
public void goHome() throws IOException {
    App.setRoot("home");
}

/*
 * moves to song search 
 */
@FXML
public void goSongs() throws IOException {
    App.setRoot("songssearch");
}

/*
 * moves to lesson folder 
 */
@FXML
public void goLessons() throws IOException {
    App.setRoot("lessonfolder");
}

/*
 * moves to settings
 */
@FXML
public void goUser() throws IOException {
    App.setRoot("settings");
}

}