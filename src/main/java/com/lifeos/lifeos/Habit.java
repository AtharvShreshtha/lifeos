package com.lifeos.lifeos;

import jakarta.persistence.*;

@Entity
@Table(name="habits")

public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;
    private String frequency;
    private int targetDaysPerWeek;
    private int graceDaysPerWeek;

    public Habit(){}

    public Habit(String title, String category, String frequency, int targetDaysPerWeek){
        this.title = title;
        this.category = category;
        this.frequency = frequency;
        this.graceDaysPerWeek = 1;

        if(frequency.equals("daily")){
            this.targetDaysPerWeek = 7;
        } else if (frequency.equals("weekdays")) {
            this.targetDaysPerWeek = 5;
        }else{
            this.targetDaysPerWeek = targetDaysPerWeek;
        }
    }
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getFrequency() { return frequency; }
    public int getTargetDaysPerWeek() { return targetDaysPerWeek; }
    public int getGraceDaysPerWeek() { return graceDaysPerWeek; }

}
