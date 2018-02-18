package com.avalanche.hotel.primitives;

import com.avalanche.hotel.Entities.MoneyEntity;
import com.avalanche.hotel.Exceptions.NegativeIntegerException;
import org.junit.Test;

import java.util.Currency;

import static junit.framework.TestCase.assertEquals;

public class MoneyTest {
    private Currency testCurrency = Currency.getInstance("EUR");

    @Test(expected = NegativeIntegerException.class)
    public void testMoneyNegativeAmount() {
        new Money(-10, testCurrency);
    }

    @Test(expected = NegativeIntegerException.class)
    public void testMoneyZeroAmount() {
        new Money(0, testCurrency);
    }

    @Test
    public void testMoneyGetEntity() {
        Money money = new Money(100, testCurrency);
        MoneyEntity moneyEntity = money.getMoney();

        MoneyEntity comparisonEntity = new MoneyEntity(testCurrency, 100);

        assertEquals(comparisonEntity.getAmount(), moneyEntity.getAmount());
        assertEquals(comparisonEntity.getCurrency().getCurrencyCode(), moneyEntity.getCurrency().getCurrencyCode());
    }

    @Test
    public void testExchangeCurrency() {

    }
}
