package controllers;
import controllers.App;
import javafx.event.ActionEvent;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PianoController {

    @FXML private Button keyC, keyD, keyE, keyF, keyG, keyA, keyB;
    @FXML private Button btnBack;

    @FXML
    private void handleKeyPress(javafx.event.ActionEvent e) {
        Button pressedKey = (Button) e.getSource();

      
        if (pressedKey.getStyleClass().contains("highlighted")) {
            pressedKey.getStyleClass().remove("highlighted");
        } else {
            pressedKey.getStyleClass().add("highlighted");
        }

    
    }

    @FXML
     private void goToPiano() throws Exception {
        App.setRoot("piano");
    }


    @FXML
    private void handleBack() throws Exception {
        App.setRoot("home");  
    }
}
