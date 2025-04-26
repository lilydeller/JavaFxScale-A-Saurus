package controllers;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView; 
import model.MusicAppFacade;
import model.User;

public class LeaderboardController {

    @FXML
    private ListView<String> leaderboardList;

    @FXML
    public void initialize() {
        User currentUser = MusicAppFacade.getInstance().getCurrentUser();
        ArrayList<User> leaderboard = currentUser.getFriends(); 

        leaderboardList.getItems().clear();
        for (int i = 0; i < leaderboard.size(); i++) {
            User user = leaderboard.get(i);
            leaderboardList.getItems().add((i + 1) + ". " + user.getUserName() + " - " + user.getPoints() + " points");
        }
  
        leaderboardList.getItems().add((leaderboard.size() + 1) + ". " + currentUser.getUserName() + " - " + currentUser.getPoints() + " points");
    }

    @FXML
    private void handleAddFriend() throws IOException {
    App.setRoot("searchfriend");  
}

}
