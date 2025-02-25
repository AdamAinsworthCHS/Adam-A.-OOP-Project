package com.adamgame;

import java.io.IOException;
import java.util.Random;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Defines variables and objects
        enemy monster = new enemy("", 0, 0, 0);
        player p = new player("", 5, 5, 1);
        Random rand = new Random();
        controller control = new controller(1, 0);
        item i = new item(0, 0, 0);

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

        //Creates upgrade choice label
        Label levelupChoice = new Label("Choose reward");
        levelupChoice.setFont(new Font("Arial", 24));

        //Creates hp up button
        Button hpUp = new Button("+1 HP");
        hpUp.setMaxSize(100, 50);

        //Creates attack up button
        Button attackUp = new Button("+1 Attack");
        attackUp.setMaxSize(100, 50);

        //Creates random item button
        Button randomReward = new Button("Mystery Box");
        randomReward.setMaxSize(100, 50);

        //Creates play button
        Button play = new Button("Play");
        play.setMaxSize(100, 50);

        //Code for pressing the attack up button
        attackUp.setOnAction(event -> 
            {
                p.attackUp(1);
                p.fullHeal();
                levelupChoice.setVisible(false);
                levelupChoice.setManaged(false);
                hpUp.setVisible(false);
                hpUp.setManaged(false);
                attackUp.setVisible(false);
                attackUp.setManaged(false);
                randomReward.setVisible(false);
                randomReward.setManaged(false);
                enemyInfo.setManaged(true);
                enemyInfo.setVisible(true);
                attack.setVisible(true);
                attack.setManaged(true);
                playerHP.setVisible(true);
                playerHP.setManaged(true);
                monster.update(control.randomEnemy(rand.nextInt(4)), control.scaling());
                enemyInfo.setText(monster.toString());
                playerHP.setText(p.getStringHP());
            }
        );

        //Code for pressing the hp up button
        hpUp.setOnAction(event -> 
            {
                p.hpUp(1);
                levelupChoice.setVisible(false);
                levelupChoice.setManaged(false);
                hpUp.setVisible(false);
                hpUp.setManaged(false);
                attackUp.setVisible(false);
                attackUp.setManaged(false);
                randomReward.setVisible(false);
                randomReward.setManaged(false);
                enemyInfo.setManaged(true);
                enemyInfo.setVisible(true);
                attack.setVisible(true);
                attack.setManaged(true);
                playerHP.setVisible(true);
                playerHP.setManaged(true);
                monster.update(control.randomEnemy(rand.nextInt(4)), control.scaling());
                enemyInfo.setText(monster.toString());
                playerHP.setText(p.getStringHP());
            }
        ); 

        //Code for pressing the mystery box button
        randomReward.setOnAction(event -> 
            {
                levelupChoice.setVisible(false);
                levelupChoice.setManaged(false);
                hpUp.setVisible(false);
                hpUp.setManaged(false);
                attackUp.setVisible(false);
                attackUp.setManaged(false);
                randomReward.setVisible(false);
                randomReward.setManaged(false);
                enemyInfo.setManaged(true);
                enemyInfo.setVisible(true);
                attack.setVisible(true);
                attack.setManaged(true);
                playerHP.setVisible(true);
                playerHP.setManaged(true);
                i.update(rand.nextInt(4), rand.nextInt(4), (rand.nextInt(3) + 2));
                p.hpUp(i.getHP());
                p.attackUp(i.getAttack());
                monster.update(control.randomEnemy(rand.nextInt(4)), control.scaling());
                enemyInfo.setText(monster.toString());
                playerHP.setText(p.getStringHP());
            }
        ); 
        
        //Code for pressing the attack button
        attack.setOnAction(event -> 
            {
                monster.getHit(p.getAttack());
                enemyInfo.setText(monster.toString());
                if (monster.getHP() <=0){
                    if (i.getUses() > 0){
                        i.removeUse();
                        if (i.getUses() == 0){
                            p.statDecrease("HP", i.getHPData());
                            p.statDecrease("Attack", i.getAttackData());
                            i.update(0, 0, 0);
                        }
                    }
                    levelupChoice.setVisible(true);
                    levelupChoice.setManaged(true);
                    hpUp.setVisible(true);
                    hpUp.setManaged(true);
                    attackUp.setVisible(true);
                    attackUp.setManaged(true);
                    randomReward.setVisible(true);
                    randomReward.setManaged(true);
                    enemyInfo.setManaged(false);
                    enemyInfo.setVisible(false);
                    attack.setVisible(false);
                    attack.setManaged(false);
                    playerHP.setVisible(false);
                    playerHP.setManaged(false);
                } else {
                    p.getHit(monster.getAttack());
                    if (p.getHP() < 1){
                        title.setVisible(true);
                        title.setManaged(true);
                        play.setVisible(true);
                        play.setManaged(true);
                        enemyInfo.setVisible(false);
                        enemyInfo.setManaged(false);
                        attack.setVisible(false);
                        attack.setManaged(false);
                        playerHP.setVisible(false);
                        playerHP.setManaged(false);
                        levelupChoice.setVisible(false);
                        levelupChoice.setManaged(false);
                        hpUp.setVisible(false);
                        hpUp.setManaged(false);
                        attackUp.setVisible(false);
                        attackUp.setManaged(false);
                        randomReward.setVisible(false);
                        randomReward.setManaged(false);
                        control.resetScaling();
                        p.reset();
                    }
                    playerHP.setText(p.getStringHP());
                }
            }
        );
        

        //Code for pressing the play button
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
                monster.update(control.randomEnemy(0), control.scaling());
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
        layout.add(levelupChoice, 20, 5);
        layout.add(attackUp, 10, 30);
        layout.add(hpUp, 15, 30);
        layout.add(randomReward, 20, 30);

        

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
        levelupChoice.setVisible(false);
        levelupChoice.setManaged(false);
        hpUp.setVisible(false);
        hpUp.setManaged(false);
        attackUp.setVisible(false);
        attackUp.setManaged(false);
        randomReward.setVisible(false);
        randomReward.setManaged(false);
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