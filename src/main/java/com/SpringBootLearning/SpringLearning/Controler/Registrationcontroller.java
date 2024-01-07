package com.SpringBootLearning.SpringLearning.Controler;

import com.SpringBootLearning.SpringLearning.Entity.User;
import com.SpringBootLearning.SpringLearning.Event.RegistrationCompleteEvent;
import com.SpringBootLearning.SpringLearning.Services.UserService;
import com.SpringBootLearning.SpringLearning.model.UserModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Registrationcontroller {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;
    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel , final HttpServletRequest request){
            User user = userService.registerUser(userModel);
            publisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));
        return "Success";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() +":"+request.getServerPort()+request.getContextPath();
    }

    @GetMapping("/message")
    public String getMsg(){
        return "Hi Raju";
    }
}
