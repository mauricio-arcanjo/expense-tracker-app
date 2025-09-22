package com.mauarcanjo.expense.service;

import com.mauarcanjo.expense.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);
    ExpenseDto getExpenseById(Long id);
    List<ExpenseDto> getAllExpenses();
    ExpenseDto updateExpense(ExpenseDto expenseDto);
    void deleteExpense(Long id);

}
