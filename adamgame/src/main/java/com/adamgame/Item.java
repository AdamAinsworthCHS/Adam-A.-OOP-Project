package com.adamgame;

public class item {
    int hpUp = 0;
    int attackUp = 0;
    int uses = 0;
    int hpData;
    int attackData;

    public item(int hpFactor, int attackFactor, int itemUses)
    {
        hpUp = hpFactor;
        attackUp = attackFactor;
        uses = itemUses;
    }

    public String toString()
    {
        return "item ";
    }

    public String randomType(int randInt)
    {
        if (randInt == 0){
            return "HP";
        } else {
            return "Attack";
        }
    }

    public String removeUse()
    {
        uses -= 1;
        if (uses < 1){
            return "Item Expired";
        } else {
            return "Item Fine";
        }
    }

    public void update(int hpAdd, int attackAdd, int usesAdd)
    {
        hpUp = hpAdd;
        attackUp = attackAdd;
        uses = usesAdd;
        hpData += hpAdd;
        attackData += attackAdd;
    }

    public int getHP()
    {
        return hpUp;
    }
    
    public int getAttack()
    {
        return attackUp;
    }

    public int getUses()
    {
        return uses;
    }

    public int getHPData()
    {
        return hpData;
    }
    
    public int getAttackData()
    {
        return attackData;
    }
}
