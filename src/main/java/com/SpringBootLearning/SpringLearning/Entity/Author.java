package com.SpringBootLearning.SpringLearning.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String language;

    // Here we are doing bi-directional mapping that's why i have added OneToOne mapping anotation in both (Parent-Book& Child-Author)
    // mappedBy : Used for not creating extra filed in the table. Here i have added author because in book table author_id filed automatically created so i want to manage with this field only for By-directional mapping
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;

    public Author(int id, String name, String language) {
        this.id = id;
        this.name = name;
        this.language = language;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public Author() {
    }
}
