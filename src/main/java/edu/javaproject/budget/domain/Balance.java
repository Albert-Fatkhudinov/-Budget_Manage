package edu.javaproject.budget.domain;

import edu.javaproject.budget.util.Util;

import java.io.IOException;
import java.math.BigDecimal;

public class Balance {

    private BigDecimal balance = new BigDecimal("0").setScale(2);
    private static Balance instance;

    private Balance() {

    }

    public static Balance newInstance() {
        if (instance == null) {
            instance = new Balance();
        }
        return instance;
    }

    public void addBalance() throws IOException {
        String value = Util.readString();
        double money = Double.parseDouble(value);
        if (money > 0.0) {
            balance = balance.add(new BigDecimal(value).setScale(2));
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
