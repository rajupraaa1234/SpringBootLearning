package com.SpringBootLearning.SpringLearning.Services;

import com.SpringBootLearning.SpringLearning.Entity.User;
import com.SpringBootLearning.SpringLearning.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveUserVerificationToken(User user, String token);
}
