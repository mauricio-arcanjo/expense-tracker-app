package com.mauarcanjo.expense.mapper;

import com.mauarcanjo.expense.dto.CategoryDto;
import com.mauarcanjo.expense.dto.ExpenseDto;
import com.mauarcanjo.expense.entity.Category;
import com.mauarcanjo.expense.entity.Expense;

public class ExpenseMapper {

    public static Expense mapToExpense(ExpenseDto expenseDto){

        return new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                new Category(
                        expenseDto.categoryDto().id(),
                        expenseDto.categoryDto().name()
                )
        );
    }

    public static ExpenseDto mapToExpenseDto(Expense expense){

        return new ExpenseDto(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }

}
