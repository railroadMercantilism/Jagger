package com.jagger.jagger_monolith.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jagger.jagger_monolith.Expense;
import com.jagger.jagger_monolith.Service.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public String listExpenses(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        model.addAttribute("newExpense", new Expense());
        return "expenses";
    }

    @PostMapping("/add")
    public String addExpense(@ModelAttribute Expense newExpense) {
        expenseService.addExpense(newExpense);
        return "redirect:/expenses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return "editExpense";
    }

    @PostMapping("/update")
    public String updateExpense(@ModelAttribute Expense expense) {
        expenseService.updateExpense(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Integer id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
}
