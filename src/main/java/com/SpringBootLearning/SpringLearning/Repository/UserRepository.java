package com.SpringBootLearning.SpringLearning.Repository;

import com.SpringBootLearning.SpringLearning.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
