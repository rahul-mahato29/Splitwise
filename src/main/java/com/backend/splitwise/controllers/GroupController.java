package com.backend.splitwise.controllers;

import com.backend.splitwise.dto.GroupDto;
import com.backend.splitwise.entities.Group;
import com.backend.splitwise.entities.User;
import com.backend.splitwise.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupDto> createGroup(@RequestBody Group group) {
        GroupDto newGroup = groupService.createGroup(group);
        return ResponseEntity.ok(newGroup);
    }

    @PostMapping(path = "/{groupId}/member")
    public ResponseEntity<GroupDto> addMemberToGroup(@PathVariable Long groupId, @RequestBody User user) {
        GroupDto member = groupService.addMemberToGroup(groupId, user);
        return ResponseEntity.ok(member);
    }
}
