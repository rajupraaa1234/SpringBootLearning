package com.SpringBootLearning.SpringLearning.Controler;

import com.SpringBootLearning.SpringLearning.Entity.Book;
import com.SpringBootLearning.SpringLearning.Services.BookServices;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksControler {
//    @RequestMapping(value = "/books",method = RequestMethod.GET)

    // Here you can use both RequestMapping & GetMapping both are same .
    @GetMapping("/books")
    public String getBooks(){
        return "Books list empty 12";
    }

    @GetMapping("/myBookData")         // Here Book Dao will automatically will change in json format . (Using jackson every response will automatically convert in json )
    public Book getMyBookData(){
        Book book =  new Book();
        book.setId(1);
        book.setTitle("Java");
        book.setAuthor("Raju");
        return book;
    }

    @Autowired
    private BookServices bookServices;     // AutoWired this will automatically initialised the object;
    @GetMapping("/myBookList")
    public List<Book> getBookList(){
        return bookServices.getBooksList();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int id){
        return bookServices.getBookById(id);
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        bookServices.addBooks(book);
        return book;
    }

    @DeleteMapping("/book/{id}")
    public int deleteBook(@PathVariable("id") int id){
        bookServices.deleteBook(id);
        return id;
    }

    @PutMapping("/book/{id}")
    public Book upDateBook(@RequestBody Book book , @PathVariable("id") int id){
        bookServices.updateBook(book,id);
        return book;
    }
}
