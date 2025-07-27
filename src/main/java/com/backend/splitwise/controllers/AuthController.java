package com.backend.splitwise.controllers;

import com.backend.splitwise.dto.SignUpDTO;
import com.backend.splitwise.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<SignUpDTO> signUp(@RequestBody SignUpDTO signUpDTO) {
        SignUpDTO user = userService.signUp(signUpDTO);
        return ResponseEntity.ok(user);
    }

}
