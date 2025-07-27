package com.backend.splitwise.services.Impl;

import com.backend.splitwise.dto.SignUpDTO;
import com.backend.splitwise.dto.UserDTO;
import com.backend.splitwise.repositories.UserRepository;
import com.backend.splitwise.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public SignUpDTO signUp(SignUpDTO signUpDTO) {
        return null;
    }
}
