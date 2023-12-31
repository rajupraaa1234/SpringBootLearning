package com.SpringBootLearning.SpringLearning.Controler;

import com.SpringBootLearning.SpringLearning.Entity.Book;
import com.SpringBootLearning.SpringLearning.Services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        book.setAuthor(null);
        return book;
    }

    @Autowired
    private BookServices bookServices;     // AutoWired this will automatically initialised the object;
    @GetMapping("/myBookList")
    public List<Book> getBookList(){
        return bookServices.getBooksList();
    }

    // Here ResponseEntity is a generic type which is used for http error code handling
    @GetMapping("/books/{id}")
    public ResponseEntity<Book>  getBookById(@PathVariable("id") int id){
        Book book = null;
        try{
            book = bookServices.getBookById(id);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        bookServices.addBooks(book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        try{
            bookServices.deleteBook(id);
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception error){
            error.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/book/{id}")
    public Book upDateBook(@RequestBody Book book , @PathVariable("id") int id){
        bookServices.updateBook(book,id);
        return book;
    }
}
