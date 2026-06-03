package com.lifeos.lifeos;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String name;

    public User(){}

    public Long getId(){return id;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String getName(){return name;}
}
