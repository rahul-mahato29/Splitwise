package com.backend.splitwise.services;

import com.backend.splitwise.dto.SignUpDTO;
import com.backend.splitwise.dto.UserDTO;

import java.util.List;

public interface UserService {
    SignUpDTO signUp(SignUpDTO signUpDTO);

    List<UserDTO> getAllUser();
}
