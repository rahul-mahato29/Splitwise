package com.backend.splitwise.services;

import com.backend.splitwise.dto.SignUpDTO;
import com.backend.splitwise.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    SignUpDTO signUp(SignUpDTO signUpDTO);

    List<UserDTO> getAllUser();

    UserDTO getUserById(Long id);

    UserDTO updateUserById(Long id, Map<String, Object> updates);
}
