package com.example.Expense_Split.Controller;

import com.example.Expense_Split.DTO.ExpenseRequestDTO;
import com.example.Expense_Split.DTO.ExpenseResponseDTO;
import com.example.Expense_Split.Service.ExpensesService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    private final ExpensesService expensesService;

    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }


    @GetMapping("/test")
    public String test() {
        return "Expense API Working!";
    }

    //  Add Expense (Auto Split)
    @PostMapping("/add")
    public ResponseEntity<ExpenseResponseDTO> addExpense(
            @Valid @RequestBody ExpenseRequestDTO request) {

        return ResponseEntity.ok(expensesService.addExpense(request));
    }
}
