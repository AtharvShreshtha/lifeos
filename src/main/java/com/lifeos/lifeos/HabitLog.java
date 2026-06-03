package com.lifeos.lifeos;

import jakarta.persistence.*;

@Entity
@Table(name = "habitlogs")

public class HabitLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long habitId;
    private String logDate;
    @Enumerated(EnumType.STRING)
    private HabitLogStatus status;

    public HabitLog(){}

    public HabitLog(String logDate, HabitLogStatus status){
        this.logDate = logDate;
        this.status = status;
    }

    public Long getId(){return id;}
    public Long getHabitId(){return habitId;}
    public String getLogDate(){return logDate;}
    public HabitLogStatus getStatus(){return status;}


    public void setHabitId(Long habitId) {
        this.habitId = habitId;
    }
}
