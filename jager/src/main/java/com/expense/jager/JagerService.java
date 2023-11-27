package com.expense.jager;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JagerService {
    private final List<Jager> expenses = new ArrayList<>();
    public List<Jager> getAllExpenses() {
        return new ArrayList<>(expenses);
    }
    public void addExpense(Jager expense) {
        expenses.add(expense);
    }
    public void updateExpense(Jager updatedExpense) {
        expenses.removeIf(e -> e.getId().equals(updatedExpense.getId()));
        expenses.add(updatedExpense);
    }
    public void deleteExpense(Integer expenseId) {
        expenses.removeIf(e -> e.getId().equals(expenseId));
    }
    public Jager getExpenseById(Integer expenseId) {
        return expenses.stream().filter(e -> e.getId().equals(expenseId)).findFirst().orElse(null);
    }
}
