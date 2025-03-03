// package com.model;
public class LevelSystem implements GamificationSystem {
    private int currentLevel;
    private int maxLevel;

    public Levelsystem(int maxLevel) {
        this.currentLevel = 1;
        this.maxLevel = maxLevel;
    }

    public void increaseLevel() {

    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override 
    public void updateProgress() {

    }

    @Override 
    public void displayRewards() {
        
    }
    
}
