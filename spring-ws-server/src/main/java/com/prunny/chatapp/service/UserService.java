package com.prunny.chatapp.service;

import com.prunny.chatapp.dto.LoginDTO;
import com.prunny.chatapp.dto.UserDTO;
import com.prunny.chatapp.dto.UserResponseDTO;
import com.prunny.chatapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ResponseEntity<UserResponseDTO> registerUser(UserDTO userDTO);
    ResponseEntity<UserResponseDTO> authenticateUser(LoginDTO loginDTO);
}
