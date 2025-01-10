package com.adamgame;

public class controller {
    int scalingFactor = 1;
    int scalingStage = 0;

    public controller(int scaleFactor, int scaleStage)
    {
        scalingFactor = scaleFactor;
        scalingStage = 0;
    }

    public String randomEnemy(int randEnemy)
    {
        if (randEnemy == 0){
            return "Slime";
        } else if (randEnemy == 1){
            return "Bat";
        } else if (randEnemy == 2){
            return "Spider";
        } else {
            return "Golem";
        }
    }

    public int scaling()
    {
        scalingStage += 1;
        if (scalingStage == 5){
            scalingStage = 0;
            scalingFactor += 1;
            return scalingFactor;
        } else {
            return scalingFactor;
        }
    }

    public void resetScaling()
    {
        scalingFactor = 1;
        scalingStage = 0;
    }
}
