package com.jagger.jagger_monolith.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.jagger.jagger_monolith.Expense;

@Service
public class ExpenseService {

    private final List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void updateExpense(Expense updatedExpense) {
        expenses.removeIf(e -> e.getId().equals(updatedExpense.getId()));
        expenses.add(updatedExpense);
    }

    
}
