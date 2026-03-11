package com.example.Expense_Split.Repository;

import com.example.Expense_Split.Entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {
}
