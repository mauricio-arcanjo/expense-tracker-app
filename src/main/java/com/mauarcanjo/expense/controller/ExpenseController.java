package com.mauarcanjo.expense.controller;

import com.mauarcanjo.expense.dto.ExpenseDto;
import com.mauarcanjo.expense.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Expense Resource",
        description = "CRUD REST APIs for Expense Resource - Create Expense" +
                "Update Expense, Get Expense and Delete Expense"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Operation(
            summary = "Create Expense REST API",
            description = "Create Expense REST API to save Expense into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){

        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense , HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Expense REST API",
            description = "Get Expense REST API to get Expense from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 Ok"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById (@PathVariable("id") Long expenseId){

        ExpenseDto expenseDto = expenseService.getExpenseById(expenseId);

        return new ResponseEntity<>(expenseDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Get all Expenses REST API",
            description = "Get all Expenses REST API to get all Expenses from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 Ok"
    )
    @GetMapping("/getall")
    public ResponseEntity<List<ExpenseDto>> getExpenseById (){

        List<ExpenseDto> expenses = expenseService.getAllExpenses();

        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Expense REST API",
            description = "Update Expense REST API to update Expense in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 Ok"
    )
    @PutMapping
    public ResponseEntity<ExpenseDto> updateExpense(@RequestBody ExpenseDto expenseDto){

        ExpenseDto savedExpense = expenseService.updateExpense(expenseDto);
        return new ResponseEntity<>(savedExpense , HttpStatus.CREATED);
    }

    @Operation(
            summary = "Delete Expense REST API",
            description = "Delete Expense REST API to Delete Expense from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 Ok"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long id){

        expenseService.deleteExpense(id);

        return ResponseEntity.ok("Expense sucessfuly deleted!");

    }


}
