package com.backend.splitwise.services.Impl;

import com.backend.splitwise.dto.SignUpDTO;
import com.backend.splitwise.dto.UserDTO;
import com.backend.splitwise.entities.User;
import com.backend.splitwise.repositories.UserRepository;
import com.backend.splitwise.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignUpDTO signUp(SignUpDTO signUpDTO) {
        Optional<User> user =  userRepository.findByEmail(signUpDTO.getEmail());
        if(user.isPresent()) {
            throw new BadCredentialsException("User with this email already exists : "+signUpDTO.getEmail());
        }

        User toBeCreatedUser = modelMapper.map(signUpDTO, User.class);
        toBeCreatedUser.setPassword(passwordEncoder.encode(toBeCreatedUser.getPassword()));
        User savedUser = userRepository.save(toBeCreatedUser);

        return modelMapper.map(savedUser, SignUpDTO.class);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> allUsers = userRepository.findAll();
        return allUsers
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
}
