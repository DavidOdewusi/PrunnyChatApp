package com.prunny.chatapp.controller;

import com.prunny.chatapp.dto.LoginDTO;
import com.prunny.chatapp.dto.UserDTO;
import com.prunny.chatapp.dto.UserResponseDTO;
import com.prunny.chatapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userServiceImpl;

    @PostMapping("signup")
    public ResponseEntity<UserResponseDTO> signUp(@RequestBody UserDTO userDTO) {
        return userServiceImpl.registerUser(userDTO);
    }

    @PostMapping("login")
    public  ResponseEntity<UserResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        return userServiceImpl.authenticateUser(loginDTO);
    }
}
