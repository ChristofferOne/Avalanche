package com.avalanche.hotel;

import com.avalanche.hotel.Entities.MoneyEntity;
import com.avalanche.hotel.Http.ExchangeCurrency;
import com.avalanche.hotel.primitives.Money;
import com.avalanche.hotel.primitives.Room;
import com.avalanche.hotel.primitives.RoomNumber;

import java.util.Currency;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Currency eur = Currency.getInstance("EUR");
        Currency gbp = Currency.getInstance("GBP");
        Money money = new Money(200, eur);
        money.exchangeCurrency(gbp);

        System.out.println(money.getMoney().getAmount());
    }
}
