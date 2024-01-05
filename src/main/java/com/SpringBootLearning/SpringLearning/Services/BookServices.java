package com.SpringBootLearning.SpringLearning.Services;

import com.SpringBootLearning.SpringLearning.Repository.BookRepository;
import com.SpringBootLearning.SpringLearning.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component     // Here component will notify the SpringBoot that need to intialised BookService object for AutoWired object
public class BookServices {

    @Autowired
    private BookRepository bookList;
    public List<Book> getBooksList() {
        List<Book> myList = (List<Book>) this.bookList.findAll();
        return myList;
    }
    public Book getBookById(int id){
        try{
            Book myBook = bookList.findById(id);
            return myBook;
        }catch (Error error) {
            return null;
        }
    }

    public void addBooks(Book book){
        bookList.save(book);
    }

    public void deleteBook(int id){
         bookList.deleteById(id);
    }

    public void updateBook(Book book,int id){
        book.setId(id);
        bookList.save(book);
    }
}
