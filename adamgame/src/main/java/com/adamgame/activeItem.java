package com.adamgame;

public class activeItem {
    String type = "";
    boolean used = false;

    public activeItem(String itemType, boolean itemUsed)
    {
        type = itemType;
        used = itemUsed;
    }

    public String getType()
    {
        return type;
    }

    public boolean getUsed()
    {
        return used;
    }

    public void changeStatus(boolean newUsed)
    {
        used = newUsed;
    }

    public void update(String newType, boolean newStatus)
    {
        type = newType;
        used = newStatus;
    }

    public void randomItem(int randomValue)
    {
        if (randomValue == 0)
        {
            type = "HealPotion";
            used = false;
        }
        else if (randomValue == 1)
        {
            type = "Bomb";
            used = false;
        }
    }
}
