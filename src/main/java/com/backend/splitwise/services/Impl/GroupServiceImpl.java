package com.backend.splitwise.services.Impl;

import com.backend.splitwise.dto.AddMemberDTO;
import com.backend.splitwise.dto.GroupDTO;
import com.backend.splitwise.entities.Group;
import com.backend.splitwise.entities.User;
import com.backend.splitwise.exceptions.ResourceNotFoundException;
import com.backend.splitwise.repositories.GroupRepository;
import com.backend.splitwise.repositories.UserRepository;
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
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public GroupDTO createGroup(Group group) {
        Group newGroup = groupRepository.save(group);
        return modelMapper.map(newGroup, GroupDTO.class);
    }

    @Override
    public void addMemberToGroup(Long groupId, AddMemberDTO addMemberDTO) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("Group Not Found with Id : "+groupId));
        User user = userRepository.findById(addMemberDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found with Id : "+addMemberDTO.getUserId()));

        if(!group.getMembers().contains(user)) {
            group.getMembers().add(user);
            groupRepository.save(group);
        }
        else {
            throw new IllegalStateException("User is already a member of the group");
        }
    }

    @Override
    public void leaveFromGroup(Long groupId, AddMemberDTO addMemberDTO) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("Group Not Found With Id : "+groupId));
        User user = userRepository.findById(addMemberDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found With Id : "+addMemberDTO.getUserId()));

        if(group.getMembers().contains(user)) {
            group.getMembers().remove(user);
            groupRepository.save(group);
        }
        else {
            throw new IllegalStateException("User is not present in the group");
        }
    }

    @Override
    public GroupDTO getGroupById(Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Group Not Found with Id : "+id));
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
