package com.SpringBootLearning.SpringLearning.Services;

import com.SpringBootLearning.SpringLearning.Entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServices {
    public static List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(1,"Java","Raju"));
        bookList.add(new Book(2,"C++","Rahul kumar"));
        bookList.add(new Book(3,"JavaScript","Rockey Kumar"));
        bookList.add(new Book(4,"Python","Raja"));
    }

    public List<Book> getBooksList() {
        return bookList;
    }
}
