package com.example.demo.contollers;


import com.example.demo.dto.UserRequest;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> changeUserActiveness(@RequestBody UserRequest userRequest) {

        return ResponseEntity.accepted().body(userService.changeUserActiveness(userRequest));
    }

}
