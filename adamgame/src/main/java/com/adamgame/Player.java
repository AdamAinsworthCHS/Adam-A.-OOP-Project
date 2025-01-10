package com.adamgame;

public class player {
    String name = "";
    int hp = 0;
    int maxHP = 0;
    int attack = 0;

    public player(String playerName, int playerHealth, int playerMaxHealth, int playerAttack)
    {
        name = playerName;
        hp = playerHealth;
        maxHP = playerMaxHealth;
        attack = playerAttack;
    }

    public String toString()
    {
        return "player " + "Name: " + name + " Health: " + hp;
    }

    public void getHit(int damage)
    {
        hp -= damage;
    }

    public int getHP()
    {
        return hp;
    }

    public String getStringHP()
    {
        return "Health: " + hp;
    }

    public int getAttack()
    {
        return attack;
    }

    public void hpUp(int increase)
    {
        maxHP += increase;
        hp = maxHP;
    }

    public void attackUp(int increase)
    {
        attack += increase;
    }

    public void fullHeal()
    {
        hp = maxHP;
    }

    public void reset()
    {
        hp = 5;
        maxHP = 5;
        attack = 1;
    }
}
