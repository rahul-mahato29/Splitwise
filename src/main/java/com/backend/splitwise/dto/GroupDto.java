package com.backend.splitwise.dto;

import com.backend.splitwise.entities.User;

import lombok.Data;

import java.util.List;

@Data
public class GroupDto {

    private long id;
    private String name;
    private String description;
    private String imageUrl;
    List<User> members;
}
