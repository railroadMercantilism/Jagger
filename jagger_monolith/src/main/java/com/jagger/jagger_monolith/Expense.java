package com.jagger.jagger_monolith;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Expense {

    private static final AtomicInteger count = new AtomicInteger();
    private Integer id;
    private float amount;
    private String description;
    private LocalDate date;

    public Expense() {
        this.id = count.incrementAndGet();
        this.date = LocalDate.now();
    }

    public Expense(float amount, String description) {
        this.id = count.incrementAndGet();
        this.amount = amount;
        this.description = description;
        this.date = LocalDate.now();
    }

    public static AtomicInteger getCount() {
        return count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    
}
