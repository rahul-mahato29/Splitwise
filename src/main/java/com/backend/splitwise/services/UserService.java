package com.backend.splitwise.services;

import com.backend.splitwise.dto.SignUpDTO;
import com.backend.splitwise.dto.UserDTO;

public interface UserService {
    SignUpDTO signUp(SignUpDTO signUpDTO);
}
