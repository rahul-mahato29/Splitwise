package com.backend.splitwise.services;

import com.backend.splitwise.dto.AddMemberDTO;
import com.backend.splitwise.dto.GroupDTO;
import com.backend.splitwise.entities.Group;
import com.backend.splitwise.entities.User;

import java.util.List;
import java.util.Map;

public interface GroupService {
    GroupDTO createGroup(Group group);

    void addMemberToGroup(Long groupId, AddMemberDTO addMemberDTO);

    void leaveFromGroup(Long groupId, AddMemberDTO addMemberDTO);

    GroupDTO getGroupById(Long id);

    List<GroupDTO> getAllGroup();

    GroupDTO updateGroupDetailsById(Long id, Map<String, Object> updates);
}
