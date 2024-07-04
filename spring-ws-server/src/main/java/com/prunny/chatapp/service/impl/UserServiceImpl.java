package com.prunny.chatapp.service.impl;


import com.prunny.chatapp.dto.LoginDTO;
import com.prunny.chatapp.dto.UserDTO;
import com.prunny.chatapp.dto.UserResponseDTO;
import com.prunny.chatapp.model.User;
import com.prunny.chatapp.repository.UserRepository;
import com.prunny.chatapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<UserResponseDTO> registerUser(UserDTO userDTO) {
        User user = mapUserDtoToUser(userDTO);
        User savedUser = userRepository.save(user);

        UserResponseDTO userResponseDTO;
        if (savedUser.getId() != null) {
             userResponseDTO = UserResponseDTO.builder()
                    .username(userDTO.getUsername())
                    .status("Success")
                    .build();
            return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
        } else {
            userResponseDTO = UserResponseDTO.builder()
                    .username(userDTO.getUsername())
                    .status("Success")
                    .build();
            return new ResponseEntity<>(userResponseDTO, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<UserResponseDTO> authenticateUser(LoginDTO loginDTO) {
        Optional<User> optionalUser = userRepository.findByUsername(loginDTO.getUsername());

        UserResponseDTO userResponseDTO;
        if (optionalUser.isPresent()) {
            userResponseDTO = UserResponseDTO.builder()
                    .username(loginDTO.getUsername())
                    .status("Success")
                    .build();
            return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
        } else {
            userResponseDTO = UserResponseDTO.builder()
                    .username(loginDTO.getUsername())
                    .status("Success")
                    .build();
            return new ResponseEntity<>(userResponseDTO, HttpStatus.BAD_REQUEST);
        }
    }

    public User mapUserDtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());

        return user;
    }
}
