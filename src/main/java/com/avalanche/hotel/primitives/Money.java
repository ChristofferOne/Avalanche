package com.avalanche.hotel.primitives;

import com.avalanche.hotel.Entities.MoneyEntity;
import com.avalanche.hotel.Exceptions.NegativeIntegerException;
import com.avalanche.hotel.Http.ExchangeCurrency;

import java.util.Currency;

public class Money {
    private float amount;
    private Currency currency;

    public Money(float amount, Currency currency) {
        if (amount < 1) {
            throw new NegativeIntegerException("Money amount cannot be negative or zero");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public void exchangeCurrency(Currency to) {
        MoneyEntity entity = new MoneyEntity(this.currency, this.amount);
        MoneyEntity exchanged = ExchangeCurrency.exchange(entity, to);

        this.amount = exchanged.getAmount();
        this.currency = exchanged.getCurrency();
    }

    public MoneyEntity getMoney() {
        return new MoneyEntity(this.currency, this.amount);
    }
}
