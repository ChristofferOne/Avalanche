package com.avalanche.hotel.Entities;

import com.avalanche.hotel.Exceptions.NegativeIntegerException;

import java.util.Currency;

public class MoneyEntity {
    private Currency currency;
    private float amount;

    public MoneyEntity(Currency currency, float amount) {
        if (amount < 1) {
            throw new NegativeIntegerException("Money amount cannot be negative or zero");
        }

        this.currency = currency;
        this.amount = amount;
    }

    public float getAmount() {
        return this.amount;
    }

    public Currency getCurrency() {
        return this.currency;
    }
}
