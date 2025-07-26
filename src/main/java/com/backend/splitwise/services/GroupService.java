package com.backend.splitwise.services;

import com.backend.splitwise.dto.GroupDto;
import com.backend.splitwise.entities.Group;
import com.backend.splitwise.entities.User;

public interface GroupService {
    GroupDto createGroup(Group group);

    GroupDto addMemberToGroup(Long groupId, User user);
}
