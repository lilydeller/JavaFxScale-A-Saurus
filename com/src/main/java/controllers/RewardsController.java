package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.MusicAppFacade;
import model.User;

import java.io.IOException;

public class RewardsController {
    @FXML private Button backButton;
    @FXML private GridPane rewardsGrid;
    @FXML private Label pointsLabel;
    

    private User currentUser;
    private int[] rewardCosts = {50, 200, 300, 500, 1000};  

    @FXML
    public void initialize() {
        currentUser = MusicAppFacade.getInstance().getCurrentUser();
        if (currentUser != null) {
            pointsLabel.setText(currentUser.getDinoPoints() + " Dino Points ⭐");
        }
    }

    private void populateRewards() {
        for (int i = 0; i < rewardCosts.length; i++) {
            VBox rewardBox = createRewardBox(i);
            rewardsGrid.add(rewardBox, i % 2, i / 2);
        }
    }

    private VBox createRewardBox(int index) {
        VBox box = new VBox();
        box.setSpacing(5);

        ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/images/reward_" + index + ".png")));
        icon.setFitHeight(100);
        icon.setFitWidth(100);

        Label costLabel = new Label(rewardCosts[index] + " pts");

        
        if (currentUser.getDinoPoints() >= rewardCosts[index]) {
            
            icon.setOpacity(1.0);
        } else {
          
            icon.setOpacity(0.3);
        }

        box.getChildren().addAll(icon, costLabel);
        return box;
    }

    @FXML
    public void goHome() throws IOException {
        App.setRoot("home");
    }

    @FXML
    public void goFindSong() throws IOException {
        App.setRoot("songsearch");  
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

