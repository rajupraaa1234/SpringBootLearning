package com.SpringBootLearning.SpringLearning.Repository;

import com.SpringBootLearning.SpringLearning.Entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationRepository extends JpaRepository<VerificationToken,Long> {

}
