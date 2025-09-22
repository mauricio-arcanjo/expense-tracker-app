package com.mauarcanjo.expense.controller;

import com.mauarcanjo.expense.dto.ExpenseDto;
import com.mauarcanjo.expense.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){

        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById (@PathVariable("id") Long expenseId){

        ExpenseDto expenseDto = expenseService.getExpenseById(expenseId);

        return new ResponseEntity<>(expenseDto, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ExpenseDto>> getExpenseById (){

        List<ExpenseDto> expenses = expenseService.getAllExpenses();

        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ExpenseDto> updateExpense(@RequestBody ExpenseDto expenseDto){

        ExpenseDto savedExpense = expenseService.updateExpense(expenseDto);
        return new ResponseEntity<>(savedExpense , HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long id){

        expenseService.deleteExpense(id);

        return ResponseEntity.ok("Expense sucessfuly deleted!");

    }


}
