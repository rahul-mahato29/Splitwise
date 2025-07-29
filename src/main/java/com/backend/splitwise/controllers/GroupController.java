package com.backend.splitwise.controllers;

import com.backend.splitwise.dto.AddMemberDTO;
import com.backend.splitwise.dto.GroupDTO;
import com.backend.splitwise.entities.Group;
import com.backend.splitwise.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupDTO> createGroup(@RequestBody GroupDTO group) {
        GroupDTO newGroup = groupService.createGroup(group);
        return ResponseEntity.ok(newGroup);
    }

    @PostMapping(path = "/{groupId}/member/add")
    public ResponseEntity<String> addMemberToGroup(@PathVariable Long groupId, @RequestBody AddMemberDTO addMemberDTO) {
        groupService.addMemberToGroup(groupId, addMemberDTO);
        return ResponseEntity.ok("User added to group");
    }

    @PostMapping(path = "/{groupId}/member/leave")
    public ResponseEntity<String> leaveFromGroup(@PathVariable Long groupId, @RequestBody AddMemberDTO addMemberDTO) {
        groupService.leaveFromGroup(groupId, addMemberDTO);
        return ResponseEntity.ok("User leaved the group");
    }

    @GetMapping(path = "/{groupId}")
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable(name = "groupId") Long id) {
        GroupDTO groupDetail = groupService.getGroupById(id);
        return ResponseEntity.ok(groupDetail);
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAllGroup() {
        List<GroupDTO> allGroup = groupService.getAllGroup();
        return ResponseEntity.ok(allGroup);
    }

    @PatchMapping(path = "/{groupId}")
    public ResponseEntity<GroupDTO> updateGroupDetailsById(@PathVariable(name = "groupId") Long id,
                                                       @RequestBody Map<String, Object> updates) {
        GroupDTO group = groupService.updateGroupDetailsById(id, updates);
        return ResponseEntity.ok(group);
    }
}
