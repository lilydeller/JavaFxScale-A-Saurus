package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.MusicAppFacade;
import model.User;

public class SearchFriendController {
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField usernameField;
    @FXML private Label statusLabel;

    /*
     * adds friend and saves it to friends list
     */
    @FXML
    private void handleAddFriend() {
        MusicAppFacade facade = MusicAppFacade.getInstance();
        User currentUser = facade.getCurrentUser();
        if (currentUser == null) {
            statusLabel.setText("Not logged in.");
            return;
        }

        //grabs data from the textboxes 
        String username = usernameField.getText().trim(); 
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();

        User friend = null;

   
        /*
         * checks if user can actually add friend 
         */
        if (!username.isEmpty()) {
            friend = facade.getUserByUsername(username);
        } else if (!firstName.isEmpty() && !lastName.isEmpty()) {
            friend = facade.getUserByFullName(firstName, lastName);
        }

        if (friend == null) {
            statusLabel.setText("User not found.");
            return;
        }

        if (friend == currentUser) {
            statusLabel.setText("You can't add yourself!");
            return;
        }

        if (currentUser.getFriends().contains(friend)) {
            statusLabel.setText("Already friends.");
            return;
        }

        currentUser.addFriend(friend);
        statusLabel.setText("Friend added!");
        facade.saveAll();
    }

    /*
     * moves back to home 
     */
    @FXML
    private void handleBack() throws Exception {
        App.setRoot("home");
    }

    /*
     * moves back to home 
     */
@FXML
public void goHome() throws IOException {
    App.setRoot("home");
}

/*
 * movse to song search 
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

