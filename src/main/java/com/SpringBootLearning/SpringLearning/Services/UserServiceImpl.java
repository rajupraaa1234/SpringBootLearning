package com.SpringBootLearning.SpringLearning.Services;

import com.SpringBootLearning.SpringLearning.Entity.User;
import com.SpringBootLearning.SpringLearning.Entity.VerificationToken;
import com.SpringBootLearning.SpringLearning.Repository.UserRepository;
import com.SpringBootLearning.SpringLearning.Repository.VerificationRepository;
import com.SpringBootLearning.SpringLearning.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

//    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private VerificationRepository verificationRepository;
    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setRole("USER");
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public void saveUserVerificationToken(User user, String token) {
        VerificationToken verificationToken = new VerificationToken();
        //verificationToken.setId(1234L);
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationToken.setExpirationTime(verificationToken.calculateExpirationDate(10));
        verificationRepository.save(verificationToken);
    }
}
