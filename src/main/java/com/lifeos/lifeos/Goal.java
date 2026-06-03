package com.lifeos.lifeos;

import jakarta.persistence.*;

@Entity
@Table(name="goals")

public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String deadline;
    @Enumerated(EnumType.STRING)
    private GoalStatus status;

    public Goal (){}

    public Goal (String title, String description, String deadline){
        this.title = title;
        this.description = description;
        this. deadline = deadline;
        this.status = GoalStatus.ACTIVE;
    }

    public void setStatus(GoalStatus status) { this.status = status; }

    public Long getId() { return id;}
    public String getTitle() { return title;}
    public String getDescription() { return description;}
    public String getDeadline() { return deadline;}
    public GoalStatus getStatus() {return status;}


}
