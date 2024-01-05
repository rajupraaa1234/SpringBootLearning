package com.SpringBootLearning.SpringLearning.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "books")
@Setter
@Getter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;
    private String title;

//   CascadeType.ALL propagates all operations — including Hibernate-specific ones — from a parent to a child entity
    // It will delete the child data automatically when parent data vanish
    //OneToOne is a uni direction mapping

//    Bi-directional relationships in object models can lead to issues when serializing to JSON. Jackson, with its @JsonManagedReference and @JsonBackReference annotations, provides an elegant solution to this problem. When used correctly, these annotations can ensure that your JSON is structured as intended without running into infinite recursion issues
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;

}
