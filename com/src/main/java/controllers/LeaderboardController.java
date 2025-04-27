package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import model.MusicAppFacade;
import model.User;

public class LeaderboardController {

    

    @FXML
    private VBox leaderboardVBox;

    @FXML
    public void initialize() {
        populateLeaderboard();
    }

    @FXML
    private void populateLeaderboard() {
        leaderboardVBox.getChildren().clear();
        List<String> leaderboardEntries = getLeaderboardData(); 
    
        for (String entry : leaderboardEntries) {
            VBox entryBox = new VBox();
            entryBox.setStyle("-fx-background-color: #ddfd98; -fx-background-radius: 10; -fx-padding: 10;");
            entryBox.setPrefWidth(300);
    
            Label entryLabel = new Label(entry); // ← just entry, no "rank + entry"
            entryLabel.setStyle("-fx-background-color: white; -fx-padding: 8; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #245744; -fx-background-radius: 5;");
            entryLabel.setMaxWidth(Double.MAX_VALUE);
            entryLabel.setAlignment(javafx.geometry.Pos.CENTER);
    
            entryBox.getChildren().add(entryLabel);
            leaderboardVBox.getChildren().add(entryBox);
        }
    }
    

private List<String> getLeaderboardData() {
    List<String> entries = new ArrayList<>();
    
    User currentUser = MusicAppFacade.getInstance().getCurrentUser();
    ArrayList<User> friends = currentUser.getFriends();

    
    ArrayList<User> leaderboardUsers = new ArrayList<>(friends);
    leaderboardUsers.add(currentUser);

   
    leaderboardUsers.sort(Comparator.comparingInt(User::getPoints).reversed());

    int rank = 1;
    for (User user : leaderboardUsers) {
        entries.add(rank + ". " + user.getUserName() + " - " + user.getPoints() + " points");
        rank++;
    }

    return entries;
}


    @FXML
    private void handleAddFriend() throws IOException {
    App.setRoot("searchfriend");  
}

}
