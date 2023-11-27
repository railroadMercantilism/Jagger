package com.expense.jager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Jager {
    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer id;
    private BigDecimal amount;
    private String description;
    private LocalDate date;

    public Jager() {
        this.id = count.incrementAndGet();
        this.date = LocalDate.now();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public static AtomicInteger getCount() {
        return count;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
