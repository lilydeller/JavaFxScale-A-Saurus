package controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

import controllers.App;

public class LessonFolderController {
    
    @FXML
    private void handleChapter1() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/flashcard.fxml"));
    Parent root = loader.load();
    
    FlashcardController controller = loader.getController();
    controller.setChapter("chapter-1");

    App.setRoot(root);
}


@FXML
private void handleChapter2() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/flashcard.fxml"));
    Parent root = loader.load();
    
    FlashcardController controller = loader.getController();
    controller.setChapter("chapter-2");

    App.setRoot(root);
}

@FXML
private void handleChapter3() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/flashcard.fxml"));
    Parent root = loader.load();
    
    FlashcardController controller = loader.getController();
    controller.setChapter("chapter-3");

    App.setRoot(root);
}


@FXML
private void handleChapter4() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/flashcard.fxml"));
    Parent root = loader.load();
    
    FlashcardController controller = loader.getController();
    controller.setChapter("chapter-4");

    App.setRoot(root);
}


@FXML
private void handleChapter5() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/flashcard.fxml"));
    Parent root = loader.load();
    
    FlashcardController controller = loader.getController();
    controller.setChapter("chapter-5");

    App.setRoot(root);
}


@FXML
private void handleChapter6() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/scaleasaurus/flashcard.fxml"));
    Parent root = loader.load();
    
    FlashcardController controller = loader.getController();
    controller.setChapter("chapter-6");

    App.setRoot(root);
}

}