package com.backend.splitwise.services.Impl;

import com.backend.splitwise.dto.GroupDTO;
import com.backend.splitwise.entities.Group;
import com.backend.splitwise.entities.User;
import com.backend.splitwise.exceptions.ResourceNotFoundException;
import com.backend.splitwise.repositories.GroupRepository;
import com.backend.splitwise.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final ModelMapper modelMapper;

    @Override
    public GroupDTO createGroup(Group group) {
        Group newGroup = groupRepository.save(group);

        return modelMapper.map(newGroup, GroupDTO.class);
    }

    @Override
    public GroupDTO addMemberToGroup(Long groupId, User user) {
        return null;
    }

    @Override
    public GroupDTO getGroupById(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Group Not Found with Id : "+id));
        return modelMapper.map(group, GroupDTO.class);
    }

    @Override
    public List<GroupDTO> getAllGroup() {
        List<Group> allGroup = groupRepository.findAll();
        return allGroup
                .stream()
                .map(group -> modelMapper.map(group, GroupDTO.class))
                .collect(Collectors.toList());
    }
}
