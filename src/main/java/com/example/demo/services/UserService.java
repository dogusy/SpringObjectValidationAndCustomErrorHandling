package com.example.demo.services;

import com.example.demo.dto.UserRequest;
import com.example.demo.validators.ObjectValidator;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ObjectValidator userRequestObjectValidator;

    public UserService(ObjectValidator userRequestObjectValidator) {
        this.userRequestObjectValidator = userRequestObjectValidator;
    }

    public String changeUserActiveness(UserRequest userRequest) {
            userRequestObjectValidator.validate(userRequest);
            String reponseMsg =    "User with Name << "+
                    userRequest.getName()+
                    " >> is now "+
                    (userRequest.getActive() ? "active" : "inactive");
            return reponseMsg;
    }
}
