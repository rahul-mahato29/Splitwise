package com.backend.splitwise.services;

import com.backend.splitwise.dto.GroupDTO;
import com.backend.splitwise.entities.Group;
import com.backend.splitwise.entities.User;

import java.util.List;

public interface GroupService {
    GroupDTO createGroup(Group group);

    GroupDTO addMemberToGroup(Long groupId, User user);

    GroupDTO getGroupById(Long id);

    List<GroupDTO> getAllGroup();
}
