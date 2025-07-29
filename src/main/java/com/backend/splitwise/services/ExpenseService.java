package com.backend.splitwise.services;

import com.backend.splitwise.dto.ExpenseDTO;
import com.backend.splitwise.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseService {
    ExpenseDTO addExpense(ExpenseDTO expenseDetails);
}
