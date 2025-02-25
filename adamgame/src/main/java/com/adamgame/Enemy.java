package com.adamgame;

public class enemy {
    String type = "";
    int hp = 0;
    int attack = 0;
    int maxHP = 0;

    public enemy(String enemyType, int enemyHealth, int enemyMaxHealth, int enemyAttack)
    {
        type = enemyType;
        hp = enemyHealth;
        attack = enemyAttack;
        maxHP = enemyMaxHealth;
    }

    public void update(String newType, int scaling)
    {
        if (newType == "Slime"){
            type = "Slime";
            hp = 1 * scaling;
            attack = 1 * scaling;
            maxHP = 1 * scaling;
        } else if (newType == "Bat"){
            type = "Bat";
            hp = 1 * scaling;
            attack = 2 * scaling;
            maxHP = 1 * scaling;
        } else if (newType == "Spider"){
            type = "Spider";
            hp = 2 * scaling;
            attack = 2 * scaling;
            maxHP = 2 * scaling;
        } else { 
            type = "Golem";
            hp = 4 * scaling;
            attack = 2 * scaling;
            maxHP = 4 * scaling;
        }
        
    }
    
    public String toString()
    {
        return type + ": " + hp + " HP";
    }

    public void getHit(int damage)
    {
        hp -= damage;
    }

    public int getHP()
    {
        return hp;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getMaxHP()
    {
        return maxHP;
    }
}
