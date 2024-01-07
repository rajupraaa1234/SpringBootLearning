package com.SpringBootLearning.SpringLearning.Event.Listner;

import com.SpringBootLearning.SpringLearning.Entity.User;
import com.SpringBootLearning.SpringLearning.Event.RegistrationCompleteEvent;
import com.SpringBootLearning.SpringLearning.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j             // Annotation for print logger (log.info());
public class RegistrationCompleteEventListner implements ApplicationListener<RegistrationCompleteEvent> {


    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verification Token for the User with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveUserVerificationToken(user,token);

        String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;
        log.info("Click on Url to verify :{}",url);
    }
}
