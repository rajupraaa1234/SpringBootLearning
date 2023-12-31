package com.SpringBootLearning.SpringLearning.Dao;

import com.SpringBootLearning.SpringLearning.Entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
