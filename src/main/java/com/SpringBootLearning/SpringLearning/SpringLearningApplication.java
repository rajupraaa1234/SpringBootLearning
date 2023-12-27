package com.SpringBootLearning.SpringLearning;

import com.SpringBootLearning.SpringLearning.Dao.UserRepository;
import com.SpringBootLearning.SpringLearning.Entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringLearningApplication {

	public static void main(String[] args) {
		System.out.println("application started ...");
		ApplicationContext context =  SpringApplication.run(SpringLearningApplication.class, args);
		UserRepository repository = (UserRepository) context.getBean(UserRepository.class);
//		User user = new User();
//		user.setName("Raju kumar");
//		user.setCity("Hyderabad");
//		user.setStatus("Processing");
//		User response = repository.save(user);
//		System.out.println(response);
	}

}
