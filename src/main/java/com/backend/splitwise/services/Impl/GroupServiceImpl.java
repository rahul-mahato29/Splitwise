package com.backend.splitwise.services.Impl;

import com.backend.splitwise.dto.GroupDto;
import com.backend.splitwise.entities.Group;
import com.backend.splitwise.entities.User;
import com.backend.splitwise.repositories.GroupRepository;
import com.backend.splitwise.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final ModelMapper modelMapper;

    @Override
    public GroupDto createGroup(Group group) {
        Group newGroup = groupRepository.save(group);

        return modelMapper.map(newGroup, GroupDto.class);
    }

    @Override
    public GroupDto addMemberToGroup(Long groupId, User user) {
        return null;
    }
}
