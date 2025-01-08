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
}
