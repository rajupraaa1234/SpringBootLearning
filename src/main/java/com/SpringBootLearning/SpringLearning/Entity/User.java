package com.SpringBootLearning.SpringLearning.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(length = 60) // this is validation telling that max password length will be 60
    private String password;
    private String role;
}
