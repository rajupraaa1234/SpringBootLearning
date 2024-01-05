package com.SpringBootLearning.SpringLearning;

import com.SpringBootLearning.SpringLearning.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringLearningApplication {
	public static void main(String[] args) {
		System.out.println("application started ...");
		ApplicationContext context =  SpringApplication.run(SpringLearningApplication.class, args);
		UserRepository repository = (UserRepository) context.getBean(UserRepository.class);
	}
}
