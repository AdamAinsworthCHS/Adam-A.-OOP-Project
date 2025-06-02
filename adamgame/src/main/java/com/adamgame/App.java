package com.adamgame;

import java.io.IOException;
import java.util.Random;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
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
        activeItem a = new activeItem("No Item", true);

        Font upheavalTitle = Font.loadFont(getClass().getResource("/fonts/upheavtt.ttf").toExternalForm(), 50);
        Font upheavalLarge = Font.loadFont(getClass().getResource("/fonts/upheavtt.ttf").toExternalForm(), 36);
        Font upheavalMedium = Font.loadFont(getClass().getResource("/fonts/upheavtt.ttf").toExternalForm(), 24);
        Font upheavalSmall = Font.loadFont(getClass().getResource("/fonts/upheavtt.ttf").toExternalForm(), 12);
        
        //Creates GridPanes for each screen and sets info
        GridPane titleScreen = new GridPane();
        titleScreen.setPadding(new Insets(10, 10, 10, 10));
        titleScreen.setVgap(8);
        titleScreen.setHgap(10);

        GridPane encounterScreen = new GridPane();
        encounterScreen.setPadding(new Insets(10, 10, 10, 10));
        encounterScreen.setVgap(8);
        encounterScreen.setHgap(10);

        GridPane levelScreen = new GridPane();
        levelScreen.setPadding(new Insets(10, 10, 10, 10));
        levelScreen.setVgap(8);
        levelScreen.setHgap(10);

        //Adds the scenes
        Scene scene1 = new Scene(titleScreen, 600, 400);
        Scene scene2 = new Scene(encounterScreen, 600, 400);
        Scene scene3 = new Scene(levelScreen, 600, 400);
        
        //Sets the title of the window
        primaryStage.setTitle("Adam's Game");

        //Creates game title
        Label title = new Label("Adam's Game");
        title.setFont(upheavalTitle);
        title.setTextAlignment(TextAlignment.CENTER);

        //Creates enemy info label
        Label enemyInfo = new Label();
        enemyInfo.setFont(upheavalLarge);

        //Creates player hp info label
        Label playerHP = new Label();
        playerHP.setFont(upheavalMedium);

        //Creates attack button
        Button attack = new Button("Attack");
        attack.setMaxSize(100, 50);
        attack.setFont(upheavalSmall);

        //Creates upgrade choice label
        Label levelupChoice = new Label("Choose reward");
        levelupChoice.setFont(upheavalLarge);


        //Creates hp up button
        Button hpUp = new Button("+1 HP");
        hpUp.setMaxSize(100, 50);
        hpUp.setFont(upheavalSmall);

        //Creates attack up button
        Button attackUp = new Button("+1 Attack");
        attackUp.setMaxSize(100, 50);
        attackUp.setFont(upheavalSmall);

        //Creates random stat button
        Button randomReward = new Button("Random Stat");
        randomReward.setMaxSize(100, 50);
        randomReward.setFont(upheavalSmall);

        //Creates random item button
        Button itemReward = new Button("Random Item");
        itemReward.setMaxSize(100, 50);
        itemReward.setFont(upheavalSmall);

        //Creates use item button
        Button useItem = new Button("No Item");
        useItem.setMaxSize(150, 100);
        useItem.setFont(upheavalSmall);

        //Creates play button
        Button play = new Button("Play");
        play.setMaxSize(100, 50);
        play.setFont(upheavalSmall);

        //Code for pressing the attack up button. Increases the player's attack permanently.
        attackUp.setOnAction(event -> 
            {
                p.attackUp(1);
                p.fullHeal();
                primaryStage.setScene(scene2);
                primaryStage.show();
                monster.update(control.randomEnemy(rand.nextInt(4)), control.scaling());
                enemyInfo.setText(monster.toString());
                playerHP.setText(p.getStringHP());
                useItem.setText("Use " + a.type);
                
            }
        );

        //Code for pressing the hp up button. Increases the player's HP permanently.
        hpUp.setOnAction(event -> 
            {
                p.hpUp(1);
                if (p.trueMaxHP > 0)
                {
                    p.addSaveHP(1);
                }
                primaryStage.setScene(scene2);
                primaryStage.show();
                monster.update(control.randomEnemy(rand.nextInt(4)), control.scaling());
                enemyInfo.setText(monster.toString());
                playerHP.setText(p.getStringHP());
                useItem.setText("Use " + a.type);
            }
        ); 

        //Code for pressing the random stat button. Gives the player a randomized hp and attack buff that expires after a random amount of encounters.
        randomReward.setOnAction(event -> 
            {
                primaryStage.setScene(scene2);
                primaryStage.show();
                if (i.hpUp == 0)
                {
                    p.saveHP(p.getMaxHP());
                }
                i.update(rand.nextInt(4), rand.nextInt(4), (rand.nextInt(3) + 2));
                p.hpUp(i.getHP());
                p.attackUp(i.getAttack());
                p.fullHeal();
                monster.update(control.randomEnemy(rand.nextInt(4)), control.scaling());
                enemyInfo.setText(monster.toString());
                playerHP.setText(p.getStringHP());
                useItem.setText("Use " + a.type);
            }
        );

        //Code for pressing the random item button. Gives the player a randomized hp and attack buff that expires after a random amount of encounters.
        itemReward.setOnAction(event -> 
            {
                if (a.used == true)
                {
                    p.fullHeal();
                    a.randomItem(rand.nextInt(2));
                    primaryStage.setScene(scene2);
                    primaryStage.show();
                    monster.update(control.randomEnemy(rand.nextInt(4)), control.scaling());
                    enemyInfo.setText(monster.toString());
                    playerHP.setText(p.getStringHP());
                    useItem.setText("Use " + a.type);
                }
            }
        );
        
        //Code for pressing the attack button. Deals damage to the enemy based on your attack, enemy attacks after. If either die it will take the player to a new screen.
        attack.setOnAction(event -> 
            {
                monster.getHit(p.getAttack());
                enemyInfo.setText(monster.toString());
                if (monster.getHP() <=0){
                    if (i.getUses() > 0){
                        i.removeUse();
                        if (i.getUses() == 0){
                            p.fullHeal();
                            p.setMaxHP(p.getSavedHP());
                            p.statDecrease("Attack", i.getAttackData());
                            i.update(0, 0, 0);
                        }
                    }
                    primaryStage.setScene(scene3);
                    primaryStage.show();
                } else {
                    p.getHit(monster.getAttack());
                    if (p.getHP() < 1){
                        primaryStage.setScene(scene1);
                        primaryStage.show();
                        control.resetScaling();
                        p.reset();
                    }
                    playerHP.setText(p.getStringHP());
                }
            }
        );

        //Code for pressing the use item button.
        useItem.setOnAction(event -> 
            {
                if (a.used == false)
                {
                    if (a.type == "HealPotion")
                    {
                        p.fullHeal();
                        playerHP.setText(p.getStringHP());
                        a.update("No Item", true);
                        useItem.setText("Use " + a.type);
                    }
                    if (a.type == "Bomb")
                    {
                        a.update("No Item", true);
                        useItem.setText("Use " + a.type);
                        if (i.getUses() > 0){
                            i.removeUse();
                            if (i.getUses() == 0){
                                p.fullHeal();
                                p.setMaxHP(p.getSavedHP());
                                p.statDecrease("Attack", i.getAttackData());
                                i.update(0, 0, 0);
                            }
                        }
                        primaryStage.setScene(scene3);
                        primaryStage.show();
                    }
                    else
                    {
                        a.update("No Item", true);
                        useItem.setText("Use " + a.type);
                    }
                }
            }
        );
        

        //Code for pressing the play button, spawns a basic slime to fight
        play.setOnAction(event -> 
            {
                primaryStage.setScene(scene2);
                primaryStage.show();
                monster.update(control.randomEnemy(0), control.scaling());
                enemyInfo.setText(monster.toString());
                playerHP.setText(p.getStringHP());
            }
        );
        
        //Adding objects to gridpanes as well as adjusting their alignment and other gridpane properties
        titleScreen.setAlignment(Pos.CENTER);
        titleScreen.add(title, 2, 1);
        titleScreen.setHalignment(title, HPos.CENTER);
        titleScreen.add(play, 2, 10, 1, 5);
        titleScreen.setHalignment(play, HPos.CENTER);
        titleScreen.setStyle("-fx-background-color: CornflowerBlue;");
        
        encounterScreen.setAlignment(Pos.CENTER);
        encounterScreen.add(enemyInfo, 2, 1, 5, 1);
        encounterScreen.add(attack, 1, 20, 5, 1);
        encounterScreen.setHalignment(attack, HPos.CENTER);
        encounterScreen.add(useItem, 4, 20, 15, 1);
        encounterScreen.setHalignment(useItem, HPos.CENTER);
        encounterScreen.add(playerHP, 2, 16, 10, 1);
        encounterScreen.setHalignment(playerHP, HPos.CENTER);
        encounterScreen.setStyle("-fx-background-color: gray;");
        
        levelScreen.setAlignment(Pos.CENTER);
        levelScreen.add(levelupChoice, 3, 1, 10, 5);
        levelScreen.setHalignment(levelupChoice, HPos.CENTER);
        levelScreen.add(attackUp, 1, 15, 1, 5);
        levelScreen.setHalignment(attackUp, HPos.LEFT);
        levelScreen.add(hpUp, 4, 15, 1, 5);
        levelScreen.setHalignment(hpUp, HPos.CENTER);
        levelScreen.add(randomReward, 6, 15, 1, 5);
        levelScreen.setHalignment(randomReward, HPos.RIGHT);
        levelScreen.setStyle("-fx-background-color: Gold;");
        levelScreen.add(itemReward, 7, 15, 1, 5);
        levelScreen.setHalignment(itemReward, HPos.RIGHT);
        

        

        //Initializes the scene
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