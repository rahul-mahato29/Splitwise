package com.backend.splitwise.controllers;

import com.backend.splitwise.dto.ExpenseDTO;
import com.backend.splitwise.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/expense")
public class GroupExpenseController {

    private final ExpenseService expenseService;

    //1. Create (Add) Expense
    //      - can be created through group
    //      - can be created directly (Individual-Friend)
    //      - each expense will have info : pass to expense controller to create/add expense
    //              - Amount, paidBy, SplitType , List of Splits
    @PostMapping
    public ResponseEntity<ExpenseDTO> addExpense(@RequestBody ExpenseDTO expenseDetails) {
        ExpenseDTO expense = expenseService.addExpense(expenseDetails);
        return ResponseEntity.ok(expense);
    }


    //2. Update Expense

    //3. Delete Expense
}
