package com.mauarcanjo.expense.repository;

import com.mauarcanjo.expense.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
