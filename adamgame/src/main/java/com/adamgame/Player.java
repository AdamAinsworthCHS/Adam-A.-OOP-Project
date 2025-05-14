package com.adamgame;

public class player {
    String name = "";
    int hp = 0;
    int maxHP = 0;
    int attack = 0;
    int trueMaxHP;

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

    public int getMaxHP()
    {
        return maxHP;
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

    public void statIncrease(String increaseType, int increaseAmount)
    {
        if (increaseType == "HP"){
            maxHP += increaseAmount;
            hp = maxHP;
        } else {
            attack += increaseAmount;
        }
    }

    public void statDecrease(String decreaseType, int decreaseAmount)
    {
        if (decreaseType == "HP"){
            maxHP -= decreaseAmount;
            hp = maxHP;
        } else {
            attack -= decreaseAmount;
        }
    }

    public void saveHP(int savedAmount)
    {
        trueMaxHP = savedAmount;
    }

    public void addSaveHP(int savedAmount)
    {
        trueMaxHP += savedAmount;
    }

    public int getSavedHP()
    {
        return trueMaxHP;
    }

    public void setMaxHP(int amountSet)
    {
        maxHP = amountSet;
    }
}
