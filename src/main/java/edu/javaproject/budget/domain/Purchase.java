package edu.javaproject.budget.domain;



import java.math.BigDecimal;

public class Purchase {

    private final String name;
    private final BigDecimal value;

    public Purchase(String name, BigDecimal value) {
        this.name = name;
        this.value = value;

    }

    public BigDecimal getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " $" + value;
    }


}
