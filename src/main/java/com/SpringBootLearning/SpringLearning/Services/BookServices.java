package com.SpringBootLearning.SpringLearning.Services;

import com.SpringBootLearning.SpringLearning.Entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component     // Here component will notify the SpringBoot that need to intialised BookService object for AutoWired object
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

    public Book getBookById(int id){
        try{
            Book myBook = bookList.stream().filter(e->e.getId() == id).findFirst().get();
            return myBook;
        }catch (Error error) {
            return null;
        }
    }

    public void addBooks(Book book){
        bookList.add(book);
    }
}
