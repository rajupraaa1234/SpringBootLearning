package com.SpringBootLearning.SpringLearning.Controler;

import com.SpringBootLearning.SpringLearning.Entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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



}
