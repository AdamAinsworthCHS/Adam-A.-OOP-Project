package com.adamgame;

public class item {
    String type = "";
    int uses = 0;

    public item(String itemType, int itemUses)
    {
        type = itemType;
        uses = itemUses;
    }

    public String toString()
    {
        return "item " + "Type: " + type + " Uses: " + uses;
    }

    public String randomType(int randInt)
    {
        if (randInt == 0){
            return "HP";
        } else {
            return "Attack";
        }
    }

    public int randomAmount(int randInt)
    {
        if (randInt == 0){
            return 0;
        } else if (randInt == 1){
            return 1;
        } else if (randInt == 2){
            return 2;
        } else {
            return 3;
        }
    }
}
