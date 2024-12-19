package com.adamgame;

public class enemy {
    String type = "";
    int HP = 0;
    int attack = 0;

    public enemy(String enemyType, int enemyHealth, int enemyAttack)
    {
        type = enemyType;
        HP = enemyHealth;
        attack = enemyAttack;
    }
}
