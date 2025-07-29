package com.backend.splitwise.services;

import com.backend.splitwise.dto.AddMemberDTO;
import com.backend.splitwise.dto.GroupDTO;

import java.util.List;
import java.util.Map;

public interface GroupService {
    GroupDTO createGroup(GroupDTO group);

    void addMemberToGroup(Long groupId, AddMemberDTO addMemberDTO);

    void leaveFromGroup(Long groupId, AddMemberDTO addMemberDTO);

    GroupDTO getGroupById(Long id);

    List<GroupDTO> getAllGroup();

    GroupDTO updateGroupDetailsById(Long id, Map<String, Object> updates);
}
