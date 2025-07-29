package com.backend.splitwise.dto;

import com.backend.splitwise.entities.Enum.SplitType;
import com.backend.splitwise.entities.Split;
import com.backend.splitwise.entities.User;
import lombok.Data;

import java.util.List;

@Data
public class ExpenseDTO {

    private String description;
    private double amount;
    private User paidBy;
    private SplitType types;
    List<Split> splitDetails;
}
