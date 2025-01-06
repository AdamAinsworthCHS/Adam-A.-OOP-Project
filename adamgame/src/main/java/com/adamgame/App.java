package com.adamgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Sets the title of the window
        primaryStage.setTitle("Adam's Game");

        //Creates play button
        Button play = new Button("Play");
        play.setMaxSize(100, 50);

        //Creates a label
        Label title = new Label("Adam's Game");
        title.setFont(new Font("Arial", 24));

        //Creates GridPane layout and sets scene info
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setVgap(8);
        layout.setHgap(10);
        
        //Adding objects to layout
        layout.add(play, 20, 30);
        layout.add(title, 20, 5);

        //Define action events for widgets
        play.setOnAction(event -> 
            {
            play.setVisible(false);
            play.setManaged(false);
            title.setVisible(false);
            title.setManaged(false);
            enemy slime = new enemy("Slime", 1, 1);
            System.out.print(slime.type);
            }
        );

        //Initializes the scene
        Scene scene1 = new Scene(layout, 600, 400);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}