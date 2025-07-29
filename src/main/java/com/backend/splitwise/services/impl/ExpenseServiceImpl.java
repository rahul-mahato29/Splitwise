package com.backend.splitwise.services.impl;

import com.backend.splitwise.dto.ExpenseDTO;
import com.backend.splitwise.entities.Expense;
import com.backend.splitwise.repositories.ExpenseRepository;
import com.backend.splitwise.services.ExpenseService;
import com.backend.splitwise.services.split.SplitFactory;
import com.backend.splitwise.services.split.SplitStrategy;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;
    private final SplitFactory splitFactory;

    @Override
    public ExpenseDTO addExpense(ExpenseDTO expenseDetails) {
        Expense expense = modelMapper.map(expenseDetails, Expense.class);

        //main-logic
        SplitStrategy splitStrategy = splitFactory.getSplitObject(expense.getTypes());
        splitStrategy.calculateSplit(expense.getSplitDetails(), expense.getAmount());

        expense = expenseRepository.save(expense);
        return modelMapper.map(expense, ExpenseDTO.class);
    }
}
