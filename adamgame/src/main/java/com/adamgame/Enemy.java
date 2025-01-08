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

    
    public void update(String newType, int newHealth, int newMaxHP, int newAttack)
    {
        type = newType;
        hp = newHealth;
        attack = newAttack;
        maxHP = newMaxHP;
    }
    
    public String toString()
    {
        return type + ": " + hp + " HP";
    }

    public void getHit()
    {
        hp -= 1;
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
