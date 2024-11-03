package org.example;

import java.time.LocalDate;
import java.util.Date;

public class ExpireProduct extends Products{

    private LocalDate expiryDate;

    public ExpireProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
