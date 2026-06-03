package com.lifeos.lifeos;

public class HabitStats {
    private int currentStreak;
    private int longestStreak;
    private int consistency;

    public HabitStats (int currentStreak, int longestStreak, int consistency){
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
        this.consistency = consistency;
    }

    public int getCurrentStreak(){ return currentStreak;}
    public int getLongestStreak(){ return longestStreak;}
    public int getConsistency(){ return consistency;}
}
