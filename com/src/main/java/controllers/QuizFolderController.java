package controllers;
import javafx.fxml.FXML;
import controllers.App;

public class QuizFolderController {
    
    @FXML private void handleChapter1() throws Exception {
        App.setRoot("flashcards_ch1");
    }

    @FXML private void handleChapter2() throws Exception {
        App.setRoot("flashcards_ch2");
    }

    @FXML private void handleChapter3() throws Exception {
        App.setRoot("flashcards_ch3");
    }

    @FXML private void handleChapter4() throws Exception {
        App.setRoot("flashcards_ch4");
    }

    @FXML private void handleChapter5() throws Exception {
        App.setRoot("flashcards_ch5");
    }

    @FXML private void handleChapter6() throws Exception {
        App.setRoot("flashcards_ch6");
    }
}