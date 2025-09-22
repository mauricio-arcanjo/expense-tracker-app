package com.mauarcanjo.expense.service.impl;

import com.mauarcanjo.expense.dto.ExpenseDto;
import com.mauarcanjo.expense.entity.Category;
import com.mauarcanjo.expense.entity.Expense;
import com.mauarcanjo.expense.exceptions.ResourceNotFoundException;
import com.mauarcanjo.expense.mapper.CategoryMapper;
import com.mauarcanjo.expense.mapper.ExpenseMapper;
import com.mauarcanjo.expense.repository.CategoryRepository;
import com.mauarcanjo.expense.repository.ExpenseRepository;
import com.mauarcanjo.expense.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@AllArgsConstructor //Dependence injection for expenseRepository
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    public ExpenseDto createExpense(ExpenseDto expenseDto) {

        Expense expense = ExpenseMapper.mapToExpense(expenseDto);
        return ExpenseMapper
                .mapToExpenseDto(
                        expenseRepository.save(expense)
                );
    }

    public ExpenseDto getExpenseById(Long id) {

        Expense expense = getExpense(id);

        return ExpenseMapper.mapToExpenseDto(expense);
    }

    public List<ExpenseDto> getAllExpenses() {

        return expenseRepository
                .findAll()
                .stream()
                .map(ExpenseMapper::mapToExpenseDto)
                .toList();
    }

    @Transactional
    public ExpenseDto updateExpense(ExpenseDto expenseDto) {

        Expense expense = getExpense(expenseDto.id());

        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());

        if (expenseDto.categoryDto() != null){
            Category category = categoryRepository.findById(
                    expenseDto.categoryDto().id())
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Category not found with id: " + expenseDto.categoryDto().id())
                    );

            expense.setCategory(category);
        }

        return ExpenseMapper.mapToExpenseDto(expense);
    }

    public void deleteExpense(Long id) {
        Expense expense = getExpense(id);
        expenseRepository.delete(expense);
    }

    private Expense getExpense (Long id){
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
    }

}
