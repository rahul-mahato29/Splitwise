package com.backend.splitwise.controllers;

import com.backend.splitwise.dto.UserDTO;
import com.backend.splitwise.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<UserDTO> allUsers = userService.getAllUser();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "userId") Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping(path = "/{userId}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable(name = "userId") Long id,
                                                  @RequestBody Map<String, Object> updates) {
        UserDTO user = userService.updateUserById(id, updates);
        return ResponseEntity.ok(user);
    }
}
