package com.SpringBootLearning.SpringLearning.Repository;

import com.SpringBootLearning.SpringLearning.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

}
