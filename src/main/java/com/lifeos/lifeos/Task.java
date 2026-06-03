package com.lifeos.lifeos;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String dueDate;
    @Enumerated(EnumType.STRING)
    private TaskDurationType durationType;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private Long goalId;


    public Task (){}

    public Task(String title, String dueDate, TaskDurationType durationType){
        this.title = title;
        this.dueDate = dueDate;
        this.durationType = durationType;
        this.status = TaskStatus.PLANNED;
    }

    public void setStatus (TaskStatus status){
        this.status = status;
    }

    public Long getId(){return id;}
    public Long getGoalId() { return goalId; }
    public String getTitle() {return title;}
    public String getDueDate() {return dueDate;}
    public TaskDurationType getDurationType() {return durationType;}
    public TaskStatus getStatus() {return status;}


}
