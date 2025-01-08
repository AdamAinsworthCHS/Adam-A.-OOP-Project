package com.adamgame;

public class player {
    String name = "";
    int hp = 0;

    public player(String playerName, int playerHealth)
    {
        name = playerName;
        hp = playerHealth;
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
}
