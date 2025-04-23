package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DataLoader;
import model.User;
import model.UserList;

import java.io.IOException;
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
         DataLoader.getInstance().loadAll();
         /*
          * test for if users are actually loaded correct 
          */
        System.out.println("Users loaded:");
        for (User user : UserList.getInstance().getUsers()) {
        System.out.println("- " + user.getUserName() + " (" + user.getEmail() + ")");
    }
        scene = new Scene(loadFXML("login"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/scaleasaurus/" + fxml + ".fxml"));
        scene.setRoot(loader.load());
    }
    

    public static void setRoot(Parent root) {
        scene.setRoot(root);
    }
    

    private static Parent loadFXML(String fxml) throws IOException {
    
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/scaleasaurus/" + fxml + ".fxml"));


        return fxmlLoader.load();
    }
    

    public static void main(String[] args) {
        launch();
    }

}