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
        //Defines variables and objects
        enemy monster = new enemy("", 0, 0, 0);
        player p = new player("", 5);

        //Sets the title of the window
        primaryStage.setTitle("Adam's Game");

        //Creates game title
        Label title = new Label("Adam's Game");
        title.setFont(new Font("Arial", 24));

        //Creates enemy info label
        Label enemyInfo = new Label();
        enemyInfo.setFont(new Font("Arial", 24));

        //Creates player hp info label
        Label playerHP = new Label();
        playerHP.setFont(new Font("Arial", 24));

        //Creates attack button
        Button attack = new Button("Attack");
        attack.setMaxSize(100, 50);

        //Define action events for widgets
        attack.setOnAction(event -> 
            {
                monster.getHit();
                enemyInfo.setText(monster.toString());
                if (monster.getHP() <=0){
                    
                    
                    monster.update("Slime", monster.getMaxHP() + 1, monster.getMaxHP() + 1, monster.getAttack() + 1);
                    enemyInfo.setText(monster.toString());
                } else {
                    p.getHit(monster.getAttack());
                    playerHP.setText(p.getStringHP());
                }
            }
        );
        
        //Creates play button
        Button play = new Button("Play");
        play.setMaxSize(100, 50);

        //Define action events for widgets
        play.setOnAction(event -> 
            {
                play.setVisible(false);
                play.setManaged(false);
                title.setVisible(false);
                title.setManaged(false);
                enemyInfo.setManaged(true);
                enemyInfo.setVisible(true);
                attack.setVisible(true);
                attack.setManaged(true);
                playerHP.setVisible(true);
                playerHP.setManaged(true);
                monster.update("Slime", 1, 1, 1);
                enemyInfo.setText(monster.toString());
                playerHP.setText(p.getStringHP());
            }
        );

        //Creates GridPane layout and sets scene info
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setVgap(8);
        layout.setHgap(10);
        
        //Adding objects to layout
        layout.add(play, 20, 30);
        layout.add(title, 20, 5);
        layout.add(enemyInfo, 20, 5);
        layout.add(attack, 20, 30);
        layout.add(playerHP, 20, 35);

        

        //Initializes the scene
        Scene scene1 = new Scene(layout, 600, 400);
        primaryStage.setScene(scene1);
        primaryStage.show();
        title.setVisible(true);
        title.setManaged(true);
        play.setVisible(true);
        play.setManaged(true);
        enemyInfo.setVisible(false);
        enemyInfo.setManaged(false);
        attack.setVisible(false);
        attack.setManaged(false);
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