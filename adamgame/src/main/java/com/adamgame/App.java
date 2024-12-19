package com.adamgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

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

        //Creates Second Button
        Button button2 = new Button("button2");
        button2.setMaxSize(100, 50);

        //Creates GridPane layout and sets scene info
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setVgap(8);
        layout.setHgap(10);
        
        //Adding objects to layout
        layout.add(play, 0, 0);
        layout.add(button2, 0, 1);

        //Define action events for widgets
        play.setOnAction(event -> 
            System.out.println("BUTTON WORKS")
        );

        button2.setOnAction(event -> 
            System.out.println("BUTTON 2")
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