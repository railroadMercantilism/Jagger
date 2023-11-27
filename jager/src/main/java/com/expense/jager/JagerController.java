package com.expense.jager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/expenses")

public class JagerController {
    private final JagerService expenseService;
    
    public JagerController(JagerService expenseService) {
        this.expenseService = expenseService;
    }
    @GetMapping
    public String listExpenses(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        model.addAttribute("newExpense", new Jager());
        return "expenses";
    }
    @PostMapping("/add")
    public String addExpense(@ModelAttribute Jager newExpense) {
        expenseService.addExpense(newExpense);
        return "redirect:/expenses";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Jager expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return "editExpense";
    }
    @PostMapping("/update")
    public String updateExpense(@ModelAttribute Jager expense) {
        expenseService.updateExpense(expense);
        return "redirect:/expenses";
    }
    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Integer id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }

}
