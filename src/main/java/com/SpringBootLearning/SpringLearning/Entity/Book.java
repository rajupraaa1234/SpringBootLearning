package com.SpringBootLearning.SpringLearning.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "books")
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


    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
